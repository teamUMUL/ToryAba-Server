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
    @PostMapping("/{centerId}/class/add")
    public Class addClass(@PathVariable Long centerId, @RequestBody AddClassRequest addClassRequest) {
        Class newClass = classService.addClass(centerId, addClassRequest);
        return newClass;
    }

    // get class list
    @GetMapping("/{centerId}/class/list")
    public List<Class> getClassList(@PathVariable Long centerId) {
        List<Class> classList = classService.getClassList(centerId);
        return classList;
    }

    // delete class
    @DeleteMapping("/{centerId}/class/{classId}/delete")
    public ResponseEntity deleteClass(@PathVariable Long centerId, @PathVariable Long classId) {
        classService.deleteClass(centerId, classId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
