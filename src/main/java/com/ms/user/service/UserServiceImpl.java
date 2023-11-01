package com.ms.user.service;

import com.ms.user.domain.User;
import com.ms.user.dto.request.UserRequest;
import com.ms.user.dto.response.UserResponse;
import com.ms.user.mapper.UserMapper;
import com.ms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User entityUser = mapper.toEntityUser(userRequest);
        userRepository.save(entityUser);
        log.info("Save User success!");

        return mapper.toResponseUser(entityUser);
    }
}
