package com.txt1stparkuor.buoi3btvn.service;

import com.txt1stparkuor.buoi3btvn.entity.Student;
import com.txt1stparkuor.buoi3btvn.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }


    public Student updateStudent(Long id, Student updatedStudentDetails) {
        Student currentStudent = getStudentById(id);
        currentStudent.setName(updatedStudentDetails.getName());
        currentStudent.setEmail(updatedStudentDetails.getEmail());
        currentStudent.setPhone(updatedStudentDetails.getPhone());
        currentStudent.setAddress(updatedStudentDetails.getAddress());
        return studentRepository.save(currentStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
