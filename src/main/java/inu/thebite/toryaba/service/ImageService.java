package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Category;
import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.model.image.AddImageRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image addImage(AddImageRequest addImageRequest);

    void deleteImage(Long imageId);

    String uploadImage(MultipartFile image, Category category);
}
