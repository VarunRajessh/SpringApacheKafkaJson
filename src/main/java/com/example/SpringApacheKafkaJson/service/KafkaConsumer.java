package com.example.SpringApacheKafkaJson.service;

import com.example.SpringApacheKafkaJson.entity.User;
import com.example.SpringApacheKafkaJson.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = AppConstants.TOPIC_NAME,groupId = AppConstants.GROUP_ID)
    public void consume(User data){
        LOGGER.info(String.format("Message received -> %s", data.toString()));
    }
}
