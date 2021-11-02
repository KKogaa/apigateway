package com.example.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AuthService {

    private final JwtUtil2 jwt;

    @Autowired
    public AuthService(final JwtUtil2 jwt) {
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {
        // do validation if user already exists
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

        // UserVO userVO = restTemplate.postForObject("http://user-service/users",
        // authRequest, UserVO.class);
        // Assert.notNull(userVO, "Failed to register user. Please try again later");
        UserVO userVO = new UserVO("id", "email", "password", "role");
        String accessToken = jwt.generate(userVO, "ACCESS");
        String refreshToken = jwt.generate(userVO, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);

    }

}
