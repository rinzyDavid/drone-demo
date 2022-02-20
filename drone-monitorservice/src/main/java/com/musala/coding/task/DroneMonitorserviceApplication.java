package com.musala.coding.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.musala.coding.task.application.service.AuditService;
import com.musala.coding.task.application.service.impl.AuditServiceImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableScheduling
public class DroneMonitorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneMonitorserviceApplication.class, args);
	}
	
	
	 @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	    	return new RestTemplate();
	    	
	    }
	 
	 
	 @Bean
	 public AuditService auditService() {
		 return new AuditServiceImpl();
	 }

}
