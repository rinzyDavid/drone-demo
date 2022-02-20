package com.musala.coding.task.resource.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musala.coding.task.application.data.dto.AuditDTO;
import com.musala.coding.task.application.data.dto.AvailableDronesDTO;
import com.musala.coding.task.application.data.dto.DroneBatteryDTO;
import com.musala.coding.task.application.data.dto.DroneDTO;
import com.musala.coding.task.application.service.DroneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author mac
 * This Drone Controller will expose the following services
 * 1. Register a new drone
 * 2. Check drone battery life
 * 3. Check available drones for loading
 * 4. Get drone audit
 *
 */

@RestController
@RequestMapping(path = {"/api/v1/drones"}, produces = APPLICATION_JSON_VALUE)
public class DroneApiResource {
	
	
	@Autowired 
	private DroneService droneService;
	
	
	
	
	@PostMapping(value="/register",consumes=APPLICATION_JSON_VALUE)
	@Operation(summary = "Register a new drone")
	@ApiResponse(responseCode = "201", description = "New drone created", 
	content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DroneDTO.class))})
	public ResponseEntity<DroneDTO> registerDrone(@Valid @RequestBody DroneDTO dto){
		
		DroneDTO _dto = droneService.registerDrone(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(_dto);
	}
	
	
	
	@Operation(summary = "Get a drone with its battery life using serial number")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the drone", 
	content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DroneBatteryDTO.class))}),
			@ApiResponse(responseCode = "404", description = "Drone not found", content = @Content)})
	@GetMapping(path = "/{serialNumber}")
	public ResponseEntity<DroneBatteryDTO> getDroneBattery(@PathVariable("serialNumber")String serialNumber){
		
		DroneBatteryDTO dto = droneService.checkBattery(serialNumber);
		if(dto!=null) {
			return ResponseEntity.ok(dto);
		}
		else
			return ResponseEntity.notFound().build();
		
	}
	
	
	@GetMapping("/available")
	@Operation(summary = "Get a list of drones available for loading")
	@ApiResponse(responseCode = "201", description = "Drones found", 
	content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AvailableDronesDTO.class))})
	public ResponseEntity<AvailableDronesDTO> findAvailableDrones(){
		
		AvailableDronesDTO dto = droneService.listAvailableDrones();
		return ResponseEntity.ok(dto);
	}
	
	
	
	@GetMapping("/audit")
	public ResponseEntity<AuditDTO> getDroneAudit(){
		AuditDTO audit = droneService.getDroneAudit();
		return ResponseEntity.ok(audit);
		
	}
	
	
	
	

}
