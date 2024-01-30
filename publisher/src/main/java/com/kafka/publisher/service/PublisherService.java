package com.kafka.publisher.service;

import com.kafka.publisher.model.Request;
import com.kafka.publisher.model.Response;

public interface PublisherService {

    Response publisher(Request request);

}
