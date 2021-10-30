package com.example.threadfabric.domain.dto;

import com.example.threadfabric.domain.model.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetectionSearchDtoRequest {
    private String deviceId;
    private String deviceModel;
    private DeviceType deviceType;
    private Date fromDate;
    private Date toDate;
}
