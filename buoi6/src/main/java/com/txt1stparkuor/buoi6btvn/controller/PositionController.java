package com.txt1stparkuor.buoi6btvn.controller;

import com.txt1stparkuor.buoi6btvn.base.ResponseUtil;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.PositionResponse;
import com.txt1stparkuor.buoi6btvn.service.PositionService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/positions")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PositionController {

    PositionService positionService;

    @GetMapping
    ResponseEntity<?> getAllPositions() {
        List<PositionResponse> positions = positionService.getAllPositions();
        return ResponseUtil.success(positions);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getPositionById(@PathVariable Long id) {
        PositionResponse position = positionService.getPositionById(id);
        return ResponseUtil.success(position);
    }

    @PostMapping
    ResponseEntity<?> createPosition(@Valid @RequestBody PositionCreationRequest request) {
        PositionResponse createdPosition = positionService.createPosition(request);
        return ResponseUtil.success(HttpStatus.CREATED, createdPosition);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updatePosition(@PathVariable Long id, @Valid @RequestBody PositionUpdateRequest request) {
        PositionResponse updatedPosition = positionService.updatePosition(id, request);
        return ResponseUtil.success(updatedPosition);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePosition(@PathVariable Long id) {
        positionService.deletePosition(id);
        return ResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}