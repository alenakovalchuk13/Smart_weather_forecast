package by.weatherapp.weatherapp.service;

import by.weatherapp.weatherapp.config.JwtService;
import by.weatherapp.weatherapp.dto.AuthenticationRequest;
import by.weatherapp.weatherapp.dto.AuthenticationResponse;
import by.weatherapp.weatherapp.dto.RegisterRequest;
import by.weatherapp.weatherapp.model.Role;
import by.weatherapp.weatherapp.model.User;
import by.weatherapp.weatherapp.model.UserPrincipal;
import by.weatherapp.weatherapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private String TOKEN;

    public User register(RegisterRequest request) {
        log.info("User register started");

        User userToRegister = User
                .builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(userToRegister);

        log.info("User register completed");

        return userToRegister;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        log.info("User login started");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Optional<User> byEmail = userRepository.findByEmail(request.getEmail());
        if (byEmail.isPresent()) {
            User user = byEmail.get();

            log.info("Create UserPrincipal");

            UserPrincipal userPrincipal = UserPrincipal
                    .builder()
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .role(user.getRole())
                    .build();

            log.info("Generate JWT token");
            TOKEN = jwtService.generateToken(userPrincipal);
            log.info("JWT token generated");
        }

        log.info("Login completed");

        return AuthenticationResponse
                .builder()
                .token(TOKEN)
                .build();
    }
}
