package com.sebastian.powerup.emazon.domain.port;

import com.sebastian.powerup.emazon.domain.model.Category;

public interface ICategoryRepository {
    Category save(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);
}
