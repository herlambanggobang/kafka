package com.kafka.publisher.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.publisher.model.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PublisherUtil {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String produceMessage(Request request) {
        try {
            String message = MapperUtil.mapper().writeValueAsString(request);

            kafkaTemplate.send(request.getTopicName(), message);

            log.info("success, message : {}", message);
            return "success";
        } catch (KafkaException e) {
            log.error("error kafka : {}", e.getLocalizedMessage());
            return e.getMessage();
        } catch (JsonProcessingException e) {
            log.error("error json : {}", e.getLocalizedMessage());
            return e.getMessage();
        }
    }

}
