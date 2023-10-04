package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Class;
import inu.thebite.toryaba.model.center.ClassRequest;

public interface ClassService {
    Class addClass(String centerName, ClassRequest classRequest);

    void deleteClass(String centerName, ClassRequest classRequest);
}
