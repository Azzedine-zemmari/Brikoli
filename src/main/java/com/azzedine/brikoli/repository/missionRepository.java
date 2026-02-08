package com.azzedine.brikoli.repository;

import com.azzedine.brikoli.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    
}
