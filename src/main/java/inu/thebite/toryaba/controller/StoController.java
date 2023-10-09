package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.AddStoRequest;
import inu.thebite.toryaba.model.sto.UpdateStoStatusRequest;
import inu.thebite.toryaba.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoController {

    private final StoService stoService;

    // add STO
    @PostMapping("/{ltoId}/sto/add")
    public ResponseEntity addSto(@PathVariable Long ltoId, @RequestBody AddStoRequest addStoRequest) {
        Sto sto = stoService.addSto(ltoId, addStoRequest);
        return ResponseEntity.ok(sto);
    }

    // update STO status when STO status is stop or in progress
    @PatchMapping("{ltoId}/sto/{stoId}/update/status")
    public ResponseEntity updateStoStatus(@PathVariable Long ltoId,
                                          @PathVariable Long stoId,
                                          @RequestBody UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoService.updateStoStatus(ltoId, stoId, updateStoStatusRequest);
        return ResponseEntity.ok(sto);
    }

    // update STO status when STO status is git
    @PatchMapping("{ltoId}/sto/{stoId}/hit/update/status")
    public ResponseEntity updateStoHitStatus(@PathVariable Long ltoId,
                                             @PathVariable Long stoId,
                                             @RequestBody UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoService.updateStoHitStatus(ltoId, stoId, updateStoStatusRequest);
        return ResponseEntity.ok(sto);
    }

    // get STO list
    @GetMapping("{ltoId}/sto/list")
    public ResponseEntity getStoList(@PathVariable Long ltoId) {
        List<Sto> stoList = stoService.getStoList(ltoId);
        return ResponseEntity.ok(stoList);
    }

    // delete STO
    @DeleteMapping("{ltoId}/sto/{stoId}/delete")
    public ResponseEntity deleteSto(@PathVariable Long ltoId, @PathVariable Long stoId) {
        stoService.deleteSto(ltoId, stoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}