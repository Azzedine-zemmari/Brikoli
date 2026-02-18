package com.azzedine.brikoli.mapper;

import com.azzedine.brikoli.entity.Category;
import org.mapstruct.Mapper;

import com.azzedine.brikoli.dto.CategoryResponseDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category dtoToEntity(CategoryResponseDto dto);
    CategoryResponseDto entityToDto(Category category);
}