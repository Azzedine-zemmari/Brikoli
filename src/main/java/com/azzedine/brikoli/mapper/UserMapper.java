package com.azzedine.brikoli.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.azzedine.brikoli.dto.ResponseMissionDto;
import com.azzedine.brikoli.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResponseMissionDto entityDto(User user);
    User dtoUser(ResponseMissionDto dto);    
}
