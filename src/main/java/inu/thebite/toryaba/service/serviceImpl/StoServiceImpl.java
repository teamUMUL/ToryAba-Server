package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.AddStoRequest;
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
    public Sto addSto(int ltoNumber, AddStoRequest addStoRequest) {
        Lto lto = ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));

        List<Sto> stoList = stoRepository.findAll();

        Sto sto = Sto.createSto(stoList.size() + 1, addStoRequest.getName(), addStoRequest.getContents(),
                addStoRequest.getCount(), addStoRequest.getGoal(), addStoRequest.getUrgeType(), addStoRequest.getUrgeContent(),
                addStoRequest.getEnforceContent(), addStoRequest.getMemo(), lto);
        stoRepository.save(sto);
        return sto;
    }

    // update STO status when sto status is "stop" or "in progress"
    @Override
    public Sto updateStoStatus(int ltoNumber, int stoNumber, UpdateStoStatusRequest updateStoStatusRequest) {
        Lto lto = ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));
        Sto sto = stoRepository.findByTemplateNum(stoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateStoStatus(updateStoStatusRequest.getStatus());
        return sto;
    }

    // update STO status when sto status is "hit"
    @Override
    public Sto updateStoHitStatus(int ltoNumber, int stoNumber, UpdateStoStatusRequest updateStoStatusRequest) {
        Lto lto = ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));
        Sto sto = stoRepository.findByTemplateNum(stoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 STO가 존재하지 않습니다."));

        sto.updateStoHitStatus(updateStoStatusRequest.getStatus());
        return sto;
    }

    @Override
    public List<Sto> getStoList(int ltoNumber) {
         ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));

        List<Sto> stoList = stoRepository.findByLtoSeq(ltoNumber);
        return stoList;
    }

    @Override
    public void deleteSto(int ltoNumber, int stoNumber) {
        ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당하는 LTO가 존재하지 않습니다."));

        if(stoRepository.findByTemplateNum(stoNumber).isPresent()) {
            stoRepository.deleteByTemplateNum(stoNumber);
        } else {
            throw new IllegalStateException("해당 STO가 존재하지 않습니다.");
        }
    }
}
