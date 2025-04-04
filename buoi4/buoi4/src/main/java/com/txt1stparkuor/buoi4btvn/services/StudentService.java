package com.txt1stparkuor.buoi4btvn.services;

import com.txt1stparkuor.buoi4btvn.dtos.request.StudentRequest;
import com.txt1stparkuor.buoi4btvn.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student createStudent(StudentRequest request);

    Student getStudentById(Long id);

    Student updateStudent(Long id, StudentRequest request);

    void deleteStudent(Long id);
}
