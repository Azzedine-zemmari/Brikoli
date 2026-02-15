package com.azzedine.brikoli.repository;

import com.azzedine.brikoli.entity.Mission;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    List<Mission> findByClientUserId(Long userId);
}
