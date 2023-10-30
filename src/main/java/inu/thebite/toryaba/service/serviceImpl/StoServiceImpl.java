package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.entity.Point;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.*;
import inu.thebite.toryaba.repository.LtoRepository;
import inu.thebite.toryaba.repository.PointRepository;
import inu.thebite.toryaba.repository.StoRepository;
import inu.thebite.toryaba.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StoServiceImpl implements StoService {

    private final StoRepository stoRepository;
    private final LtoRepository ltoRepository;
    private final PointRepository pointRepository;

    @Transactional
    @Override
    public Sto addSto(Long ltoId, AddStoRequest addStoRequest) {
        Lto lto = ltoRepository.findById(ltoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));

        List<Sto> stoList = stoRepository.findAllByLtoId(lto.getId());

        Sto sto = Sto.createSto(stoList.size() + 1, addStoRequest.getName(), addStoRequest.getContents(),
                addStoRequest.getCount(), addStoRequest.getGoal(), addStoRequest.getUrgeType(),
                addStoRequest.getUrgeContent(), addStoRequest.getEnforceContent(), addStoRequest.getMemo(), lto);

        // when STO is made, point is made together.
        Point point = Point.createPoint(/*addStoRequest.getRegistrant(), */sto);
        pointRepository.save(point);
        stoRepository.save(sto);
        return sto;
    }

    @Transactional
    @Override
    public Sto updateStoStatus( Long stoId, UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateStoStatus(updateStoStatusRequest.getStatus());
        return sto;
    }

    @Transactional
    @Override
    public Sto updateStoHitStatus(Long stoId, UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateStoHitStatus(updateStoStatusRequest.getStatus());
        return sto;
    }


    @Transactional
    @Override
    public Sto updateSto(Long stoId, UpdateStoRequest updateStoRequest) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateSto(updateStoRequest.getName(), updateStoRequest.getContents(), updateStoRequest.getCount(),
                updateStoRequest.getGoal(), updateStoRequest.getUrgeType(), updateStoRequest.getUrgeContent(),
                updateStoRequest.getEnforceContent(), updateStoRequest.getMemo());

        return sto;
    }

    @Transactional
    @Override
    public List<String> updateImageList(Long stoId, UpdateImageList updateImageList) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateImageList(updateImageList.getImageList().stream().toList());
        return sto.getImageList();
    }

    @Transactional
    @Override
    public Sto updateStoRound(Long stoId, UpdateStoRoundRequest updateStoRoundRequest) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateStoRound(sto.getRound());

        // when STO's round update, point is made together.
        Point point = Point.createPoint(/*updateStoRoundRequest.getRegistrant(), */sto);
        pointRepository.save(point);
        return sto;
    }

    @Override
    public List<Sto> getStoList() {
        List<Sto> stoList = stoRepository.findAll();
        return stoList;
    }
    

    @Transactional
    @Override
    public void deleteSto(Long stoId) {
        if(stoRepository.findById(stoId).isPresent()) {
            stoRepository.deleteById(stoId);
        } else {
            throw new IllegalStateException("해당하는 STO가 존재하지 않습니다.");
        }
    }
}
