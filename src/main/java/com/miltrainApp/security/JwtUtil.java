package com.miltrainApp.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET = "your-super-long-and-secure-secret-key-32-characters-min";

    private final long expirationMs = 3600000;

    public String generateToken(Long userId, String login) {
        return Jwts.builder()
                   .setSubject(login)
                   .claim("userId", userId)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                   .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                   .compact();
    }
}
