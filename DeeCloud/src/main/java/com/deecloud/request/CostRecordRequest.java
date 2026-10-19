package com.deecloud.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostRecordRequest {
	
	@NotBlank(message = "Provider is required")
	private String provider;
	
	@NotBlank(message = "Service name is required")
	private String serviceName;
	
	@NotBlank(message = "Resource Id is required")
	private String resourceId;
	
	@NotNull(message = "Cost Amount is required")
	@DecimalMin(value = "0.00", message = "Cost Cannot be negative")
	@Digits(integer = 10, fraction = 2, message = "Cost can have at most 2 decimal places")
	private BigDecimal costAmount;
	
	@NotBlank(message = "Currency is required")
	@Pattern(regexp = "INR|USD", message = "Currency must be INR or USD")
	private String currency;
	
	@NotNull(message = "Usage Date is required")
	@PastOrPresent(message = "Usage date cannot be in the future")
	private LocalDate usageDate;

}
