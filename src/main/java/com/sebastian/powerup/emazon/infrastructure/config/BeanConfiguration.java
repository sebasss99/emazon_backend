package com.sebastian.powerup.emazon.infrastructure.config;

import com.sebastian.powerup.emazon.application.UserService;
import com.sebastian.powerup.emazon.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository userRepository) {
        return new UserService(userRepository);
    }
}
