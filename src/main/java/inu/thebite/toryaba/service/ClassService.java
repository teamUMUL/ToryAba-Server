package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Class;
import inu.thebite.toryaba.model.center.AddClassRequest;

import java.util.List;

public interface ClassService {
    Class addClass(Long centerId, AddClassRequest addClassRequest);

    void deleteClass(Long centerId, Long classId);

    List<Class> getClassList(Long centerId);
}
