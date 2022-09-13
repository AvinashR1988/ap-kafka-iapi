package com.cg.api.apkafkaiapi.service;

import com.cg.api.apkafkaiapi.constant.AppConstants;
import com.cg.api.apkafkaiapi.model.OrderMeta;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "${general.topic.name}",
            groupId = "${general.topic.group.id}")
    public void consume(String message) {
        logger.info(String.format("Message received -> %s", message));
    }

    /*@KafkaListener(topics = "${order.topic.name}",
            groupId = "${order.topic.group.id}",
            containerFactory = "orderKafkaListenerContainerFactory")*/
    @KafkaListener(topics = "${order.topic.name}",
            groupId = "${order.topic.group.id}")
    public void consume(ConsumerRecord<String, String> consumerRecord) {
        System.out.println(consumerRecord);
        logger.info(String.format("Order received -> %s", consumerRecord));
    }



}
