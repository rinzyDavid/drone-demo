package com.dronemonitor.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dronemonitor.application.mapper.AuditMapper;
import com.dronemonitor.application.service.AuditService;
import com.dronemonitor.persistence.DroneAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.dronemonitor.application.dto.AuditDTO;
import com.dronemonitor.application.dto.AuditLogDTO;
import com.dronemonitor.application.model.DroneAudit;

public class AuditServiceImpl implements AuditService {
	
	
	
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
	@Scheduled(cron="${cron-expression}")
	@Override
	public void runAudit() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("cron started");
		
		AuditDTO auditDto =  restTemplate.getForObject("http://droneService/api/v1/drones/audit", AuditDTO.class);
		DroneAudit audit = mapper.dtoToAudit(auditDto);
		audit.setId(UUID.randomUUID().toString());
		System.out.println(auditDto);
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
