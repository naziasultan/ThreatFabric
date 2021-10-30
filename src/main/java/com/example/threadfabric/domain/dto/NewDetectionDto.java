package com.example.threadfabric.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewDetectionDto extends ResolvedDetectionDto{
    @NotNull
    private String nameOfApp;
    @NotNull
    private String typeOfApp;
}
