package com.example.apigateway.controller;

import org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi.sha256WithSM2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import java.util.*;

// import com.example.apigateway.client.GoogleClient;
import com.example.apigateway.request.GoogleRequest;
import com.example.apigateway.response.GoogleResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;
    // private final GoogleClient googleClient;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
        // this.googleClient = googleClient;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.register(authRequest));
    }

    @GetMapping(value = "/hi")
    public void test() {
        // GoogleResponse googleResponse = googleClient.getResponse(new
        // GoogleRequest("asdfljalsdfj"));
        // System.out.println(googleResponse.getEmail());

        // GoogleRequest req = new GoogleRequest("dfsdlfadsf");
        // WebClient webClient =
        // WebClient.create("https://www.googleapis.com/oauth2/v3/userinfo");

        // GoogleResponse createdEmployee = webClient.post().uri("")
        // .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        // .body(Mono.just(req),
        // GoogleRequest.class).retrieve().bodyToMono(GoogleRequest.class);
        // WebClient client =
        // WebClient.create("https://www.googleapis.com/oauth2/v3/userinfo");
        // String response =
        // client.post().contentType(MediaType.APPLICATION_FORM_URLENCODED)
        // .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();

        String access_token = "ya29.a0ARrdaM9zKQF00vfu_GU-O6oJHh-E-GdEdMWwHpytUQkwBPxxTluNO_lC0sphybWWtZ6SE_RyT-OCtKfBtR-NaJh7mOZ1sVhG9WwDAV16hfXeN9K3xcrEPkOrm0Fyh2TYkFMhO4w40r0uIaEr5UtVcO2ZNuvh";
        String url = "https://www.googleapis.com/oauth2/v3/userinfo" + "?access_token=" + access_token;
        Mono<GoogleResponse> response = WebClient.create(url).method(HttpMethod.POST)
                .contentType(MediaType.APPLICATION_JSON).retrieve().bodyToMono(GoogleResponse.class);

        // GoogleResponse resp = response.share().block();

        System.out.println(response.subscribe(gResp -> System.out.println(gResp.getEmail())));
        // System.out.println(response);
        // response.subscribe(value -> System.out.println(value));

    }

}
