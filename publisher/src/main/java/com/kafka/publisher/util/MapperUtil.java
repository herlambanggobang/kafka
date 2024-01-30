package com.kafka.publisher.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public static ObjectMapper mapper() {
        ObjectMapper mapper =
                new ObjectMapper()
                        .registerModule(new ParameterNamesModule())
                        .registerModule(new Jdk8Module())
                        .registerModule(new JavaTimeModule())
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

}
