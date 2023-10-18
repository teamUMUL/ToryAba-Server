package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.AddStoRequest;
import inu.thebite.toryaba.model.sto.UpdateImageList;
import inu.thebite.toryaba.model.sto.UpdateStoStatusRequest;

import java.util.List;

public interface StoService {
    Sto addSto(Long ltoId, AddStoRequest addStoRequest);

    Sto updateStoStatus(Long stoId, UpdateStoStatusRequest updateStoStatusRequest);

    Sto updateStoHitStatus(Long stoId, UpdateStoStatusRequest updateStoStatusRequest);

    List<Sto> getStoList();

    void deleteSto(Long stoId);

    Sto findSto(Long stoId);

    List<Image> updateImageList(Long stoId, UpdateImageList updateImageList);
}
