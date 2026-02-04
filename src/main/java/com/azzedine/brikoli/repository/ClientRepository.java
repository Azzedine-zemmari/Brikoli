package com.azzedine.brikoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azzedine.brikoli.entity.ClientProfile;

public interface ClientRepository extends JpaRepository<ClientProfile,Long>{
    
}
