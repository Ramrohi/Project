package com.Netinsight.Netinsight.Locationmanager;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Building implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "buildingName", unique = true, nullable = false)
	private String buildingName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityName", referencedColumnName = "cityName")
	private City city;
	@Column(columnDefinition = "varchar(50) default 'City_To_Building'")
	private String notes;

	public Building() {
		super();
	}

	public Building(Long id, String buildingName, City city, String notes) {
		super();
		this.id = id;
		this.buildingName = buildingName;
		this.city = city;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", buildingName=" + buildingName + ", city=" + city + ", notes=" + notes + "]";
	}

}
