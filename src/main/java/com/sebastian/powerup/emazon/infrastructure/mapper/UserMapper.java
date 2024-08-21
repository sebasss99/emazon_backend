package com.sebastian.powerup.emazon.infrastructure.mapper;

import com.sebastian.powerup.emazon.domain.model.User;
import com.sebastian.powerup.emazon.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "userType", target = "userType")
            }
    )

    User toUser(UserEntity userEntity);
    Iterable <User> toUsers(Iterable<UserEntity> userEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);
}
