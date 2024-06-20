package com.group.libraryapp.service.user;

import com.group.libraryapp.common.exception.BusinessException;
import com.group.libraryapp.common.exception.Error;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserMapper;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long saveUser(UserCreateRequest userCreateRequest) {

        User user = userMapper.toUserEntity(userCreateRequest);
        userRepository.save(user);
        return user.getId();
    }

    public UserResponse getUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException(Error.USER_NOT_FOUND));
        return userMapper.toUserResponse(user);
    }

    @Transactional
    public Long updateUser(UserUpdateRequest updateRequest) {

        User user = userRepository.findById(updateRequest.getId())
                .orElseThrow(() -> new BusinessException(Error.USER_NOT_FOUND));

        user.updateUser(updateRequest.getName());
        return user.getId();
    }

    public Long deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Error.USER_NOT_FOUND));

        userRepository.deleteById(id);

        return user.getId();
    }
}
