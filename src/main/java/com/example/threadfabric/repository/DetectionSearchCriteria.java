package com.example.threadfabric.repository;

import com.example.threadfabric.domain.model.DeviceType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
public class DetectionSearchCriteria {
    private Optional<String> deviceId;
    private Optional<String> deviceModel;
    private Optional<DeviceType> deviceType;
    private Optional<Date> fromDate;
    private Optional<Date> toDate;
}
