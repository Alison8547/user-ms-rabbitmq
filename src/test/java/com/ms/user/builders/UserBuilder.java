package com.ms.user.builders;

import com.ms.user.domain.User;
import com.ms.user.dto.request.UserRequest;
import com.ms.user.dto.response.UserResponse;

import java.util.UUID;

public class UserBuilder {

    public static User newUserEntity() {
        return User.builder()
                .idUser(UUID.fromString("8f675e78-a8d4-4f4c-aa73-5127b237c1d1"))
                .name("Alison")
                .email("alison@hotmail.com")
                .build();

    }

    public static UserRequest newUserRequest() {
        return UserRequest.builder()
                .name("Alison")
                .email("alison@hotmail.com")
                .build();
    }

    public static UserResponse newUserResponse() {
        return UserResponse.builder()
                .idUser(UUID.fromString("8f675e78-a8d4-4f4c-aa73-5127b237c1d1"))
                .name("Alison")
                .email("alison@hotmail.com")
                .build();
    }
}
