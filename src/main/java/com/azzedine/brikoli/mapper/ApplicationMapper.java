package com.azzedine.brikoli.mapper;

import org.mapstruct.Mapper;

import com.azzedine.brikoli.dto.ApplicationRequestDto;
import com.azzedine.brikoli.entity.Application;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    Application dtoEntity(ApplicationRequestDto dto);
    ApplicationRequestDto entityDto(Application application);
}
