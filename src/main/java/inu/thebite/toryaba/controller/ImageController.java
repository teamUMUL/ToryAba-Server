package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.model.image.AddImageRequest;
import inu.thebite.toryaba.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    // add image (only one)
    @PostMapping("/image/add")
    public ResponseEntity addImage(AddImageRequest addImageRequest) {
        imageService.addImage(addImageRequest)
    }

    // delete image (only one)
    @DeleteMapping("/image/{imageId}/delete")
    public ResponseEntity deleteImage(@PathVariable Long imageId) {
        imageService.deleteImage(imageId)
    }

}
