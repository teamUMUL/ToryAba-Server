package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Class;
import inu.thebite.toryaba.model.center.AddClassRequest;
import inu.thebite.toryaba.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    // add class
    @PostMapping("/{centerName}/class/add")
    public ResponseEntity addClass(@PathVariable String centerName, @RequestBody AddClassRequest addClassRequest) {
        Class newClass = classService.addClass(centerName, addClassRequest);
        return ResponseEntity.ok(newClass);
    }

    // get class list
    @GetMapping("/{centerName}/class/list")
    public ResponseEntity getClassList(@PathVariable String centerName) {
        List<Class> classList = classService.getClassList(centerName);
        return ResponseEntity.ok(classList);
    }

    // delete class
    @DeleteMapping("/{centerName}/class/{className}/delete")
    public ResponseEntity deleteClass(@PathVariable String centerName, @PathVariable String className) {
        classService.deleteClass(centerName, className);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
