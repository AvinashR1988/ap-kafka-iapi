package com.cg.api.apkafkaiapi.controller;

import com.cg.api.apkafkaiapi.model.OrderMeta;
import com.cg.api.apkafkaiapi.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestParam("message") String message) {
        this.producerService.sendMessage(message);
    }

    @PostMapping(value = "/createOrder")
    public void sendMessageToKafkaTopic(@RequestBody OrderMeta orderMeta){
        this.producerService.saveOrderLog(orderMeta);
    }
}
