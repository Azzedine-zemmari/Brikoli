package com.azzedine.brikoli.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.azzedine.brikoli.dto.MissionRequestDto;
import com.azzedine.brikoli.entity.Mission;

@Mapper(componentModel = "spring")
public interface MissionDtoMapper {
    @Mappings({
        @Mapping(source = "client.id" , target = "client_id"),
        @Mapping(source = "category.id" , target = "category_id"),
        @Mapping(source = "budgetMin" , target = "budget_min"),
        @Mapping(source = "budgetMax" , target = "budget_max"),
        @Mapping(source = "missionDate", target = "mission_date")
    })
    MissionRequestDto entityToDto(Mission mission);
    @Mappings({
        @Mapping(target = "budgetMin" , source = "budget_min"),
        @Mapping(target = "budgetMax" , source = "budget_max"),
        @Mapping(source = "mission_date", target = "missionDate")
    })
    Mission dtoToMission(MissionRequestDto dto);
}