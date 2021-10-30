package com.example.threadfabric.service;

import com.example.threadfabric.domain.dto.*;
import com.example.threadfabric.domain.model.Detection;
import com.example.threadfabric.repository.DetectionSearchCriteria;

import java.util.List;

import javax.validation.Valid;


public interface DetectionService {
    DeviceDto saveDevice(DeviceDto deviceDto);
    NewDetectionDto saveNewDetection(@Valid NewDetectionDto request);
    NoDetectionDto saveNoDetection(NoDetectionDto dto);
    ResolvedDetectionDto saveResolvedDetection(ResolvedDetectionDto dto);
    List<Detection> search(DetectionSearchDtoRequest dsc);

}
