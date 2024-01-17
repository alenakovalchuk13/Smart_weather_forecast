package by.weatherapp.weatherapp.controller;

import by.weatherapp.weatherapp.dto.AuthenticationRequest;
import by.weatherapp.weatherapp.dto.AuthenticationResponse;
import by.weatherapp.weatherapp.dto.RegisterRequest;
import by.weatherapp.weatherapp.model.User;
import by.weatherapp.weatherapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.login(request), HttpStatus.OK);
    }
}
