package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Domain;
import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.model.lto.AddLtoRequest;
import inu.thebite.toryaba.model.lto.UpdateLtoStatusRequest;
import inu.thebite.toryaba.repository.DomainRepository;
import inu.thebite.toryaba.repository.LtoRepository;
import inu.thebite.toryaba.service.LtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LtoServiceImpl implements LtoService {

    private final LtoRepository ltoRepository;
    private final DomainRepository domainRepository;

    @Override
    @Transactional
    public Lto addLto(Long domainId, AddLtoRequest addLtoRequest) {

        Domain domain = domainRepository.findById(domainId)
                .orElseThrow(() -> new IllegalStateException("해당 영역이 존재하지 않습니다."));
        List<Lto> ltoList = ltoRepository.findAllByDomainId(domain.getId());
        Lto lto = Lto.createLto(ltoList.size() + 1, addLtoRequest.getName(), addLtoRequest.getContents(), addLtoRequest.getGame(), domain);
        Lto saveLto = ltoRepository.save(lto);
        return saveLto;
    }

    @Transactional
    @Override
    public Lto updateLtoStatus(Long ltoId, UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto lto = ltoRepository.findById(ltoId)
                .orElseThrow(() -> new IllegalStateException("해당 LTO가 존재하지 않습니다."));

        lto.updateLtoStatus(updateLtoStatusRequest.getStatus());
        return lto;
    }

    @Transactional
    @Override
    public Lto updateLtoHitStatus(Long ltoId, UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto lto = ltoRepository.findById(ltoId)
                .orElseThrow(() -> new IllegalStateException("해당 LTO가 존재하지 않습니다."));
        lto.updateLtoHitStatus(updateLtoStatusRequest.getStatus());
        return lto;
    }

    @Override
    public List<Lto> getLtoList() {
        List<Lto> LtoList = ltoRepository.findAll();
        return LtoList;
    }

    @Transactional
    @Override
    public void deleteLto(Long ltoId) {
        if (ltoRepository.findById(ltoId).isPresent()) {
            ltoRepository.deleteById(ltoId);
        } else {
            throw new IllegalStateException("해당 LTO가 존재하지 않습니다.");
        }
    }


}