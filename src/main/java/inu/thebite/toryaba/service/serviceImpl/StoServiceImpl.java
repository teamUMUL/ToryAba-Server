package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.AddStoRequest;
import inu.thebite.toryaba.model.sto.UpdateImageList;
import inu.thebite.toryaba.model.sto.UpdateStoStatusRequest;
import inu.thebite.toryaba.repository.LtoRepository;
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

    @Transactional
    @Override
    public Sto addSto(Long ltoId, AddStoRequest addStoRequest) {
        Lto lto = ltoRepository.findById(ltoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));

        List<Sto> stoList = stoRepository.findAllByLtoId(lto.getId());

        Sto sto = Sto.createSto(stoList.size() + 1, addStoRequest.getName(), addStoRequest.getContents(),
                addStoRequest.getCount(), addStoRequest.getGoal(), addStoRequest.getUrgeType(),
                addStoRequest.getUrgeContent(), addStoRequest.getEnforceContent(), addStoRequest.getMemo(), lto);

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
    public List<Image> updateImageList(Long stoId, UpdateImageList updateImageList) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateImageList(updateImageList.getImageList().stream().toList());
        return sto.getImageList();
    }

    @Override
    public List<Sto> getStoList() {
        List<Sto> stoList = stoRepository.findAll();
        return stoList;
    }

    @Override
    public Sto findSto(Long stoId) {
        Sto sto = stoRepository.findById(stoId)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        return sto;
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
