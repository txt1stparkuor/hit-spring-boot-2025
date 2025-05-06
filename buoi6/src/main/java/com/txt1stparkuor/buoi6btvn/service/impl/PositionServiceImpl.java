package com.txt1stparkuor.buoi6btvn.service.impl;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.PositionResponse;
import com.txt1stparkuor.buoi6btvn.domain.entity.Position;
import com.txt1stparkuor.buoi6btvn.exception.DuplicateResourceException;
import com.txt1stparkuor.buoi6btvn.exception.NotFoundException;
import com.txt1stparkuor.buoi6btvn.mapper.PositionMapper;
import com.txt1stparkuor.buoi6btvn.repository.PositionRepository;
import com.txt1stparkuor.buoi6btvn.service.PositionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    PositionRepository positionRepository;
    PositionMapper positionMapper;

    @Override
    public List<PositionResponse> getAllPositions() {
        return positionMapper.toPositionResponseList(positionRepository.findAll());
    }

    @Override
    public PositionResponse getPositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.Position.ERR_NOT_FOUND_ID,
                        new String[]{String.valueOf(id)}
                ));
        return positionMapper.toPositionResponse(position);
    }

    @Override
    public PositionResponse createPosition(PositionCreationRequest request) {
        if (positionRepository.existsByTitle(request.getTitle())) {
            throw new DuplicateResourceException(
                    ErrorMessage.DUPLICATE_RESOURCE,
                    new String[]{"Position title: " + request.getTitle()}
            );
        }
        Position position = positionMapper.toPosition(request);
        Position savedPosition = positionRepository.save(position);
        return positionMapper.toPositionResponse(savedPosition);
    }

    @Override
    public PositionResponse updatePosition(Long id, PositionUpdateRequest request) {
        Position existingPosition = positionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.Position.ERR_NOT_FOUND_ID,
                        new String[]{String.valueOf(id)}
                ));

        if (!request.getTitle().equalsIgnoreCase(existingPosition.getTitle())) {
            if (positionRepository.existsByTitleAndIdNot(request.getTitle(), id)) {
                throw new DuplicateResourceException(
                        ErrorMessage.DUPLICATE_RESOURCE,
                        new String[]{"Position title: " + request.getTitle()}
                );
            }
        }
        positionMapper.updatePosition(existingPosition, request);
        Position updatedPosition = positionRepository.save(existingPosition);
        return positionMapper.toPositionResponse(updatedPosition);
    }

    @Override
    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}