package com.musala.coding.task.application.dto;

import java.util.List;

import lombok.Data;

public @Data class AuditLogDTO {

	private List<AuditDTO> logs;
	private int total;
}
