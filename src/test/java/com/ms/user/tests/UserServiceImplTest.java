package com.ms.user.tests;

import com.ms.user.builders.UserBuilder;
import com.ms.user.dto.response.UserResponse;
import com.ms.user.mapper.UserMapper;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;
import com.ms.user.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserProducer userProducer;

    @Mock
    private UserMapper mapper;

    @Test
    public void testMustSaveUserWithSuccess() {
        //(SETUP)
        when(mapper.toEntityUser(any())).thenReturn(UserBuilder.newUserEntity());
        when(userRepository.save(any())).thenReturn(UserBuilder.newUserEntity());
        when(mapper.toResponseUser(any())).thenReturn(UserBuilder.newUserResponse());

        //(ACT)
        UserResponse savedUser = userService.saveUser(UserBuilder.newUserRequest());

        //(ASSERT)
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(UUID.fromString("8f675e78-a8d4-4f4c-aa73-5127b237c1d1"), savedUser.getIdUser());
        Assertions.assertEquals("Alison", savedUser.getName());
        Assertions.assertEquals("alison@hotmail.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(UserBuilder.newUserEntity());
    }
}
