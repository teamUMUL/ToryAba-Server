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
    @PostMapping("/{domainNumber}/lto/add")
    public ResponseEntity<Lto> addLto(@PathVariable int domainNumber, @RequestBody AddLtoRequest addLtoRequest) {
        Lto lto = ltoService.addLto(domainNumber,addLtoRequest);
        return ResponseEntity.ok(lto);
    }

    // update LTO status when lto status is "stop" or "in progress"
    @PatchMapping("/{domainNumber}/lto/{ltoNumber}/status/update")
    public ResponseEntity<Lto> updateLtoStatus(@PathVariable int domainNumber,
                                               @PathVariable int ltoNumber,
                                               @RequestBody UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto updateLto = ltoService.updateLtoStatus(domainNumber, ltoNumber, updateLtoStatusRequest);
        return ResponseEntity.ok(updateLto);
    }

    // update LTO status when lto status is "hit"
    @PatchMapping("/{domainNumber}/lto/{ltoNumber}/status/hit/update")
    public ResponseEntity<Lto> updateLtoHitStatus(@PathVariable int domainNumber,
                                               @PathVariable int ltoNumber,
                                               @RequestBody UpdateLtoStatusRequest updateLtoStatusRequest) {
        Lto updateLto = ltoService.updateLtoHitStatus(domainNumber, ltoNumber, updateLtoStatusRequest);
        return ResponseEntity.ok(updateLto);
    }

    // get LTO List
    @GetMapping("/{domainNumber}/lto/list")
    public ResponseEntity getLtoList(@PathVariable int domainNumber) {
        List<Lto> ltoList = ltoService.getLtoList(domainNumber);
        return ResponseEntity.ok(ltoList);
    }

    // delete LTO
    @DeleteMapping("{domainNumber}/lto/{ltoNumber}/delete")
    public ResponseEntity deleteLto(@PathVariable int domainNumber, @PathVariable int ltoNumber) {
        ltoService.deleteLto(domainNumber, ltoNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
