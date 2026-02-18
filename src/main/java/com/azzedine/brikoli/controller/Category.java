package com.azzedine.brikoli.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azzedine.brikoli.dto.CategoryResponseDto;
import com.azzedine.brikoli.services.category.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class Category {
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponseDto>> showall(){
        return ResponseEntity.ok(categoryService.getCategories());
    }
}
