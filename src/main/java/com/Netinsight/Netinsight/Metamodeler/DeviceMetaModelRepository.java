package com.Netinsight.Netinsight.Metamodeler;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMetaModelRepository extends JpaRepository<DeviceMetaModel, Long> {

	@Procedure(procedureName = "InsertDeviceMetaModelAndCards")
	void insertDeviceMetaModelAndCards(@Param("p_deviceModel") String p_deviceModel,
			@Param("p_partNumber") String p_partNumber, @Param("p_vendor") String p_vendor,
			@Param("p_height") Float p_height, @Param("p_depth") Float p_depth, @Param("p_width") Float p_width,
			@Param("p_shelvesContained") Integer p_shelvesContained,
			@Param("p_numOfRackPositionOccupied") Integer p_numOfRackPositionOccupied,
			@Param("p_allowedCardListString") String p_allowedCardListString);

	DeviceMetaModel findTopByOrderByDeviceModelDesc();// return last insertion Statement

	@Query(value = "select * from device_meta_model", nativeQuery = true)
	public ArrayList<DeviceMetaModel> getFreeIccid();

	@Query(value = "select * from device_meta_model where device_model = :deviceModel", nativeQuery = true)
	public DeviceMetaModel findByDeviceModel(@Param("deviceModel") String deviceModel);

	// @Query("SELECT d FROM DeviceMetaModel d WHERE d.deviceModel =
	// :deviceModel")(JPQL Quary must match with Java Attribute values only)
	// public DeviceMetaModel findByDeviceModel(@Param("deviceModel") String
	// deviceModel);
	@Query(value = "SELECT * FROM device_meta_model WHERE vendor = :vendor", nativeQuery = true)
	ArrayList<DeviceMetaModel> findByVendor(@Param("vendor") String vendorValue);

	@Procedure(procedureName = "UpdateDeviceMetaModelAndCards")
	void updateDeviceMetaModelAndCards(@Param("p_deviceModel") String p_deviceModel,
			@Param("p_partNumber") String p_partNumber, @Param("p_vendor") String p_vendor,
			@Param("p_height") Float p_height, @Param("p_depth") Float p_depth, @Param("p_width") Float p_width,
			@Param("p_numOfRackPositionOccupied") Integer p_numOfRackPositionOccupied,
			@Param("p_allowedCardListString") String p_allowedCardListString);

	@Modifying
	@Transactional
	@Query("DELETE FROM DeviceMetaModel d WHERE d.deviceModel = :model")
	void deleteByDeviceModel(@Param("model") String model);

}
