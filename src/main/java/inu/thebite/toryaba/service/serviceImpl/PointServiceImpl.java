package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Point;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.entity.Student;
import inu.thebite.toryaba.model.point.AddPointRequest;
import inu.thebite.toryaba.repository.PointRepository;
import inu.thebite.toryaba.repository.StoRepository;
import inu.thebite.toryaba.repository.StudentRepository;
import inu.thebite.toryaba.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;
    private final StoRepository stoRepository;
    private final StudentRepository studentRepository;


    @Transactional
    @Override
    public void addPoint(Long stoId, Long studentId, AddPointRequest addPointRequest) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("해당 학생이 존재하지 않습니다."));

        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        // separate point list -> save each point
        List<String> points = addPointRequest.getPoints();

        for(String point: points) {
            Point createPoint = Point.createPoint(addPointRequest.getRound(), point, addPointRequest.getRegistrant(), sto, student);
            pointRepository.save(createPoint);
        }

    }
}
