package com.florista.florista.service;


import com.florista.florista.model.User;
import com.florista.florista.model.Gardener;
import com.florista.florista.service.GardenerService;
import com.florista.florista.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class UserService {

    private Map<String, User> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;
    private final GardenerService gardenerService;

    public UserService(PasswordEncoder passwordEncoder, GardenerService gardenerService) {
        this.passwordEncoder = passwordEncoder;
        this.gardenerService = gardenerService;
    }


    public String register(User user) {
        if (users.containsKey(user.getEmail())) {
            return "User already exists";
        }
        // 🔐 encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.put(user.getEmail(), user);

        // If registering as gardener, create a Gardener entry
        if ("gardener".equalsIgnoreCase(user.getRole())) {
            Gardener gardener = new Gardener();
            gardener.setName(user.getName());
            gardener.setLocation("Not set"); // You can update this to accept location from frontend
            gardener.setPricePerHour(0.0); // Default price, can be updated later
            gardenerService.addGardener(gardener);
        }
        return "User registered successfully";
    }

    public String login(String email, String password) {

        if (!users.containsKey(email)) {
            return "User not found";
        }

        User user = users.get(email);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid password";
        }

        return JwtUtil.generateToken(email);
    }
}