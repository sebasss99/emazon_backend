package com.sebastian.powerup.emazon.application;

import com.sebastian.powerup.emazon.domain.model.User;
import com.sebastian.powerup.emazon.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save(User user) {
        return iUserRepository.save(user);
    }

    public User findById(Integer id) {
        return this.iUserRepository.findById(id);
    }
}
