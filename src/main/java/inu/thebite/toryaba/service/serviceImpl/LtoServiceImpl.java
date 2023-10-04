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

    // add LTO
    @Override
    @Transactional
    public Lto addLto(int domainNumber, AddLtoRequest addLtoRequest) {

        Domain domain = domainRepository.findByTemplateNumber(domainNumber)
                .orElseThrow(() -> new IllegalStateException("해당 영역이 존재하지 않습니다."));
        List<Lto> ltoList = ltoRepository.findAll();
        Lto lto = Lto.createLto(ltoList.size() + 1, addLtoRequest.getName(), addLtoRequest.getContent(), domain);
        Lto saveLto = ltoRepository.save(lto);
        return saveLto;
    }

    @Override
    public Lto updateLtoStatus(int domainNumber, int ltoNumber, UpdateLtoStatusRequest updateLtoStatusRequest) {

        domainRepository.findByTemplateNumber(domainNumber)
                .orElseThrow(() -> new IllegalStateException("해당 영역이 존재하지 않습니다."));
        Lto lto = ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당 LTO가 존재하지 않습니다."));

        lto.updateLtoStatus(updateLtoStatusRequest.getStatus());
        return lto;
    }

    @Override
    public Lto updateLtoHitStatus(int domainNumber, int ltoNumber, UpdateLtoStatusRequest updateLtoStatusRequest) {
        domainRepository.findByTemplateNumber(domainNumber)
                .orElseThrow(() -> new IllegalStateException("해당 영역이 존재하지 않습니다."));
        Lto lto = ltoRepository.findByTemplateNum(ltoNumber)
                .orElseThrow(() -> new IllegalStateException("해당 LTO가 존재하지 않습니다."));

        lto.updateLtoHitStatus(updateLtoStatusRequest.getStatus());
        return lto;
    }

    @Override
    public List<Lto> getLtoList(int domainNumber) {
        Domain domain = domainRepository.findByTemplateNumber(domainNumber)
                .orElseThrow(() -> new IllegalStateException("해당 영역이 존재하지 않습니다."));

        List<Lto> LtoList = ltoRepository.findLtoByDomainSeq(domainNumber);
        return LtoList;
    }

    @Override
    public void deleteLto(int domainNumber, int ltoNumber) {
        domainRepository.findByTemplateNumber(domainNumber)
                .orElseThrow(() -> new IllegalStateException("해당 영역이 존재하지 않습니다."));
       if (ltoRepository.findByTemplateNum(ltoNumber).isPresent()) {
           ltoRepository.deleteByTemplateNum(ltoNumber);
       } else {
           throw new IllegalStateException("해당 LTO가 존재하지 않습니다.");
       }
    }


}
