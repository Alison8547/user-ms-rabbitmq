package com.ms.user.service;

import com.ms.user.dto.request.UserRequest;
import com.ms.user.dto.response.UserResponse;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    UserResponse saveUser(UserRequest userRequest);
}
