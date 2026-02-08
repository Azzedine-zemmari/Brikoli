package com.azzedine.brikoli.mapper;

import org.mapstruct.Mapper;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.entity.Mission;

@Mapper(componentModel = "spring")
public interface MissionDtoMapper {
    MissionRequestDto entityToDto(Mission mission);
    Mission dtoToMission(MissionRequestDto dto);
}