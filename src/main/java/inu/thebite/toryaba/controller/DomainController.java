package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Domain;
import inu.thebite.toryaba.model.domain.AddDomainRequest;
import inu.thebite.toryaba.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DomainController {

    private final DomainService domainService;

    // add domain
    @PostMapping("/domain/add")
    public ResponseEntity addDomain(@RequestBody AddDomainRequest addDomainRequest) {
        Domain domain = domainService.addDomain(addDomainRequest);
        return ResponseEntity.ok(domain);
    }

    // get domain list
    @GetMapping("/domain/list")
    public ResponseEntity getDomainList() {
        List<Domain> domainList = domainService.getDomainList();
        return ResponseEntity.ok(domainList);
    }

    // delete domain
    @DeleteMapping("/domain/{templateNum}/delete")
    public ResponseEntity deleteDomain(@PathVariable int templateNum) {
        domainService.deleteDomain(templateNum);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
