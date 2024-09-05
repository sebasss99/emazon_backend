package com.sebastian.powerup.emazon.infrastructure.mapper;

import com.sebastian.powerup.emazon.domain.model.Product;
import com.sebastian.powerup.emazon.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "userId", target = "userId"),
                    @Mapping(source = "categoryId", target = "categoryId")
            }
    )
    Product toProduct(ProductEntity productEntity);
    Iterable <Product> toProductList(Iterable<ProductEntity> productEntities);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);
}
