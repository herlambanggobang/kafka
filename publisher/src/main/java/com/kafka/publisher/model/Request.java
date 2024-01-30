package com.kafka.publisher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private String topicName;
    private String source;
    private String destination;
    private String referenceNumber;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal amountCashback;

}
