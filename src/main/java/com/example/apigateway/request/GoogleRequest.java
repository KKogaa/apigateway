package com.example.apigateway.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoogleRequest {

    String access_token;

    public GoogleRequest(String access_token) {
        this.access_token = access_token;
    }
}