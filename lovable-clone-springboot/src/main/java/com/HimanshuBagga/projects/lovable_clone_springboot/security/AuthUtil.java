package com.HimanshuBagga.projects.lovable_clone_springboot.security;

import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt.secret-key}")
    private String  jwtSecretKey;


    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }


    public String generateAccessToken(User user){ // access Token
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId", user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))  // 1000 ms -> 1 sec * 60 sec -> 1 min * 10 -> 10min valid time
                .signWith(getSecretKey())
                .compact();
    }


}

