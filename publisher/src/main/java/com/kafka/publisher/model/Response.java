package com.kafka.publisher.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    private Request request;
    private String errorCode;
    private String errorMessage;

}
