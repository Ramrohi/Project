package com.Netinsight.Netinsight.DeviceInstance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	@Procedure(procedureName = "CreateDeviceWithShelves")
	void insertDeviceWithShelves(@Param("deviceName") String deviceName, @Param("managementIp") String managementIp,
			@Param("deviceModel") String deviceModel, @Param("location") String location,
			@Param("organisation") String organisation, @Param("customer") String customer,
			@Param("rackPosition") String rackPosition, @Param("operationalState") String operationalState,
			@Param("administrativeState") String administrativeState, @Param("usageState") String usageState,
			@Param("serialNumber") String serialNumber, @Param("href") String href);

	Device findTopByOrderByIdDesc();

}
