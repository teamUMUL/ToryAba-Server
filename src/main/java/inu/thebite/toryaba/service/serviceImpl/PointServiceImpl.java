package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.model.point.AddPointRequest;
import inu.thebite.toryaba.repository.PointRepository;
import inu.thebite.toryaba.repository.StoRepository;
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

    @Transactional
    @Override
    public void addPoint(Long stoId, AddPointRequest addPointRequest) {
        stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        // separate point list
        List<String> points = addPointRequest.getPoints();
        
    }
}
