package com.cg.api.apkafkaiapi.service;

import com.cg.api.apkafkaiapi.constant.AppConstants;
import com.cg.api.apkafkaiapi.model.OrderMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_MESSAGE, message);
    }

    public void saveOrderLog(OrderMeta orderMeta)
    {
        logger.info(String.format("Order created -> %s", orderMeta));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_ORDER_LOG, orderMeta);
    }

}
