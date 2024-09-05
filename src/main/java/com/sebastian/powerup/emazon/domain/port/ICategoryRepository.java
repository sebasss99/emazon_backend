package com.sebastian.powerup.emazon.domain.port;

import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.application.PageableQuery;
import org.springframework.data.domain.Page;

public interface ICategoryRepository {
    Category save(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);

    Page<Category> getAll(PageableQuery pageableQuery);
}
