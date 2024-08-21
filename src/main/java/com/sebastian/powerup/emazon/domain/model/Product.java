package com.sebastian.powerup.emazon.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer userId;
    private Integer categoryId;
}
