package com.txt1stparkuor.buoi6btvn.service;

import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.PositionResponse;

import java.util.List;

public interface PositionService {
    List<PositionResponse> getAllPositions();
    PositionResponse getPositionById(Long id);
    PositionResponse createPosition(PositionCreationRequest request);
    PositionResponse updatePosition(Long id, PositionUpdateRequest request);
    void deletePosition(Long id);
}
