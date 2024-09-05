package com.sebastian.powerup.emazon.infrastructure.config;

import com.sebastian.powerup.emazon.application.BrandService;
import com.sebastian.powerup.emazon.application.CategoryService;
import com.sebastian.powerup.emazon.application.ProductService;
import com.sebastian.powerup.emazon.application.UserService;
import com.sebastian.powerup.emazon.domain.port.IBrandRepository;
import com.sebastian.powerup.emazon.domain.port.ICategoryRepository;
import com.sebastian.powerup.emazon.domain.port.IProductRepository;
import com.sebastian.powerup.emazon.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository) {
        return new CategoryService(iCategoryRepository);
    }

    @Bean
    public BrandService brandService(IBrandRepository iBrandRepository) {
        return new BrandService(iBrandRepository);
    }

    @Bean
    public ProductService productService(IProductRepository iProductRepository) {
        return new ProductService(iProductRepository);
    }
}
