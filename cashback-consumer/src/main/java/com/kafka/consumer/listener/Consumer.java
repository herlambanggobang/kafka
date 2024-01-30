package com.kafka.consumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.model.TransactionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${kafka.topic-name}",
            groupId = "${kafka.group-id}")

    // Method
    public void consume(String message) {
        // Print statement
        log.info("this is cashback consumer");
        log.info("message : {}", message);

        try {
            ObjectMapper mapper = new ObjectMapper();
            TransactionModel transactionModel = mapper.readValue(message, TransactionModel.class);
            log.info("object : {}", transactionModel);
        } catch (JsonProcessingException e) {
            log.error("exception, ex : {}", e.getMessage());
        }


    }

}
