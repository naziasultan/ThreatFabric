package com.example.threadfabric.domain.dto;

import com.example.threadfabric.domain.model.DeviceType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DetectionResponseDto {
    private String nameOfApp;
    private String typeOfApp;
    private String detectionId;
    private String deviceId;
    private Date time;
    private String type;
    private String deviceModel;
    private String deviceOsVersion;
    private DeviceType deviceType;
}
