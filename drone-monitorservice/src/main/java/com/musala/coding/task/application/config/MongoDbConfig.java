package com.musala.coding.task.application.config;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.mongodb.client.MongoClient;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;




@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore({ MongoAutoConfiguration.class })
@ConditionalOnClass({ MongoClient.class, MongodStarter.class })
@Import({ 
    EmbeddedMongoAutoConfiguration.class,
   
})
public class MongoDbConfig {
	
	
	
	public static final int DFLT_PORT_NUMBER = 27017;
    public static final String DFLT_REPLICASET_NAME = "rs0";
    public static final int DFLT_STOP_TIMEOUT_MILLIS = 200;

    @Bean
    public MongodConfig mongodConfig() throws UnknownHostException, IOException {
       
    	MongodConfig mongodConfig = MongodConfig.builder()
    		    .version(Version.Main.DEVELOPMENT)
    		    .net(new Net(DFLT_PORT_NUMBER, Network.localhostIsIPv6()))
    		    .build();
    	
        return mongodConfig;
    }
    
    
    
    
	   
	    
	    
	   
}
