package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Student;
import inu.thebite.toryaba.model.student.AddStudentRequest;
import inu.thebite.toryaba.model.student.UpdateStudentDateRequest;
import inu.thebite.toryaba.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // add student
    @PostMapping("/{classId}/student/add")
    public ResponseEntity addStudent(@PathVariable Long classId, @RequestBody AddStudentRequest addStudentRequest) {
        Student student = studentService.addStudent(classId, addStudentRequest);
        return ResponseEntity.ok(student);
    }

    // update startDate
    @PatchMapping("/{classId}/student/{studentId}/startDate/update")
    public ResponseEntity updateStudentStartDate(@PathVariable Long classId,
                                                 @PathVariable Long studentId,
                                                 @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentStartDate(classId, studentId, updateStudentDateRequest);
        return ResponseEntity.ok(student);
    }

    // update endDate
    @PatchMapping("/{classId}/student/{studentId}/endDate/update")
    public ResponseEntity updateStudentEndDate(@PathVariable Long classId,
                                                 @PathVariable Long studentId,
                                                 @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentEndDate(classId, studentId, updateStudentDateRequest);
        return ResponseEntity.ok(student);
    }

    // get student list
    @GetMapping("/{classId}/student/list")
    public ResponseEntity getStudentList(@PathVariable Long classId) {
        List<Student> studentList = studentService.getStudentList(classId);
        return ResponseEntity.ok(studentList);
    }

    // delete student
    @DeleteMapping("/{classId}/student/{studentId}/delete")
    public ResponseEntity deleteStudent(@PathVariable Long classId, @PathVariable Long studentId) {
        studentService.deleteStudent(classId, studentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
