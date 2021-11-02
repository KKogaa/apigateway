// package com.example.apigateway.client;

// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

// @FeignClient(value = "jplaceholder", url =
// "https://www.googleapis.com/oauth2/v3/userinfo")
// public interface GoogleClient {
// @RequestMapping(method = RequestMethod.POST, value = "/ ", produces =
// "application/json")
// GoogleResponse getResponse(@RequestBody GoogleRequest googleRequest);

// }