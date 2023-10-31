package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.*;

import java.util.List;

public interface StoService {
    Sto addSto(Long ltoId, AddStoRequest addStoRequest);

    Sto updateStoStatus(Long stoId, UpdateStoStatusRequest updateStoStatusRequest);

    Sto updateStoHitStatus(Long stoId, UpdateStoStatusRequest updateStoStatusRequest);

    List<Sto> getStoList();

    void deleteSto(Long stoId);

    List<String> updateImageList(Long stoId, UpdateImageList updateImageList);

    Sto updateSto(Long stoId, UpdateStoRequest updateStoRequest);

    Sto updateStoRound(Long stoId/*, UpdateStoRoundRequest updateStoRoundRequest*/);
}
