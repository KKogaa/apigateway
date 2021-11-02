// package com.example.apigateway.controller;

// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import
// org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
// import org.springframework.security.oauth2.core.OAuth2AccessToken;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.*;

// @RestController
// @RequestMapping("/greeting")
// public class GreetingController {

// @GetMapping("")
// public OAuth2AccessToken greeting(@AuthenticationPrincipal OidcUser oidcUser,
// Model model,
// @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client) {
// model.addAttribute("username", oidcUser.getEmail());
// model.addAttribute("idToken", oidcUser.getIdToken());
// model.addAttribute("accessToken", client.getAccessToken());

// return client.getAccessToken();
// }
// }
