package com.example.threadfabric.domain.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

//import com.example.threadfabric.domain.validation.DeviceNotNullConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NotNull
public class NoDetectionDto {
    @NotNull
    private String deviceId;
    @NotNull
    private Date time;
}
