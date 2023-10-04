package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Class;
import inu.thebite.toryaba.model.center.ClassRequest;
import inu.thebite.toryaba.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    // add class
    @PostMapping("/{centerName}/class/add")
    public ResponseEntity addClass(@PathVariable String centerName, @RequestBody ClassRequest classRequest) {
        Class newClass = classService.addClass(centerName, classRequest);
        return ResponseEntity.ok(newClass);
    }

    // delete class
    @DeleteMapping("/{centerName}/class/delete")
    public ResponseEntity deleteClass(@PathVariable String centerName, @RequestBody ClassRequest classRequest) {
        classService.deleteClass(centerName, classRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
