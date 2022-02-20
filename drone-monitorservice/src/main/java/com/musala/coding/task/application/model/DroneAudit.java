package com.musala.coding.task.application.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="event_audit")
public @Data class DroneAudit {
	
	@Id
	private String id;
	private List<DroneBatteryLog> drones;
	private LocalDateTime dateTime;
	

}
