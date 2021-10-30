package com.example.threadfabric.repository;

import java.util.Date;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import com.example.threadfabric.domain.model.Detection;
import com.example.threadfabric.domain.model.Detection_;
import com.example.threadfabric.domain.model.Device;
import com.example.threadfabric.domain.model.DeviceType;
import com.example.threadfabric.domain.model.Device_;

public class DetectionSpecifications {
    public static Specification<Detection> createDetectionSpecifications(Date from, Date to) {
        return (detection, cq, cb) -> cb.between(detection.get(Detection_.time), from, to);
    }
	/*
	 * public static Specification<Detection>
	 * createDetectionSpecificationsBasedOnDeviceId(String id) { return (root,
	 * query, builder) -> { Join<Detection, Device> join = root.join("device");
	 * return builder.equal(join.get(Device_.deviceUniqueId), id); }; }
	 */

	/*
	 * public static Specification<Detection>
	 * createDetectionSpecificationsBasedOnDeviceModel(String deviceModel) { return
	 * (root, query, builder) -> { Join<Detection, Device> join =
	 * root.join("device"); return builder.like(join.get(Device_.model),
	 * deviceModel); }; }
	 * 
	 * public static Specification<Detection>
	 * createDetectionSpecificationsBasedOnDeviceType(DeviceType deviceType) {
	 * return (root, query, builder) -> { Join<Detection, Device> join =
	 * root.join("device"); return builder.equal(join.get(Device_.type),
	 * deviceType); }; }
	 */
}
