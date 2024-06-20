package com.group.libraryapp.domain.user;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T15:29:40+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.name( user.getName() );
        userResponse.age( user.getAge() );

        return userResponse.build();
    }

    @Override
    public User toUserEntity(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        Integer age = null;

        name = request.getName();
        age = request.getAge();

        User user = new User( name, age );

        return user;
    }

    @Override
    public User toUpdateUserEntity(UserUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;

        name = request.getName();

        Integer age = null;

        User user = new User( name, age );

        return user;
    }
}
