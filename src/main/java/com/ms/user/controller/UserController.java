package com.ms.user.controller;

import com.ms.user.dto.request.UserRequest;
import com.ms.user.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping
public interface UserController {

    @PostMapping("/save-user")
    ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest userRequest);
}
