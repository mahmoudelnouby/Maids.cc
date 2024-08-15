package com.example.maidsTask.Security.Services;


import com.example.maidsTask.Security.Response.JwtAuthenticationResponse;
import com.example.maidsTask.Security.request.SignInRequest;
import com.example.maidsTask.Security.request.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}