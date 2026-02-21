package com.azzedine.brikoli.repository;

import com.azzedine.brikoli.entity.Mission;
import com.azzedine.brikoli.enums.MissionStatus;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    List<Mission> findByClientUserId(Long userId);
    long countByMissionStatusAndClientId(MissionStatus status, Long clientId);
    @Query("SELECT COUNT(m) FROM Mission m WHERE m.client.user.id = :userId")
    Integer countMissionsByUserId(@Param("userId") Long userId);
        @Query("""
            SELECT m 
            FROM Mission m
            JOIN FETCH m.client c
            JOIN FETCH c.user
            WHERE m.id = :id
        """)
    Optional<Mission> findMissionWithClientAndUser(@Param("id") Long id);
}
