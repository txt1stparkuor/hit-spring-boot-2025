package com.txt1stparkuor.buoi6btvn.mapper;

import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.PositionUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.PositionResponse;
import com.txt1stparkuor.buoi6btvn.domain.entity.Position;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PositionMapper {

    Position toPosition(PositionCreationRequest request);

    void updatePosition(@MappingTarget Position position, PositionUpdateRequest request);

    PositionResponse toPositionResponse(Position position);

    List<PositionResponse> toPositionResponseList(List<Position> positions);
}