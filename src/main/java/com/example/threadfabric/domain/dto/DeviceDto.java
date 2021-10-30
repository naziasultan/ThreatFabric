package com.example.threadfabric.domain.dto;

import javax.validation.constraints.NotNull;

import com.example.threadfabric.domain.model.DeviceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {
    @NotNull
    private String deviceUniqueId;
    @NotNull
    private DeviceType type;
    @NotNull
    private String model;
    @NotNull
    private String osVersion;
}
