package com.azzedine.brikoli.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.azzedine.brikoli.dto.ResponseUserDto;
import com.azzedine.brikoli.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResponseUserDto entityDto(User user);
    User dtoUser(ResponseUserDto dto);    
}
