package com.florista.florista;


import com.florista.florista.model.Gardener;
import com.florista.florista.model.User;
import com.florista.florista.service.GardenerService;
import com.florista.florista.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FloristaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FloristaApplication.class, args);
	}


	@Bean
	public CommandLineRunner seedData(GardenerService gardenerService, UserService userService) {
		return args -> {
			// Seed Gardeners
			gardenerService.addGardener(new Gardener(0, "Alice Green", "New York", 25.0));
			gardenerService.addGardener(new Gardener(0, "Bob Bloom", "San Francisco", 30.0));
			gardenerService.addGardener(new Gardener(0, "Charlie Leaf", "Chicago", 20.0));

			// Seed Users
			userService.register(new User("Test User", "test@example.com", "password123", "user"));
			userService.register(new User("Jane Doe", "jane@example.com", "password456", "user"));
		};
	}
}
