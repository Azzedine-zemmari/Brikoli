package com.azzedine.brikoli.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azzedine.brikoli.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
