package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.entity.Lto;
import inu.thebite.toryaba.model.lto.LtoRequest;
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
    public Lto addLto(@PathVariable Long domainId, @RequestBody LtoRequest ltoRequest) {
        Lto lto = ltoService.addLto(domainId, ltoRequest);
        return lto;
    }

    // modified LTO status(stop, in progress)
    @PatchMapping("/lto/{ltoId}/status/update")
    public Lto updateStatus(@PathVariable Long ltoId, @RequestBody UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto updateLto = ltoService.updateLtoStatus(ltoId, updateLtoStatusRequest);
        return updateLto;
    }

    //modified LTO status(hit)
    @PatchMapping("/lto/{ltoId}/hit/status/update")
    public Lto updateHitStatus(@PathVariable Long ltoId, @RequestBody UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto updateLto = ltoService.updateLtoHitStatus(ltoId, updateLtoStatusRequest);
        return updateLto;
    }

    // update LTO contents
    @PatchMapping("/lto/{ltoId}/update")
    public Lto updateLto(@PathVariable Long ltoId, @RequestBody LtoRequest ltoRequest) {
        Lto lto = ltoService.updateLto(ltoId, ltoRequest);
        return lto;
    }

    // get LTO List
    @GetMapping("/lto/list")
    public List<Lto> getLtoList() {
        List<Lto> ltoList = ltoService.getLtoList();
        return ltoList;
    }

    // delete LTO
    @DeleteMapping("/lto/{ltoId}/delete")
    public ResponseEntity deleteLto(@PathVariable Long ltoId) {
        ltoService.deleteLto(ltoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}