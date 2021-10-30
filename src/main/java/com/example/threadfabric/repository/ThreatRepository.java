package com.example.threadfabric.repository;

import com.example.threadfabric.domain.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreatRepository extends JpaRepository<Device, Long> {
    Device findByDeviceUniqueId(String uid);
}
