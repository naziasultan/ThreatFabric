package com.example.threadfabric.domain.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "DETECTIONS")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@DiscriminatorValue("RESOLVED")
public class ResolvedDetection extends Detection {
    @Column(name="DETECTION_UID")
    @Basic
    private String detectionUniqueId;
}