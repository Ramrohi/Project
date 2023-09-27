package com.Netinsight.Netinsight.DeviceInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceApi {
	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	private Logger logger = LoggerFactory.getLogger(DeviceApi.class);

	@PostMapping("/add1")
	public ResponseEntity<Device> addDevice(@RequestBody DeviceDto device) {
		try {
			deviceRepository.insertDeviceWithShelves(device.getName(), device.getManagementIp(),
					device.getDeviceModel(), // Get the string representation of deviceModel
					device.getLocation(), device.getOrganisation(), device.getCustomer(), device.getRackPosition(),
					device.getOperationalState(), device.getAdministrativeState(), device.getUsageState(),
					device.getSerialNumber(), device.getHref());
			Device insertdevice = deviceRepository.findTopByOrderByIdDesc();
			return ResponseEntity.ok(insertdevice);
		} catch (Exception e) {
			logger.error("Error while adding Device", e);
		}

		return null;
	}
}
