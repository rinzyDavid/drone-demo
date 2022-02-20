package com.musala.coding.task.application.data.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

public @Data class AuditDTO {
	
	private List<DroneBatteryDTO> drones;
	private int total;
	private LocalDateTime dateTime;

}
