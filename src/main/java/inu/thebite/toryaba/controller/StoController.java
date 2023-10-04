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
    @PostMapping("/{ltoNumber}/sto/add")
    public ResponseEntity addSto(@PathVariable int ltoNumber, @RequestBody AddStoRequest addStoRequest) {
        Sto sto = stoService.addSto(ltoNumber, addStoRequest);
        return ResponseEntity.ok(sto);
    }

    // update STO status when sto status is "stop" or "in progress"
    @PatchMapping("/{ltoNumber}/sto/{stoNumber}/status/update")
    public ResponseEntity updateStoStatus(@PathVariable int ltoNumber, @PathVariable int stoNumber, @RequestBody UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoService.updateStoStatus(ltoNumber, stoNumber, updateStoStatusRequest);
        return ResponseEntity.ok(sto);
    }

    // update STO status when sto status is "hit"
    @PatchMapping("/{ltoNumber}/sto/{stoNumber}/status/hit/update")
    public ResponseEntity updateStoHitStatus(@PathVariable int ltoNumber, @PathVariable int stoNumber, @RequestBody UpdateStoStatusRequest updateStoStatusRequest) {
        Sto sto = stoService.updateStoHitStatus(ltoNumber, stoNumber, updateStoStatusRequest);
        return ResponseEntity.ok(sto);
    }

    // get STO list
    @GetMapping("/{ltoNumber}/list")
    public ResponseEntity getStoList(@PathVariable int ltoNumber) {
        List<Sto> stoList = stoService.getStoList(ltoNumber);
        return ResponseEntity.ok(stoList);
    }

    // delete STO
    @DeleteMapping("/{ltoNumber}/sto/{stoNumber}/delete")
    public ResponseEntity deleteSto(@PathVariable int ltoNumber, @PathVariable int stoNumber) {
        stoService.deleteSto(ltoNumber, stoNumber);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
