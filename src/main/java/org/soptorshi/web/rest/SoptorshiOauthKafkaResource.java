package org.soptorshi.web.rest;

import org.soptorshi.service.SoptorshiOauthKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/soptorshi-oauth-kafka")
public class SoptorshiOauthKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SoptorshiOauthKafkaResource.class);

    private SoptorshiOauthKafkaProducer kafkaProducer;

    public SoptorshiOauthKafkaResource(SoptorshiOauthKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
