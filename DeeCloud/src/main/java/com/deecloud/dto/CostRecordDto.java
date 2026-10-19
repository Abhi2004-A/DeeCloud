package com.deecloud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostRecordDto {
	
	private Integer crId;
	
	private String provider;
	
	private String serviceName;
	
	private String resourceId;
	
	private BigDecimal costAmount;
	
	private String currency;
	
	private LocalDate usageDate;

}
