package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.infrastructure.entity.BrandEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBrandCrudRepository extends CrudRepository<BrandEntity, Integer> {
}
