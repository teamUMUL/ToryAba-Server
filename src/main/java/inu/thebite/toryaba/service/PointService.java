package inu.thebite.toryaba.service;

import inu.thebite.toryaba.model.point.AddPointRequest;

public interface PointService {
    void addPoint(Long stoId, AddPointRequest addPointRequest);
}
