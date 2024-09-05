package com.sebastian.powerup.emazon.domain.port;

import com.sebastian.powerup.emazon.application.PageableQuery;
import com.sebastian.powerup.emazon.domain.model.Brand;
import org.springframework.data.domain.Page;

public interface IBrandRepository {
    Brand save(Brand brand);
    Iterable<Brand> findAll();
    Brand findById(Integer id);
    void deleteById(Integer id);

    Page<Brand> getAll(PageableQuery pageableQuery);
}
