package com.sebastian.powerup.emazon.infrastructure.mapper;

import com.sebastian.powerup.emazon.domain.model.Brand;
import com.sebastian.powerup.emazon.infrastructure.entity.BrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "description", target = "description")
            }
    )
    Brand toBrand(BrandEntity brandEntity);
    Iterable <Brand> toBrandList(Iterable<BrandEntity> brandEntities);

    @InheritInverseConfiguration
    BrandEntity toBrandEntity(Brand brand);
}
