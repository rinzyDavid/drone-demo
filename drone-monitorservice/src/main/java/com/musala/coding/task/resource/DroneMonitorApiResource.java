package com.musala.coding.task.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musala.coding.task.application.dto.AuditLogDTO;
import com.musala.coding.task.application.service.AuditService;



@RestController
@RequestMapping(path = {"/api/v1"}, produces = APPLICATION_JSON_VALUE)
public class DroneMonitorApiResource {
	
	@Autowired
	private AuditService auditService;
	
	
	@GetMapping("/audits")
	public ResponseEntity<AuditLogDTO> getDroneAudit(){
		
		AuditLogDTO audit = auditService.fetchAudits();
		return ResponseEntity.ok(audit);
		
	}
	

}
