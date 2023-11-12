package com.ms.user.tests;

import com.ms.user.builders.UserBuilder;
import com.ms.user.dto.EmailDto;
import com.ms.user.producer.UserProducer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserProducerTest {


    @InjectMocks
    private UserProducer userProducer;


    @Mock
    private UserProducer userProducerMock;


    @Mock
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testMustPublishMessageEmailWithSuccess() {
        //(SETUP)


        var emailDto = new EmailDto();
        emailDto.setIdUser(UserBuilder.newUserEntity().getIdUser());
        emailDto.setEmailTo(UserBuilder.newUserEntity().getEmail());
        emailDto.setSubject("Registration completed successfully!");
        emailDto.setText(UserBuilder.newUserEntity().getName() + ", welcome thank you for registering in the system!");


        //(ACT)
        userProducerMock.publishMessageEmail(UserBuilder.newUserEntity());

        //(ASSERT)
        verify(userProducerMock, times(1)).publishMessageEmail(UserBuilder.newUserEntity());


    }

    @Test
    public void testMustEmailDtoWithSuccess() {
        //(SETUP)


        var emailDto = new EmailDto();
        emailDto.setIdUser(UserBuilder.newUserEntity().getIdUser());
        emailDto.setEmailTo(UserBuilder.newUserEntity().getEmail());
        emailDto.setSubject("Registration completed successfully!");
        emailDto.setText(UserBuilder.newUserEntity().getName() + ", welcome thank you for registering in the system!");


        //(ACT)
        userProducer.publishMessageEmail(UserBuilder.newUserEntity());

        //(ASSERT)
        Assertions.assertNotNull(emailDto);
        Assertions.assertEquals(UUID.fromString("8f675e78-a8d4-4f4c-aa73-5127b237c1d1"), emailDto.getIdUser());
        Assertions.assertEquals("alison@hotmail.com",emailDto.getEmailTo());

    }

}
