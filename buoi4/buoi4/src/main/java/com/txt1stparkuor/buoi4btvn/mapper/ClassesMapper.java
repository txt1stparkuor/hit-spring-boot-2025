package com.txt1stparkuor.buoi4btvn.mapper;

import com.txt1stparkuor.buoi4btvn.dtos.request.ClassesRequest;
import com.txt1stparkuor.buoi4btvn.dtos.response.ClassesReponse;
import com.txt1stparkuor.buoi4btvn.entity.Classes;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClassesMapper {
    Classes toClasses(ClassesRequest request);
    void updateClasses(ClassesRequest request, @MappingTarget  Classes classes);
    ClassesReponse toClassesReponse(Classes classes);
}
