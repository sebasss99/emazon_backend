package com.sebastian.powerup.emazon.domain.port;

import com.sebastian.powerup.emazon.application.PageableQuery;
import com.sebastian.powerup.emazon.domain.model.Product;
import org.springframework.data.domain.Page;

public interface IProductRepository {
    Product save (Product product);
    Iterable<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);

    Page<Product> getAll(PageableQuery pageableQuery);
}
