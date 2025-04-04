package com.txt1stparkuor.buoi4btvn.services.impl;

import com.txt1stparkuor.buoi4btvn.dtos.request.StudentRequest;
import com.txt1stparkuor.buoi4btvn.entity.Classes;
import com.txt1stparkuor.buoi4btvn.entity.Student;
import com.txt1stparkuor.buoi4btvn.exception.AppException;
import com.txt1stparkuor.buoi4btvn.exception.ErrorCode;
import com.txt1stparkuor.buoi4btvn.mapper.StudentMapper;
import com.txt1stparkuor.buoi4btvn.repositories.ClassesRepository;
import com.txt1stparkuor.buoi4btvn.repositories.StudentRepository;
import com.txt1stparkuor.buoi4btvn.services.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    ClassesRepository classesRepository;
    StudentMapper studentMapper;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(StudentRequest request) {
        Student student=studentMapper.toStudent(request);

        Classes classes=classesRepository.findByName(request.getClassName())
                .orElseThrow(() -> new AppException(ErrorCode.CLASSES_NOT_EXISTED));
        student.setClasses(classes);
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_EXISTED));
    }

    @Override
    public Student updateStudent(Long id, StudentRequest request) {
        Student student=getStudentById(id);
        studentMapper.updateStudent(student,request);
        Classes classes=classesRepository.findByName(request.getClassName())
                .orElseThrow(() -> new AppException(ErrorCode.CLASSES_NOT_EXISTED));
        student.setClasses(classes);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
