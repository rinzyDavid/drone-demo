package com.dronemonitor.application.service;

import com.dronemonitor.application.dto.AuditLogDTO;

public interface AuditService {
	
	void runAudit();
	AuditLogDTO fetchAudits();
	
	

}
