package com.Netinsight.Netinsight.DeviceInstance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shelves")
public class Shelf implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "shelfPosition")
	private int shelfPosition;

	@Column(name = "operationalState", columnDefinition = "varchar(50) default 'Undefined'")
	private String operationalState;

	@Column(name = "administrativeState", columnDefinition = "varchar(50) default 'Undefined'")
	private String administrativeState;

	@Column(name = "href", columnDefinition = "varchar(50) default 'Undefined'")
	private String href;

	@Column(name = "usageState", columnDefinition = "varchar(50) default 'Undefined'")
	private String usageState;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_name", referencedColumnName = "name")
	private Device device;

	public Shelf(Long id, String name, int shelfPosition, String operationalState, String administrativeState,
			String href, String usageState, Device device) {
		super();
		this.id = id;
		this.name = name;
		this.shelfPosition = shelfPosition;
		this.operationalState = operationalState;
		this.administrativeState = administrativeState;
		this.href = href;
		this.usageState = usageState;
		this.device = device;
	}

	public Shelf() {
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

	public int getShelfPosition() {
		return shelfPosition;
	}

	public void setShelfPosition(int shelfPosition) {
		this.shelfPosition = shelfPosition;
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

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getUsageState() {
		return usageState;
	}

	public void setUsageState(String usageState) {
		this.usageState = usageState;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "Shelf [id=" + id + ", name=" + name + ", shelfPosition=" + shelfPosition + ", operationalState="
				+ operationalState + ", administrativeState=" + administrativeState + ", href=" + href + ", usageState="
				+ usageState + ", device=" + device + "]";
	}

	// getters, setters, constructors, etc.
}
