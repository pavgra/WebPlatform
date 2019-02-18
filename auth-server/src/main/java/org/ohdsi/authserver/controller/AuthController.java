package org.ohdsi.authserver.controller;

import lombok.val;
import org.ohdsi.authserver.model.AuthenticationRequest;
import org.ohdsi.authserver.model.Role;
import org.ohdsi.authserver.model.User;
import org.ohdsi.authserver.security.jwt.JwtTokenProvider;
import org.ohdsi.authserver.service.AuthService;
import org.ohdsi.authserver.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final Map<String, AuthService> authServices;
    private final UserService userService;

    public AuthController(
            JwtTokenProvider jwtTokenProvider,
            List<AuthService> authServices,
            UserService userService) {

        this.jwtTokenProvider = jwtTokenProvider;
        this.authServices = authServices
                .stream()
                .filter(authService -> authService.getMethod() != null)
                .collect(Collectors.toMap(AuthService::getMethod, authService -> authService));
        this.userService = userService;
    }

    @PostMapping("/{method}")
    public HashMap<String, String> authenticate(@PathVariable("method") String method, @RequestBody AuthenticationRequest data) {

        String username = data.getUsername();
        String password = data.getPassword();

        AuthService authService = authServices.get(method);

        if (authService == null) {
            throw new IllegalArgumentException(String.format("Authentication method \"%s\" doesn't exist", method));
        }

        if (!authService.login(username, password)) {
            throw new BadCredentialsException("Bad credentials");
        }

        User user = userService.getOrCreate(username);

        val model = new HashMap<String, String>();
        model.put("username", user.getUsername());
        model.put("token", jwtTokenProvider.createToken(user.getUsername(), user.getRoles().stream().map(Role::getName).collect(Collectors.toList())));

        return model;
    }
}
