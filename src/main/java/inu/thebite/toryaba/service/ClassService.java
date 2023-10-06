package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Class;
import inu.thebite.toryaba.model.center.AddClassRequest;

import java.util.List;

public interface ClassService {
    Class addClass(String centerName, AddClassRequest addClassRequest);

    void deleteClass(String centerName, String className);

    List<Class> getClassList(String centerName);
}
