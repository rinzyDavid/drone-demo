package com.musala.coding.task.application.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import lombok.Data;

/**
 * 
 * @author David
 * Entity class to map drone data in database
 *
 */


@Entity
@Table(name ="drones")
public @Data class Drone {
	
	@Id
	@Column(name="serial_number", length = 100)
	private String serialNumber;
	
	@Column(name="model")
	@Enumerated(value = EnumType.STRING)
	private DroneModel deonModel;
	
	@Column(name="weight_max")
	@DecimalMax(value = "500", message =" Drone cannot carry more than {value} grams")
	private Double maxWeight; // Maximum weight the drone can carry
	
	@Column(name="battery_capacity")
	private Integer batteryLife; // Battery capacity measured in percentage %
	
	@Column(name = "drone_state")
	@Enumerated(value = EnumType.STRING)
	private DroneState droneState; // Current state of the drone
	
	@Column(name = "current_weight")
	private Double currentWeight; // This will keep track the weight of the drone during loading, to prevent 
	
	
	

}
