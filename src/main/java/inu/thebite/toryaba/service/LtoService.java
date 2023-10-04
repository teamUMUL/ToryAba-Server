package inu.thebite.toryaba.service;


import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.model.lto.AddLtoRequest;
import inu.thebite.toryaba.model.lto.UpdateLtoStatusRequest;

import java.util.List;

public interface LtoService {

    Lto addLto(int domainNumber, AddLtoRequest addLtoRequest);

    Lto updateLtoStatus(int domainNumber, int ltoNumber, UpdateLtoStatusRequest updateLtoStatusRequest);

    List<Lto> getLtoList(int domainNumber);

    void deleteLto(int domainNumber, int ltoNumber);
}
