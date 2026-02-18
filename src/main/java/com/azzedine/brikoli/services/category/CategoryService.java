package com.azzedine.brikoli.services.category;

import java.util.List;

import com.azzedine.brikoli.dto.CategoryResponseDto;

public interface CategoryService {
    List<CategoryResponseDto> getCategories();
} 