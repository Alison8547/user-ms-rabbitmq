package com.ms.user.producer;

import com.ms.user.domain.User;
import com.ms.user.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    @Value("${broker.queue.email.name}")
    private String routingKey;
    private final RabbitTemplate rabbitTemplate;


    public void publishMessageEmail(User user) {
        EmailDto emailDto = new EmailDto();
        emailDto.setUserId(user.getIdUser());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Registration completed successfully!");
        emailDto.setText(user.getName() + ", welcome thank you for registering in the system!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
