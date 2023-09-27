package com.Netinsight.Netinsight.DeviceInstance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class Device implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false) // making the name unique
	private String name;
	@Column(name = "deviceModel")
	private String deviceModel;
	@Column(name = "numberOfShelves")
	private Integer numberOfShelves;
	private String location;
	private String organisation;
	private String customer;
	private String managementIp;
	private String rackPosition;
	private String operationalState;
	private String administrativeState;
	private String usageState;
	private String serialNumber;
	private String href;

	public Device() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getManagementIp() {
		return managementIp;
	}

	public void setManagementIp(String managementIp) {
		this.managementIp = managementIp;
	}

	public String getRackPosition() {
		return rackPosition;
	}

	public void setRackPosition(String rackPosition) {
		this.rackPosition = rackPosition;
	}

	public String getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(String operationalState) {
		this.operationalState = operationalState;
	}

	public String getAdministrativeState() {
		return administrativeState;
	}

	public void setAdministrativeState(String administrativeState) {
		this.administrativeState = administrativeState;
	}

	public String getUsageState() {
		return usageState;
	}

	public void setUsageState(String usageState) {
		this.usageState = usageState;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Device(Long id, String name, String deviceModel, Integer numberOfShelves, String location,
			String organisation, String customer, String managementIp, String rackPosition, String operationalState,
			String administrativeState, String usageState, String serialNumber, String href) {
		super();
		this.id = id;
		this.name = name;
		this.deviceModel = deviceModel;
		this.numberOfShelves = numberOfShelves;
		this.location = location;
		this.organisation = organisation;
		this.customer = customer;
		this.managementIp = managementIp;
		this.rackPosition = rackPosition;
		this.operationalState = operationalState;
		this.administrativeState = administrativeState;
		this.usageState = usageState;
		this.serialNumber = serialNumber;
		this.href = href;
	}

}
