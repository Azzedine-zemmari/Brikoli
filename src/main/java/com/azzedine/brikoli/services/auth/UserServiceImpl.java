package com.azzedine.brikoli.services.auth;

import java.net.PasswordAuthentication;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.azzedine.brikoli.dto.RegisterDto;
import com.azzedine.brikoli.mapper.RegisterDtoMapper;
import com.azzedine.brikoli.repository.UserRepository;
import com.azzedine.brikoli.entity.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RegisterDtoMapper registerDtoMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void userRegister(RegisterDto dto){
        User user = registerDtoMapper.dtoToUser(dto);

        Optional<User> isUserExists = userRepository.findByEmail(user.getEmail());
        if(isUserExists.isPresent()){
            // todo : make a custom exception
            throw new RuntimeException("user already exists");
        }

        String hash = passwordEncoder.encode(dto.password());

        user.setPassword(hash);

        userRepository.save(user);

    }
    
}
