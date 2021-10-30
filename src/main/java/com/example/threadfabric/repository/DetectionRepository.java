package com.example.threadfabric.repository;

import com.example.threadfabric.domain.model.Detection;
import com.example.threadfabric.domain.model.Device;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetectionRepository <T extends Detection> extends JpaRepository<Detection, Long>, JpaSpecificationExecutor<Detection> {

}
