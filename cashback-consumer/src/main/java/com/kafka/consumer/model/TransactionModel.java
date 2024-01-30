package com.kafka.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionModel {

    private String topicName;
    private String source;
    private String destination;
    private String referenceNumber;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal amountCashback;

}
