package inu.thebite.toryaba.service;


import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.model.lto.AddLtoRequest;
import inu.thebite.toryaba.model.lto.UpdateLtoStatusRequest;

import java.util.List;

public interface LtoService {

    Lto addLto(Long domainId, AddLtoRequest addLtoRequest);

    Lto updateLtoStatus(Long domainId, Long ltoId, UpdateLtoStatusRequest updateLtoStatusRequest);

    List<Lto> getLtoList(Long domainId);

    void deleteLto(Long domainId, Long ltoId);
}