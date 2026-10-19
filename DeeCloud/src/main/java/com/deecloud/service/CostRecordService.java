package com.deecloud.service;

import java.util.List;

import com.deecloud.dto.CostRecordDto;
import com.deecloud.request.CostRecordRequest;

public interface CostRecordService {
	
	public CostRecordDto create(CostRecordRequest request);
	
	public List<CostRecordDto> getAll();
	
	public CostRecordDto getById(Integer crId);
	

}
