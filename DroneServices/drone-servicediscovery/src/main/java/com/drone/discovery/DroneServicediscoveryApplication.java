package com.drone.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DroneServicediscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneServicediscoveryApplication.class, args);
	}

}
