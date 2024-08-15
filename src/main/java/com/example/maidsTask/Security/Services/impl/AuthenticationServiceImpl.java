package com.example.maidsTask.Security.Services.impl;

import com.example.maidsTask.Security.Model.Role;
import com.example.maidsTask.Security.Model.User;
import com.example.maidsTask.Security.Repositories.UserRepository;
import com.example.maidsTask.Security.Response.JwtAuthenticationResponse;
import com.example.maidsTask.Security.Services.AuthenticationService;
import com.example.maidsTask.Security.Services.JwtService;
import com.example.maidsTask.Security.request.SignInRequest;
import com.example.maidsTask.Security.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).username(request.getUsername()).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        if(!user.getPassword().equals(request.getPassword()))
        {
            throw new IllegalArgumentException("Invalid Password");
        }
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}