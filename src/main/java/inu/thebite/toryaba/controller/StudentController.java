package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Student;
import inu.thebite.toryaba.model.student.AddStudentRequest;
import inu.thebite.toryaba.model.student.UpdateStudentDateRequest;
import inu.thebite.toryaba.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // add student
    @PostMapping("/{className}/student/add")
    public ResponseEntity addStudent(@PathVariable String className, @RequestBody AddStudentRequest addStudentRequest) {
        Student student = studentService.addStudent(className, addStudentRequest);
        return ResponseEntity.ok(student);
    }

    // update startDate
    @PatchMapping("/{className}/student/{studentId}/startDate/update")
    public ResponseEntity updateStudentStartDate(@PathVariable String className,
                                                 @PathVariable Long studentId,
                                                 @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentStartDate(className, studentId, updateStudentDateRequest);
        return ResponseEntity.ok(student);
    }

    // update endDate
    @PatchMapping("/{className}/student/{studentId}/startDate/update")
    public ResponseEntity updateStudentEndDate(@PathVariable String className,
                                                 @PathVariable Long studentId,
                                                 @RequestBody UpdateStudentDateRequest updateStudentDateRequest) {
        Student student = studentService.updateStudentEndDate(className, studentId, updateStudentDateRequest);
        return ResponseEntity.ok(student);
    }

    // delete student
    @DeleteMapping("/{className}/student/{studentId}/delete")
    public ResponseEntity deleteStudent(@PathVariable String className, @PathVariable Long studentId) {
        studentService.deleteStudent(className, studentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
