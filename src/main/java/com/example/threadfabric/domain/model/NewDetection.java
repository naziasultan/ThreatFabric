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
@DiscriminatorValue("NEW")
public class NewDetection extends ResolvedDetection {
    @Column(name="NAME_OF_APP")
    private String nameOfApp;
    @Basic
    @Column(name = "TYPE_OF_APP", unique = true)
    private String typeOfApp;
}
