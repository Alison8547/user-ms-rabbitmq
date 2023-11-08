package com.ms.user.producer;

import com.ms.user.config.RabbitMQConfig;
import com.ms.user.domain.User;
import com.ms.user.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;
    private final RabbitTemplate rabbitTemplate;


    public void publishMessageEmail(User user) {
        var emailDto = new EmailDto();
        emailDto.setIdUser(user.getIdUser());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Registration completed successfully!");
        emailDto.setText(user.getName() + ", welcome thank you for registering in the system!");

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, emailDto);
    }

}
