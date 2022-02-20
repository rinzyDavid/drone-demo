package com.musala.coding.task.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.musala.coding.task.application.dto.AuditDTO;
import com.musala.coding.task.application.dto.AuditLogDTO;
import com.musala.coding.task.application.mapper.AuditMapper;
import com.musala.coding.task.application.model.DroneAudit;
import com.musala.coding.task.application.service.AuditService;
import com.musala.coding.task.persistence.DroneAuditRepository;

public class AuditServiceImpl implements AuditService{
	
	
	
	@Autowired
	private DroneAuditRepository auditRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("drone.service.url")
	private String droneServiceUrl;
	
	@Autowired private AuditMapper mapper;
	

	/**
	 * This function will perform the following actions
	 * 1. Make a call to the drone service to check drone battery status
	 * 2. Save the data for future analysis
	 */
	@Override
	public void runAudit() {
		// TODO Auto-generated method stub
		
		try {
		
		AuditDTO auditDto =  restTemplate.getForObject(droneServiceUrl, AuditDTO.class);
		DroneAudit audit = mapper.dtoToAudit(auditDto);
		audit.setId(UUID.randomUUID().toString());
		auditRepo.save(audit);
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public AuditLogDTO fetchAudits() {
		// TODO Auto-generated method stub
		AuditLogDTO log = new AuditLogDTO();
		List<AuditDTO> dtos = new ArrayList<>();
		List<DroneAudit> audits = auditRepo.findAll();
		audits.forEach(ad ->{
			dtos.add(mapper.auditToDTO(ad));
		});
		
		log.setLogs(dtos);
		log.setTotal(dtos.size());
		
		return log;
	}

}