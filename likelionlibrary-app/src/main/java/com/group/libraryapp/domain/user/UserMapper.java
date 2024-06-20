package com.group.libraryapp.domain.user;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = User.class
)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "age", target = "age")
    })
    UserResponse toUserResponse(User user);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "age", target = "age")
    })
    User toUserEntity(UserCreateRequest request);

    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    User toUpdateUserEntity(UserUpdateRequest request);
}
