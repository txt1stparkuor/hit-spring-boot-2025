package com.txt1stparkuor.buoi4btvn.services;

import com.txt1stparkuor.buoi4btvn.dtos.request.ClassesRequest;
import com.txt1stparkuor.buoi4btvn.entity.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> getAllClasses();

    Classes createClasses(ClassesRequest request);
}
