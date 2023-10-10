package inu.thebite.toryaba.service.serviceImpl;

import com.google.cloud.storage.*;
import inu.thebite.toryaba.entity.Category;
import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.model.image.AddImageRequest;
import inu.thebite.toryaba.repository.CategoryRepository;
import inu.thebite.toryaba.repository.ImageRepository;
import inu.thebite.toryaba.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;

    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    @Transactional
    @Override
    public Image addImage(AddImageRequest addImageRequest) {

        Category category = categoryRepository.findByName(addImageRequest.getCategoryName())
                .orElseThrow(() -> new IllegalStateException("해당 카테고리가 존재하지 않습니다."));

        String imageUrl = uploadImage(addImageRequest.getImage(), category);
        Image image = Image.createImage(imageUrl, category);
        imageRepository.save(image);
        return image;
    }

    @Transactional
    @Override
    public void deleteImage(Long imageId) {
        if(imageRepository.findById(imageId).isPresent()) {
            imageRepository.deleteById(imageId);

            // 클라우드에 저장되어 있는 사진도 삭제하는 로직 필요

        } else {
            throw new IllegalStateException("해당하는 이미지가 존재하지 않습니다.");
        }
    }

    @Override
    public String uploadImage(MultipartFile image, Category category) {

        Storage storage = StorageOptions.getDefaultInstance().getService();

        // 이미지 저장
        List<Image> result = imageRepository.findAllByCategoryId(category.getId());
        String number = Integer.toString(result.size() + 1);

        String name = category.getName() + "/" + category.getName() + "_" + number;
        String contentType = image.getContentType();

        try {
            BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, name).setContentType(contentType).build();
            Blob uploadImage = storage.createFrom(blobInfo, image.getInputStream());
            String imageUrl = uploadImage.getMediaLink();
            return imageUrl;

        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
