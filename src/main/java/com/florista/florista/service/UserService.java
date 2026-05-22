package com.florista.florista.service;


import com.florista.florista.model.User;
import com.florista.florista.model.Gardener;
import com.florista.florista.repository.UserRepository;
import com.florista.florista.service.GardenerService;
import com.florista.florista.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final GardenerService gardenerService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, GardenerService gardenerService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.gardenerService = gardenerService;
    }

    public String register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "User already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        if ("gardener".equalsIgnoreCase(user.getRole())) {
            Gardener gardener = new Gardener();
            gardener.setName(user.getName());
            // Use location and pricePerHour if provided
            try {
                java.lang.reflect.Field locationField = user.getClass().getDeclaredField("location");
                java.lang.reflect.Field priceField = user.getClass().getDeclaredField("pricePerHour");
                locationField.setAccessible(true);
                priceField.setAccessible(true);
                String location = (String) locationField.get(user);
                Double price = priceField.get(user) != null ? ((Number) priceField.get(user)).doubleValue() : 0.0;
                gardener.setLocation(location != null ? location : "Not set");
                gardener.setPricePerHour(price);
            } catch (Exception e) {
                gardener.setLocation("Not set");
                gardener.setPricePerHour(0.0);
            }
            gardenerService.addGardener(gardener);
        }
        return "User registered successfully";
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User not found";
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid password";
        }
        return JwtUtil.generateToken(email);
    }
}