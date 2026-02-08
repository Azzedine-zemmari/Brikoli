package com.azzedine.brikoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azzedine.brikoli.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}