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
public class State implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "stateName", unique = true, nullable = false)
	private String stateName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "countryName", referencedColumnName = "countryName")
	private Country country;
	@Column(columnDefinition = "varchar(50) default 'Country_To_State'")
	private String notes;

	public State() {
		super();
	}

	public State(Long id, String cityName, Country country, String notes) {
		super();
		this.id = id;
		this.stateName = cityName;
		this.country = country;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return stateName;
	}

	public void setCityName(String cityName) {
		this.stateName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", stateName=" + stateName + ", country=" + country + ", notes=" + notes + "]";
	}

}
