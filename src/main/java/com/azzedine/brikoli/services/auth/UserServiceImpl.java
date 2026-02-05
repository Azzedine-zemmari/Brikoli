package com.azzedine.brikoli.services.auth;

import java.net.PasswordAuthentication;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.azzedine.brikoli.dto.RegisterDto;
import com.azzedine.brikoli.dto.RequestLoginDto;
import com.azzedine.brikoli.dto.ResponseLoginDto;
import com.azzedine.brikoli.mapper.RegisterDtoMapper;
import com.azzedine.brikoli.repository.ClientRepository;
import com.azzedine.brikoli.repository.ProfessionalRepository;
import com.azzedine.brikoli.repository.UserRepository;
import com.azzedine.brikoli.security.JWTService;

import jakarta.transaction.Transactional;

import com.azzedine.brikoli.entity.ClientProfile;
import com.azzedine.brikoli.entity.ProfessionalProfile;
import com.azzedine.brikoli.entity.User;
import com.azzedine.brikoli.enums.Role;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
 
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RegisterDtoMapper registerDtoMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final ProfessionalRepository professionalRepository;
    private final ClientRepository clientRepository;



    @Override
    @Transactional
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
        if(user.getRole() == Role.PROFESSIONAL){
            ProfessionalProfile professional = new ProfessionalProfile();
            professional.setBio("");
            professional.setLocation("");
            professional.setIsGraduated(dto.graduated() != null ? dto.graduated() : false);
            professional.setCompletedMission(0);
            professional.setRatingAverage(0.0);
            professional.setUser(user);
            professionalRepository.save(professional);
        }
        else{
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setUser(user);
            clientProfile.setAddress("");
            clientProfile.setCity("");
            clientRepository.save(clientProfile);
        }
    }
    @Override
    public ResponseLoginDto login(RequestLoginDto dto) {
            // authentication spring security
    Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(),
                        dto.password()
                )
        );

        // get authenticated user

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // generate token

        String token = jwtService.generateToken(userDetails);

        // get user entity
        User user = userRepository.findByEmail(dto.email()).orElseThrow(()-> new RuntimeException("user not found"));
        
//        UserDto userDto = userDtoMapper.userToDto(user);

        return new ResponseLoginDto(token);
    }
    
}
