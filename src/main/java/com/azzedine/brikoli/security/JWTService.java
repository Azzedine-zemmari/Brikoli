package com.azzedine.brikoli.security;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
    private String SECRET_KEY ;

    public JWTService(Dotenv dotenv){
        SECRET_KEY = dotenv.get("JWT_SECRET");
    }

    public String generateToken(UserDetails userDetails){
        Long expiration = 1000L * 60 * 60;

        String role = userDetails.getAuthorities()
        .stream()
        .findFirst()
        .map(GrantedAuthority::getAuthority)
        .orElseThrow(()-> new RuntimeException("role not found"));

        return Jwts.builder()
        .subject(userDetails.getUsername())
        .claim("role",role)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .compact();
    }
}
