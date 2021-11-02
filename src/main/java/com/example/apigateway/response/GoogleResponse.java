package com.example.apigateway.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class GoogleResponse {
    String sub;
    String picture;
    String email;
    String email_verified;
}
