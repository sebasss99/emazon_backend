package com.sebastian.powerup.emazon.application;

import com.sebastian.powerup.emazon.domain.model.Product;
import com.sebastian.powerup.emazon.domain.port.IProductRepository;

public class ProductService {
    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }

    public void delete(Integer id) {
        this.iProductRepository.deleteById(id);
    }
}
