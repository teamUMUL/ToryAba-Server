package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.model.center.CenterRequest;
import inu.thebite.toryaba.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;

    // add center
    @PostMapping("/center/add")
    public ResponseEntity addCenter(@RequestBody CenterRequest centerRequest) {
        Center center = centerService.addCenter(centerRequest);
        return ResponseEntity.ok(center);
    }

    // delete center
    @DeleteMapping("/center/delete")
    public ResponseEntity deleteCenter(@RequestBody CenterRequest centerRequest) {
        centerService.deleteCenter(centerRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
