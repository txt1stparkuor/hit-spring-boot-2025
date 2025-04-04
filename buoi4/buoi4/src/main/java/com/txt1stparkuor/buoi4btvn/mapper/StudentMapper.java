package com.txt1stparkuor.buoi4btvn.mapper;


import com.txt1stparkuor.buoi4btvn.dtos.request.StudentRequest;
import com.txt1stparkuor.buoi4btvn.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentRequest request);
    void updateStudent(@MappingTarget Student student, StudentRequest request);
}
