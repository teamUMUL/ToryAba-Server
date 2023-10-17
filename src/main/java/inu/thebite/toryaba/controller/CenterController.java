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
    public Center addCenter(@RequestBody CenterRequest centerRequest) {
        Center center = centerService.addCenter(centerRequest);
        return center;
    }

    // update center
    @PatchMapping("/{centerId}/center/update")
    public Center updateCenter(@PathVariable Long centerId, @RequestBody CenterRequest centerRequest) {
        Center center = centerService.updateCenter(centerId, centerRequest);
        return center;
    }


    // delete center
    @DeleteMapping("/center/{centerId}/delete")
    public ResponseEntity deleteCenter(@PathVariable Long centerId) {
        centerService.deleteCenter(centerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // get center list
    @GetMapping("/center/list")
    public List<Center> getCenterList() {
        List<Center> centerList = centerService.getCenterList();
        return centerList;
    }
}
