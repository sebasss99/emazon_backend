package com.sebastian.powerup.emazon.domain.port;

import com.sebastian.powerup.emazon.domain.model.User;

public interface IUserRepository {
   User save (User user);
   User findById(Integer id);
}
