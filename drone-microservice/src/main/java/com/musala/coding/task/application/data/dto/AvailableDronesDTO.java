package com.musala.coding.task.application.data.dto;

import java.util.List;

import lombok.Data;

public @Data class AvailableDronesDTO {
	
	private int total;
	private List<DroneDTO> drones;

}
