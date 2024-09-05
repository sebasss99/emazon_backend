package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
