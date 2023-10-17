package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.model.lto.AddLtoRequest;
import inu.thebite.toryaba.model.lto.UpdateLtoStatusRequest;
import inu.thebite.toryaba.service.LtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LtoController {

    private final LtoService ltoService;

    // add LTO
    @PostMapping("/{domainId}/lto/add")
    public Lto addLto(@PathVariable Long domainId, @RequestBody AddLtoRequest addLtoRequest) {
        Lto lto = ltoService.addLto(domainId,addLtoRequest);
        return lto;
    }

    // modified LTO status(stop, in progress)
    @PatchMapping("/{domainId}/lto/{ltoId}/update/status")
    public Lto updateStatus(@PathVariable Long domainId,
                                            @PathVariable Long ltoId,
                                            @RequestBody UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto updateLto = ltoService.updateLtoStatus(domainId, ltoId, updateLtoStatusRequest);
        return updateLto;
    }

    //modified LTO status(hit)
    @PatchMapping("/{domainId}/lto/{ltoId}/hit/update/status")
    public Lto updateHitStatus(@PathVariable Long domainId,
                                          @PathVariable Long ltoId,
                                          @RequestBody UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto updateLto = ltoService.updateLtoHitStatus(domainId, ltoId, updateLtoStatusRequest);
        return updateLto;
    }

    // get LTO List
    @GetMapping("/{domainId}/lto/list")
    public List<Lto> getLtoList(@PathVariable Long domainId) {
        List<Lto> ltoList = ltoService.getLtoList(domainId);
        return ltoList;
    }

    // delete LTO
    @DeleteMapping("{domainId}/lto/{ltoId}/delete")
    public ResponseEntity deleteLto(@PathVariable Long domainId, @PathVariable Long ltoId) {
        ltoService.deleteLto(domainId, ltoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}