package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Student;
import inu.thebite.toryaba.model.student.AddStudentRequest;
import inu.thebite.toryaba.model.student.UpdateStudentDateRequest;
import inu.thebite.toryaba.model.student.UpdateStudentRequest;
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

    // update student info
    @PatchMapping("/student/{studentId}/update")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentRequest updateStudentRequest) {
        Student student = studentService.updateStudent(studentId, updateStudentRequest);
        return student;
    }

    // update startDate
    @PatchMapping("/student/{studentId}/startDate/update")
    public Student updateStudentStartDate(@PathVariable Long studentId,
                                          @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentStartDate(studentId, updateStudentDateRequest);
        return student;
    }

    // update endDate
    @PatchMapping("/student/{studentId}/endDate/update")
    public Student updateStudentEndDate(@PathVariable Long studentId,
                                        @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentEndDate(studentId, updateStudentDateRequest);
        return student;
    }

    // get student list
    @GetMapping("/student/list")
    public List<Student> getStudentList() {
        List<Student> studentList = studentService.getStudentList();
        return studentList;
    }

    // delete student
    @DeleteMapping("/student/{studentId}/delete")
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
