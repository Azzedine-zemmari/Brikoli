package com.azzedine.brikoli.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.azzedine.brikoli.repository.UserRepository;
import com.azzedine.brikoli.entity.User;

import lombok.AllArgsConstructor;
import java.util.Collections;

@Service
@AllArgsConstructor
public class CustomUserDetails implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username));
        
        GrantedAuthority authority = new SimpleGrantedAuthority(String.valueOf("ROLE_" + user.getRole()));

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .authorities(Collections.singletonList(authority))
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build();
    }

}