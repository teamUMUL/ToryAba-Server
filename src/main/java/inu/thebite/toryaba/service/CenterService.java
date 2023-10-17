package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.model.center.CenterRequest;

import java.util.List;

public interface CenterService {
    Center addCenter(CenterRequest centerRequest);

    void deleteCenter(Long centerId);

    List<Center> getCenterList();

    Center updateCenter(Long centerId, CenterRequest centerRequest);
}
