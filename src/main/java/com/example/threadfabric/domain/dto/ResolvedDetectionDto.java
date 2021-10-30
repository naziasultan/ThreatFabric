package com.example.threadfabric.domain.dto;

import javax.validation.constraints.NotNull;

//import com.example.threadfabric.domain.validation.DetectionDeviceConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class ResolvedDetectionDto extends NoDetectionDto {
    @NotNull
    private String detectionId;
}
