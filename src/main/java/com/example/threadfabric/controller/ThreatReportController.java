package com.example.threadfabric.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.threadfabric.domain.dto.DetectionResponseDto;
import com.example.threadfabric.domain.dto.DetectionSearchDtoRequest;
import com.example.threadfabric.domain.dto.DeviceDto;
import com.example.threadfabric.domain.dto.NewDetectionDto;
import com.example.threadfabric.domain.dto.NoDetectionDto;
import com.example.threadfabric.domain.dto.ResolvedDetectionDto;
import com.example.threadfabric.domain.model.Detection;
import com.example.threadfabric.domain.model.DeviceType;
import com.example.threadfabric.domain.model.NewDetection;
import com.example.threadfabric.domain.model.ResolvedDetection;
import com.example.threadfabric.exception.BusinessException;
import com.example.threadfabric.exception.BusinessExceptionMessages;
import com.example.threadfabric.service.DetectionService;

@RestController
@RequestMapping("resources/detections")
public class ThreatReportController {

	@Autowired
	private DetectionService service;

	@PostMapping("resources/devices")
	public ResponseEntity<DeviceDto> saveNewDevice(@Valid @RequestBody DeviceDto deviceDto) {
		return new ResponseEntity<>(service.saveDevice(deviceDto), HttpStatus.OK);
	}

	@PostMapping("/noDetection")
	public ResponseEntity<NoDetectionDto> saveDetection(@Valid @RequestBody NoDetectionDto dto) {
		return new ResponseEntity(service.saveNoDetection(dto), HttpStatus.OK);
	}

	@PostMapping("/resolved")
	public ResponseEntity<ResolvedDetectionDto> saveDetection(@Valid @RequestBody ResolvedDetectionDto dto) {
		return new ResponseEntity(service.saveResolvedDetection(dto), HttpStatus.OK);
	}

	@PostMapping("/newDetection")
	public ResponseEntity<NewDetectionDto> saveDetection(@Valid @RequestBody NewDetectionDto dto) {
		return new ResponseEntity(service.saveNewDetection(dto), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<DetectionResponseDto>> search(@RequestParam(required = false) String deviceId,

			@RequestParam(required = false) String deviceModel,

			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @NotNull Date from,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to,

			@RequestParam(required = false) DeviceType type) {
		if (from == null || to == null) {
			throw new BusinessException(BusinessExceptionMessages.INVALID_INPUT);
		}
		DetectionSearchDtoRequest searchCriteria = DetectionSearchDtoRequest.builder().deviceId(deviceId)
				.deviceModel(deviceModel).deviceType(type).toDate(to).fromDate(from).build();
		List<Detection> detections = service.search(searchCriteria);
		List<DetectionResponseDto> list = convertToDto(detections);
		return ResponseEntity.ok(list);
	}

	private List<DetectionResponseDto> convertToDto(List<Detection> detections) {
		List<DetectionResponseDto> list = new ArrayList<>();
		detections.forEach(d -> {
			DetectionResponseDto dto = DetectionResponseDto.builder().deviceModel(d.getDevice().getModel())
					.deviceType(d.getDevice().getType()).deviceOsVersion(d.getDevice().getOsVersion()).time(d.getTime())
					.deviceId(d.getDevice().getDeviceUniqueId()).type("NO").build();
			if (d instanceof NewDetection) {
				dto.setType("NEW");
				dto.setTypeOfApp(((NewDetection) d).getTypeOfApp());
				dto.setNameOfApp(((NewDetection) d).getNameOfApp());
				dto.setDetectionId(((NewDetection) d).getDetectionUniqueId());
			} else if (d instanceof ResolvedDetection) {
				dto.setType("RESOLVED");
				dto.setDetectionId(((ResolvedDetection) d).getDetectionUniqueId());
			}
			list.add(dto);
		});
		return list;
	}

}
