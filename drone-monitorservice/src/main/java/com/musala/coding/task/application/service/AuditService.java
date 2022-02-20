package com.musala.coding.task.application.service;

import com.musala.coding.task.application.dto.AuditLogDTO;

public interface AuditService {
	
	void runAudit();
	AuditLogDTO fetchAudits();
	
	

}
