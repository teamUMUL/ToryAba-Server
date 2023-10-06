package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.entity.Class;
import inu.thebite.toryaba.model.center.AddClassRequest;
import inu.thebite.toryaba.repository.CenterRepository;
import inu.thebite.toryaba.repository.ClassRepository;
import inu.thebite.toryaba.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final CenterRepository centerRepository;

    @Transactional
    @Override
    public Class addClass(String centerName, AddClassRequest addClassRequest) {
        Center center = centerRepository.findByName(centerName)
                .orElseThrow(() -> new IllegalStateException("해당하는 센터가 존재하지 않습니다."));

        Class newClass = Class.createClass(addClassRequest.getName(), center);
        classRepository.save(newClass);
        return newClass;
    }


    @Override
    public List<Class> getClassList(String centerName) {
        centerRepository.findByName(centerName)
                .orElseThrow(() -> new IllegalStateException("해당하는 센터가 존재하지 않습니다."));

        List<Class> classList = classRepository.findAll();
        return classList;
    }

    @Transactional
    @Override
    public void deleteClass(String centerName, String className) {
        if(!centerRepository.findByName(centerName).isPresent()) {
            throw new IllegalStateException("해당하는 센터가 존재하지 않습니다.");
        } else {
            classRepository.deleteByClassName(className);
        }
    }
}
