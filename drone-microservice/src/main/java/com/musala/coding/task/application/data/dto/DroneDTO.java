package com.musala.coding.task.application.data.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.coding.task.application.data.model.DroneModel;

import lombok.Data;

/**
 * 
 * @author mac
 * DTO class for registering and displaying a drone 
 */

public @Data class DroneDTO {
	
@NotNull(message = "Drone serial umber must not be empty")
@Size(min=3,max=100,message="Drone serial number must not be greater than {value} characters")
@JsonProperty(required = true)
@NotEmpty
@NotBlank
private String serialNumber;
	
	
@JsonProperty(required = true)
@NotNull(message="Drone model must not be empty")
private DroneModel droneModel;
	
	
@DecimalMax(value = "500", message =" Drone cannot carry more than {value} grams")
private Double maxWeight; // Maximum weight the drone can carry
	
@JsonProperty(required = true)
@NotNull(message="Battery life must not be empty or null")	
private Integer batteryLife; 
	
@JsonIgnore
private String droneState; 
	
	
private Double weightLoaded; 
	

}
