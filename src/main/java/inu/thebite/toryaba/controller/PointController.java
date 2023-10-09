package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.model.point.AddPointRequest;
import inu.thebite.toryaba.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    // add point
    @PostMapping("/{stoId}/sto/point/add")
    public ResponseEntity addPoint(@PathVariable Long stoId, @RequestBody AddPointRequest addPointRequest) {
        pointService.addPoint(stoId, addPointRequest)
    }
}
