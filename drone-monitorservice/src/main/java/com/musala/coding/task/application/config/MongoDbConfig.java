package com.musala.coding.task.application.config;

import java.io.IOException;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

import com.mongodb.client.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
public class MongoDbConfig {
	
	
	 private static final String MONGO_DB_URL = "localhost";
	    private static final String MONGO_DB_NAME = "embeded_db";
	    
	    @Bean
	    public MongoTemplate mongoTemplate() throws IOException {
	        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	        mongo.setBindIp(MONGO_DB_URL);
	        MongoClient mongoClient = (MongoClient) mongo.getObject();
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
	        return mongoTemplate;
	    }

	    
	    
	    @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	    	return new RestTemplate();
	    	
	    }
}
