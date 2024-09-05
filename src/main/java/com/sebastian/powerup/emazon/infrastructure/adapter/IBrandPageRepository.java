package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.infrastructure.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandPageRepository extends JpaRepository<BrandEntity, Integer> {
}
