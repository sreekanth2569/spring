package com.example.sri;

import com.example.sri.entity.User;
import com.example.sri.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SriApplication {

    public static void main(String[] args) {
        SpringApplication.run(SriApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            UserRepository repository,
            PasswordEncoder encoder) {

        return args -> {

            if (repository.findByUsername("admin").isEmpty()) {

                repository.save(
                        User.builder()
                                .username("admin")
                                .password(
                                        encoder.encode("admin123")
                                )
                                .role("ADMIN")
                                .build()
                );
            }
        };
    }
}