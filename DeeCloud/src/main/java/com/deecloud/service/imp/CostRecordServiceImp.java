package com.deecloud.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.deecloud.dto.CostRecordDto;
import com.deecloud.entity.CostRecord;
import com.deecloud.exceptions.AppException;
import com.deecloud.repository.CostRecordRepository;
import com.deecloud.request.CostRecordRequest;
import com.deecloud.service.CostRecordService;

@Service
public class CostRecordServiceImp implements CostRecordService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CostRecordRepository crrepo;
	
	@Override
	public CostRecordDto create(CostRecordRequest request) {
		CostRecord record = new CostRecord();
		record=mapper.map(request, CostRecord.class);
		record=crrepo.save(record);
		return mapper.map(record, CostRecordDto.class);
	}

	@Override
	public List<CostRecordDto> getAll() {
		return crrepo.findAll().stream().map((cr)->mapper.map(cr, CostRecordDto.class)).collect(Collectors.toList());
	}

	@Override
	public CostRecordDto getById(Integer crId) {
		CostRecord record = crrepo.findById(crId).orElseThrow(()-> new AppException("Cost Record Not Found! "+ crId , HttpStatus.NOT_FOUND));
		return mapper.map(record, CostRecordDto.class);
	}

}
