package com.sebastian.powerup.emazon.application;

import com.sebastian.powerup.emazon.domain.model.Brand;
import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.port.IBrandRepository;
import org.springframework.data.domain.Page;

public class BrandService {
    private final IBrandRepository iBrandRepository;

    public BrandService(IBrandRepository iBrandRepository) {
        this.iBrandRepository = iBrandRepository;
    }

    public Brand save(Brand brand) {
        return iBrandRepository.save(brand);
    }

    public Iterable<Brand> findAll() {
        return iBrandRepository.findAll();
    }

    public Brand findById(Integer id) {
        return iBrandRepository.findById(id);
    }

    public void delete(Integer id) {
        iBrandRepository.deleteById(id);
    }

    public Page<Brand> findAll(PageableQuery pageableQuery) {
        return iBrandRepository.getAll(pageableQuery);
    }
}
