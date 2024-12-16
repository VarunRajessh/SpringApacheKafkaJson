package com.example.SpringApacheKafkaJson.service;

import com.example.SpringApacheKafkaJson.entity.User;
import com.example.SpringApacheKafkaJson.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
@Service
public class KafkaProducer {


    private static  final Logger LOGGER= LoggerFactory.getLogger(org.apache.kafka.clients.producer.KafkaProducer.class);
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent -> %s ",data.toString()));
        Message message= MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME)
                .build();

        kafkaTemplate.send(message);


    }

}
