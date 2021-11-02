package com.example.apigateway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimsFromToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    private boolean isTokenExpired(String token) {

        try {
            Claims claims = this.getAllClaimsFromToken(token);
            if (claims == null)
                return true;
            return this.getAllClaimsFromToken(token).getExpiration().before(new Date());

        } catch (Exception e) {
            return true;
        }
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }

}