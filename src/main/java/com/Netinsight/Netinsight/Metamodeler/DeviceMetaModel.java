package com.Netinsight.Netinsight.Metamodeler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Netinsight.Netinsight.DeviceInstance.Device;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device_meta_model")
public class DeviceMetaModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "deviceModel", unique = true, nullable = false)
	private String deviceModel;

	@Column(name = "partNumber")
	private String partNumber;

	@Column(name = "vendor")
	private String vendor;

	@Column(name = "height")
	private float height;

	@Column(name = "depth")
	private float depth;

	@Column(name = "width")
	private float width;

	@Column(name = "shelvesContained", updatable = false)
	private int shelvesContained;

	@Column(name = "numOfRackPositionOccupied")
	private int numOfRackPositionOccupied;

	@OneToMany(mappedBy = "deviceModel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Device> devices = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "device_meta_model_allowed_card_list", joinColumns = {
			@JoinColumn(name = "deviceModel", referencedColumnName = "deviceModel") })
	@Column(name = "cardName")
	private List<String> allowedCardList;

	public DeviceMetaModel() {
		super();
	}

	public DeviceMetaModel(Long id, String deviceModel, String partNumber, String vendor, float height, float depth,
			float width, int shelvesContained, int numOfRackPositionOccupied, List<String> allowedCardList) {
		super();
		this.id = id;
		this.deviceModel = deviceModel;
		this.partNumber = partNumber;
		this.vendor = vendor;
		this.height = height;
		this.depth = depth;
		this.width = width;
		this.shelvesContained = shelvesContained;
		this.numOfRackPositionOccupied = numOfRackPositionOccupied;
		this.allowedCardList = allowedCardList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public int getShelvesContained() {
		return shelvesContained;
	}

	public void setShelvesContained(int shelvesContained) {
		this.shelvesContained = shelvesContained;
	}

	public int getNumOfRackPositionOccupied() {
		return numOfRackPositionOccupied;
	}

	public void setNumOfRackPositionOccupied(int numOfRackPositionOccupied) {
		this.numOfRackPositionOccupied = numOfRackPositionOccupied;
	}

	public List<String> getAllowedCardList() {
		return allowedCardList;
	}

	public void setAllowedCardList(List<String> allowedCardList) {
		this.allowedCardList = allowedCardList;
	}

	@Override
	public String toString() {
		return "DeviceMetaModel [id=" + id + ", deviceModel=" + deviceModel + ", partNumber=" + partNumber + ", vendor="
				+ vendor + ", height=" + height + ", depth=" + depth + ", width=" + width + ", shelvesContained="
				+ shelvesContained + ", numOfRackPositionOccupied=" + numOfRackPositionOccupied + ", allowedCardList="
				+ allowedCardList + "]";
	}

}
