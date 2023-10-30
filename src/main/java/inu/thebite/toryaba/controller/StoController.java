package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.entity.Image;
import inu.thebite.toryaba.entity.Sto;
import inu.thebite.toryaba.model.sto.*;
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
    @PostMapping("/{ltoId}/stos")
    public Sto addSto(@PathVariable Long ltoId, @RequestBody AddStoRequest addStoRequest) {
        Sto sto = stoService.addSto(ltoId, addStoRequest);
        return sto;
    }

    // update STO status when STO status is stop or in progress
    @PatchMapping("/stos/{stoId}/status")
    public Sto updateStoStatus(@PathVariable Long stoId,
                               @RequestBody UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoService.updateStoStatus(stoId, updateStoStatusRequest);
        return sto;
    }

    // update STO status when STO status is git
    @PatchMapping("/stos/{stoId}/hit/status")
    public Sto updateStoHitStatus(@PathVariable Long stoId,
                                  @RequestBody UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoService.updateStoHitStatus(stoId, updateStoStatusRequest);
        return sto;
    }

    // update STO contents
    @PatchMapping("/stos/{stoId}")
    public Sto updateSto(@PathVariable Long stoId, @RequestBody UpdateStoRequest updateStoRequest) {
        Sto sto = stoService.updateSto(stoId, updateStoRequest);
        return sto;
    }

    // update image list(image url)
    // when UpdateImageList request, I have to decide whether to use imageName or imageUrl, but these are same type.
    @PatchMapping("/stos/{stoId}/images")
    public ResponseEntity updateImageList(@PathVariable Long stoId, @RequestBody UpdateImageList updateImageList) {
        List<String> imageList = stoService.updateImageList(stoId, updateImageList);
        return ResponseEntity.ok(imageList);
    }

    // update STO round
    @PatchMapping("/stos/{stoId}/round")
    public ResponseEntity updateStoRound(@PathVariable Long stoId, @RequestBody UpdateStoRoundRequest updateStoRoundRequest) {
        Sto sto = stoService.updateStoRound(stoId, updateStoRoundRequest);
        return ResponseEntity.ok(sto);
    }

    // get STO list
    @GetMapping("/stos")
    public List<Sto> getStoList() {
        List<Sto> stoList = stoService.getStoList();
        return stoList;
    }

    // find STO (only one)
    // Expected to be unnecessary for this part
    @GetMapping("/find/{stoId}/sto")
    public Sto findSto(@PathVariable Long stoId) {
        Sto sto = stoService.findSto(stoId);
        return sto;
    }

    // delete STO
    @DeleteMapping("/stos/{stoId}")
    public ResponseEntity deleteSto(@PathVariable Long stoId) {
        stoService.deleteSto(stoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}