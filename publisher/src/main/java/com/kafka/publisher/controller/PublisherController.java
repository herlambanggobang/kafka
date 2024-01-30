package com.kafka.publisher.controller;

import com.kafka.publisher.model.Request;
import com.kafka.publisher.model.Response;
import com.kafka.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poc/")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("publish")
    public ResponseEntity<Response> publisher(@RequestBody Request request) {
        return new ResponseEntity<>(publisherService.publisher(request), HttpStatus.OK);
    }

}
