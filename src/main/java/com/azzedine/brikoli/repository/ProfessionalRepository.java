package com.azzedine.brikoli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azzedine.brikoli.entity.ProfessionalProfile;

public interface ProfessionalRepository extends JpaRepository<ProfessionalProfile,Long> {
    Optional<ProfessionalProfile> findByUserId(Long userId);

}
