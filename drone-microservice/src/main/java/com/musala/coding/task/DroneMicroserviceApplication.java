package com.musala.coding.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableEurekaClient
@EnableDiscoveryClient
public class DroneMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMicroserviceApplication.class, args);
	}

}
