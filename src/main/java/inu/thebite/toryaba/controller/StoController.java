package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoController {

    private final StoService stoService;

    // add STO
//    @PostMapping("/{ltoNumber}/sto/add")
//    public ResponseEntity addSto(@PathVariable int ltoNumber, )

    // modified STO status

    // get STO list

    // delete STO
}
