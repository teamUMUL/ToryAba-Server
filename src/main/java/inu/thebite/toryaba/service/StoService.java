package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.AddStoRequest;
import inu.thebite.toryaba.model.sto.UpdateStoStatusRequest;

import java.util.List;

public interface StoService {
    Sto addSto(int ltoNumber, AddStoRequest addStoRequest);

    List<Sto> getStoList(int ltoNumber);

    void deleteSto(int ltoNumber, int stoNumber);

    Sto updateStoStatus(int ltoNumber, int stoNumber, UpdateStoStatusRequest updateStoStatusRequest);

    Sto updateStoHitStatus(int ltoNumber, int stoNumber, UpdateStoStatusRequest updateStoStatusRequest);
}
