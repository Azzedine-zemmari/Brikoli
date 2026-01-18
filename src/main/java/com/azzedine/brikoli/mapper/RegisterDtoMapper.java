package com.azzedine.brikoli.mapper;

import com.azzedine.brikoli.dto.RegisterDto;
import com.azzedine.brikoli.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterDtoMapper {
    RegisterDto userToDto(User user);
    User dtoToUser(RegisterDto dto);
}
