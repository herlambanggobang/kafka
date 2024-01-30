package com.kafka.publisher.service.impl;

import com.kafka.publisher.model.Request;
import com.kafka.publisher.model.Response;
import com.kafka.publisher.service.PublisherService;
import com.kafka.publisher.util.PublisherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherUtil publisherUtil;

    @Override
    public Response publisher(Request request) {

        if(!validateRequest(request))
            return Response.builder().request(request).errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value())).errorMessage(HttpStatus.BAD_REQUEST.toString()).build();

        if(request.getReferenceNumber().equalsIgnoreCase("123"))
            return Response.builder().request(request).errorCode(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value())).errorMessage(HttpStatus.NOT_ACCEPTABLE.toString()).build();

        String response = publisherUtil.produceMessage(request);

        if(!response.equalsIgnoreCase("success"))
            return Response.builder().request(request).errorCode(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value())).errorMessage(HttpStatus.NOT_ACCEPTABLE.toString()).build();

        return Response.builder().request(request).errorCode(String.valueOf(HttpStatus.OK.value())).errorMessage(HttpStatus.OK.toString()).build();
    }

    private boolean validateRequest(Request request) {

        if(!StringUtils.hasLength(request.getTopicName())
            || !StringUtils.hasLength(request.getSource())
            || !StringUtils.hasLength(request.getDestination())
            || !StringUtils.hasLength(request.getReferenceNumber())
            || (request.getAmount() == null || request.getAmount().compareTo(BigDecimal.ZERO) <= 0)
                || request.getFee() == null
            || request.getAmountCashback() ==null)
            return false;

        return true;

    }
}
