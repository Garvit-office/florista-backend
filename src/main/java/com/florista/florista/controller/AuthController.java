package com.florista.florista.controller;

import com.florista.florista.model.User;
import com.florista.florista.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {

        String message = userService.register(user);

        return Map.of("message", message);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String token = userService.login(
                request.get("email"),
                request.get("password")
        );

        return Map.of("token", token);
    }
}