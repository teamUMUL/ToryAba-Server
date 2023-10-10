package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Point;
import inu.thebite.toryaba.model.point.AddPointRequest;

import java.util.List;

public interface PointService {
    void addPoint(Long stoId, Long studentId, AddPointRequest addPointRequest);

    List<String> getPointList(Long stoId, Long studentId, int round);
}
