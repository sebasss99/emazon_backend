package com.sebastian.powerup.emazon.application;

import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.port.ICategoryRepository;

public class CategoryService {
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    public Category findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    public void delete(Integer id) {
        iCategoryRepository.deleteById(id);
    }
}
