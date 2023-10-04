package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.model.center.CenterRequest;

public interface CenterService {
    Center addCenter(CenterRequest centerRequest);

    void deleteCenter(CenterRequest centerRequest);
}
