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
    public Student addStudent(@PathVariable Long classId, @RequestBody AddStudentRequest addStudentRequest) {
        Student student = studentService.addStudent(classId, addStudentRequest);
        return student;
    }

    // update startDate
    @PatchMapping("/{classId}/student/{studentId}/startDate/update")
    public Student updateStudentStartDate(@PathVariable Long classId,
                                                 @PathVariable Long studentId,
                                                 @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentStartDate(classId, studentId, updateStudentDateRequest);
        return student;
    }

    // update endDate
    @PatchMapping("/{classId}/student/{studentId}/endDate/update")
    public Student updateStudentEndDate(@PathVariable Long classId,
                                                 @PathVariable Long studentId,
                                                 @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentEndDate(classId, studentId, updateStudentDateRequest);
        return student;
    }

    // get student list
    @GetMapping("/{classId}/student/list")
    public List<Student> getStudentList(@PathVariable Long classId) {
        List<Student> studentList = studentService.getStudentList(classId);
        return studentList;
    }

    // delete student
    @DeleteMapping("/{classId}/student/{studentId}/delete")
    public ResponseEntity deleteStudent(@PathVariable Long classId, @PathVariable Long studentId) {
        studentService.deleteStudent(classId, studentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
