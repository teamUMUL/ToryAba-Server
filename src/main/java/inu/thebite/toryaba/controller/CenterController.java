package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.model.center.CenterRequest;
import inu.thebite.toryaba.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping("/center/{centerName}/delete")
    public ResponseEntity deleteCenter(@PathVariable String centerName) {
        centerService.deleteCenter(centerName);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // get center list
    @GetMapping("/center/list")
    public ResponseEntity getCenterList() {
        List<Center> centerList = centerService.getCenterList();
        return ResponseEntity.ok(centerList);
    }
}
