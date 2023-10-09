package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.model.image.AddImageRequest;
import inu.thebite.toryaba.repository.ImageRepository;
import inu.thebite.toryaba.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Transactional
    @Override
    public Image addImage(AddImageRequest addImageRequest) {
       
        // storage에 저장하는 코드 필요

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
}
