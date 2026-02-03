package com.azzedine.brikoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azzedine.brikoli.entity.ProfessionalProfile;

public interface ProfessionalRepository extends JpaRepository<ProfessionalProfile,Long> {
    
}
