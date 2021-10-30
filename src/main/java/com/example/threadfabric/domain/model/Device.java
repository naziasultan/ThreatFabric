package com.example.threadfabric.domain.model;


import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "DEVICES")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="DEVICE_UID", unique = true)
    @Basic
    private String deviceUniqueId;
    @Column(name="DEVICE_TYPE")
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    @Basic
    @Column(name = "DEVICE_MODEL")
    private String model;
    @Basic
    @Column(name = "OS_VERSION")
    private String osVersion;

    @OneToMany(mappedBy = "device")
    private List<Detection> detections;
}
