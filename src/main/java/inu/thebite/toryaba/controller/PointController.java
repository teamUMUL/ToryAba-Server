package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.model.point.AddPointRequest;
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
    @PostMapping("/sto/{stoId}/point/add")
    public ResponseEntity addPoint(@PathVariable Long stoId,
                                   @RequestBody AddPointRequest addPointRequest) {
        pointService.addPoint(stoId, addPointRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // get point list
    @GetMapping("/{studentId}/sto/{stoId}/{round}/point/list")
    public List<String> getPointList(@PathVariable Long stoId,
                                       @PathVariable Long studentId,
                                       @PathVariable int round) {
        List<String> pointList = pointService.getPointList(stoId, studentId, round);
        return pointList;
    }
}
