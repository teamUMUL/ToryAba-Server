package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Point;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.point.AddPointRequest;
import inu.thebite.toryaba.model.point.UpdatePointRequest;
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
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        Point point = pointRepository.findByStoIdAndRound(stoId, sto.getRound())
                .orElseThrow(() -> new IllegalStateException("해당 STO에 대한 point list가 존재하지 않습니다."));

        point.addPoint(addPointRequest.getResult(), addPointRequest.getRegistrant());
    }

    @Transactional
    @Override
    public void updatePoint(Long stoId, UpdatePointRequest updatePointRequest) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        Point point = pointRepository.findByStoIdAndRound(stoId, sto.getRound())
                .orElseThrow(() -> new IllegalStateException("해당 STO에 대한 point list가 존재하지 않습니다."));

        point.updatePoint(updatePointRequest.getPoints(), updatePointRequest.getRegistrant());
    }

    @Override
    public List<String> getPointList(Long stoId) {

        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        List<String> pointList = pointRepository.findPointsByStoIdAndRound(sto.getId(), sto.getRound());
        return pointList;
    }
}
