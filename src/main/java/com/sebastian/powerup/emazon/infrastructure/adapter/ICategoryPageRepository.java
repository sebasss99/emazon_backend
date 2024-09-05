package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryPageRepository extends JpaRepository<CategoryEntity, Integer> {
}
