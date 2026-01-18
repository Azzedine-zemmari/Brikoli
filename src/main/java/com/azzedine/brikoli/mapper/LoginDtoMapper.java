package com.azzedine.brikoli.mapper;

import org.mapstruct.Mapper;

import com.azzedine.brikoli.dto.RequestLoginDto;
import com.azzedine.brikoli.entity.User;

@Mapper(componentModel = "spring")
public interface LoginDtoMapper {
    RequestLoginDto entityToDto(User user);
    User dtoToUser(RequestLoginDto dto);
}
