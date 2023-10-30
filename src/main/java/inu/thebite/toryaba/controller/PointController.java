package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.entity.Point;
import inu.thebite.toryaba.model.point.AddPointRequest;
import inu.thebite.toryaba.model.point.UpdatePointRequest;
import inu.thebite.toryaba.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    // add point
    @PostMapping("/sto/{stoId}/points")
    public ResponseEntity addPoint(@PathVariable Long stoId,
                                   @RequestBody AddPointRequest addPointRequest) {
        pointService.addPoint(stoId, addPointRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // update point
    @PatchMapping("/sto/{stoId}/points")
    public ResponseEntity updatePoint(@PathVariable Long stoId, @RequestBody UpdatePointRequest updatePointRequest) {
        pointService.updatePoint(stoId, updatePointRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // get point list
    @GetMapping("/sto/{stoId}/point/list")
    public List<String> getPointList(@PathVariable Long stoId) {
        List<String> pointList = pointService.getPointList(stoId);
        return pointList;
    }
}
