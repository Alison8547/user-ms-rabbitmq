package com.ms.user.mapper;

import com.ms.user.domain.User;
import com.ms.user.dto.request.UserRequest;
import com.ms.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;


    public User toEntityUser(UserRequest userRequest) {
        return mapper.map(userRequest, User.class);
    }

    public UserResponse toResponseUser(User user) {
        return mapper.map(user, UserResponse.class);
    }
}
