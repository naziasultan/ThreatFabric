package com.example.threadfabric.service;

import com.example.threadfabric.domain.dto.*;
import com.example.threadfabric.domain.model.Detection;
import com.example.threadfabric.domain.model.Device;
import com.example.threadfabric.domain.model.NewDetection;
import com.example.threadfabric.domain.model.ResolvedDetection;
import com.example.threadfabric.exception.BusinessException;
import com.example.threadfabric.exception.BusinessExceptionMessages;
import com.example.threadfabric.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class DetectionServiceImpl implements DetectionService {
	@Autowired
	private ThreatRepository threatRepository;
	@Autowired
	private DetectionRepository detectionRepository;
	

	@Override
	@Transactional
	public DeviceDto saveDevice(DeviceDto deviceDto) {

		Device old = threatRepository.findByDeviceUniqueId(deviceDto.getDeviceUniqueId());
		if (old != null) {
			throw new BusinessException(BusinessExceptionMessages.DUPLICATE_ID);
		}

		Device device = new Device();
		device.setType(deviceDto.getType());
		device.setDeviceUniqueId(deviceDto.getDeviceUniqueId());
		device.setModel(deviceDto.getModel());
		device.setType(deviceDto.getType());
		device.setOsVersion(deviceDto.getOsVersion());
		threatRepository.save(device);
		return deviceDto;
	}

	@Override
	@Transactional
	public NewDetectionDto saveNewDetection(NewDetectionDto dto) {
		Device device = threatRepository.findByDeviceUniqueId(dto.getDeviceId());
		NewDetection detection = new NewDetection(dto.getNameOfApp(), dto.getTypeOfApp());
		detection.setDetectionUniqueId(dto.getDetectionId());
		detection.setTime(dto.getTime());
		detection.setDevice(device);
		device.getDetections().add(detection);
		detectionRepository.save(detection);
		return dto;
	}

	@Override
	@Transactional
	public ResolvedDetectionDto saveResolvedDetection(ResolvedDetectionDto dto) {
		Device device = threatRepository.findByDeviceUniqueId(dto.getDeviceId());
		ResolvedDetection detection = new ResolvedDetection(dto.getDetectionId());
		detection.setTime(dto.getTime());
		detection.setDevice(device);
		device.getDetections().add(detection);
		detectionRepository.save(detection);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detection> search(DetectionSearchDtoRequest dto) {
		Specification<Detection> dateSpecifications = DetectionSpecifications
				.createDetectionSpecifications(dto.getFromDate(), dto.getToDate());	
		Specification<Detection> where = where(dateSpecifications);	

		return detectionRepository.findAll(where);
	}

	@Override
	@Transactional
	public NoDetectionDto saveNoDetection(NoDetectionDto dto) {
		Device device = threatRepository.findByDeviceUniqueId(dto.getDeviceId());
		Detection detection = Detection.builder().device(device).time(dto.getTime()).build();
		device.getDetections().add(detection);
		detectionRepository.save(detection);
		return dto;
	}

}
