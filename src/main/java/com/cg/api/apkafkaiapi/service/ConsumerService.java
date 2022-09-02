package com.cg.api.apkafkaiapi.service;

import com.cg.api.apkafkaiapi.constant.AppConstants;
import com.cg.api.apkafkaiapi.model.OrderMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);


    @KafkaListener(topics = AppConstants.TOPIC_NAME_MESSAGE, groupId = AppConstants.GROUP_ID)
    public void consume(String message) {
        logger.info(String.format("Message received -> %s", message));
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME_ORDER_LOG, groupId = AppConstants.GROUP_ID)
    public void consume(OrderMeta orderMeta) {
        logger.info(String.format("Order received -> %s", orderMeta));
    }

}
