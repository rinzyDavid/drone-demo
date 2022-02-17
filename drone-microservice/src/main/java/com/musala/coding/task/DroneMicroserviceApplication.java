package com.musala.coding.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class DroneMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMicroserviceApplication.class, args);
	}

}
