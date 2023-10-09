package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.model.image.AddImageRequest;

public interface ImageService {
    Image addImage(AddImageRequest addImageRequest);

    void deleteImage(Long imageId);
}
