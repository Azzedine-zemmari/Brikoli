package com.azzedine.brikoli.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.azzedine.brikoli.dto.CategoryResponseDto;
import com.azzedine.brikoli.mapper.CategoryMapper;
import com.azzedine.brikoli.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    @Override
    public  List<CategoryResponseDto> getCategories(){
        return categoryRepository.findAll()
        .stream()
        .map(categoryMapper::entityToDto)
        .toList();
    }
}
