package com.txt1stparkuor.buoi4btvn.controllers;

import com.txt1stparkuor.buoi4btvn.dtos.request.ClassesRequest;
import com.txt1stparkuor.buoi4btvn.dtos.response.ApiResponse;
import com.txt1stparkuor.buoi4btvn.entity.Classes;
import com.txt1stparkuor.buoi4btvn.services.ClassesService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/v1/classes")
public class ClassesController {

    ClassesService classesService;

    @GetMapping
    ApiResponse<List<Classes>> getAllClasses() {
        return ApiResponse.<List<Classes>>builder()
                .result(classesService.getAllClasses())
                .build();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Classes>> createClasses(@RequestBody @Valid ClassesRequest request) {
        Classes createdClass = classesService.createClasses(request);

        ApiResponse<Classes> apiResponse = ApiResponse.<Classes>builder()
                .result(createdClass)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
