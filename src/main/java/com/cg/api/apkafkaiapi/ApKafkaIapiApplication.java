package com.cg.api.apkafkaiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ApKafkaIapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApKafkaIapiApplication.class, args);
	}

}
