package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductPageRepository extends JpaRepository<ProductEntity, Integer> {
}
