package com.azzedine.brikoli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azzedine.brikoli.entity.ClientProfile;

import ch.qos.logback.core.net.server.Client;

public interface ClientRepository extends JpaRepository<ClientProfile,Long>{
    Optional<ClientProfile> findByUserId(Long userId);
}
