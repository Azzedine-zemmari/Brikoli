package com.azzedine.brikoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azzedine.brikoli.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    
}
