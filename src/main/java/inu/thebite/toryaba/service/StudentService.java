package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Student;
import inu.thebite.toryaba.model.student.AddStudentRequest;
import inu.thebite.toryaba.model.student.UpdateStudentDateRequest;

public interface StudentService {
    Student addStudent(String className, AddStudentRequest addStudentRequest);

    Student updateStudentStartDate(String className, Long studentId, UpdateStudentDateRequest updateStudentDateRequest);

    Student updateStudentEndDate(String className, Long studentId, UpdateStudentDateRequest updateStudentDateRequest);

    void deleteStudent(String className, Long studentId);
}
