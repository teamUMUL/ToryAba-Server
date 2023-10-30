package inu.thebite.toryaba.service;

import inu.thebite.toryaba.model.point.AddPointRequest;
import inu.thebite.toryaba.model.point.UpdatePointRequest;

import java.util.List;

public interface PointService {
    void addPoint(Long stoId, AddPointRequest addPointRequest);

    List<String> getPointList(Long stoId);

    void updatePoint(Long stoId, UpdatePointRequest updatePointRequest);
}
