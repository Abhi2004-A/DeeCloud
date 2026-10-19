package com.deecloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deecloud.dto.CostRecordDto;
import com.deecloud.repository.CostRecordRepository;
import com.deecloud.request.CostRecordRequest;
import com.deecloud.response.APIResponse;
import com.deecloud.service.CostRecordService;

@RestController
@RequestMapping("/cost")
public class CostRecordController {
	
	@Autowired
	private CostRecordService crservice;
	
	@PostMapping("/createcostrecord")
	public ResponseEntity<?> createcost(CostRecordRequest request){
		CostRecordDto crdto = crservice.create(request); 
		return ResponseEntity.ok(new APIResponse<>("Cost Record Created!", crdto, HttpStatus.OK));
	}

}
