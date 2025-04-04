package com.txt1stparkuor.buoi4btvn.services.impl;

import com.txt1stparkuor.buoi4btvn.dtos.request.ClassesRequest;
import com.txt1stparkuor.buoi4btvn.entity.Classes;
import com.txt1stparkuor.buoi4btvn.mapper.ClassesMapper;
import com.txt1stparkuor.buoi4btvn.repositories.ClassesRepository;
import com.txt1stparkuor.buoi4btvn.services.ClassesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ClassesServiceImpl implements ClassesService {
    ClassesRepository classesRepository;
    ClassesMapper classesMapper;
    @Override
    public List<Classes> getAllClasses() {
        return classesRepository.findAll();
    }

    @Override
    public Classes createClasses(ClassesRequest request) {
        Classes classes=classesMapper.toClasses(request);
        return classesRepository.save(classes);
    }


}
