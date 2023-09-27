package com.Netinsight.Netinsight.Locationmanager;

public class CityDto {
    
    private Long id;
    private String cityName;
    private String stateName;  // Assuming we only need the state's name
    private String notes;

    // Default constructor
    public CityDto() {
    }

    // Constructor using all fields
    public CityDto(Long id, String cityName, String stateName, String notes) {
        this.id = id;
        this.cityName = cityName;
        this.stateName = stateName;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "CityDto [id=" + id + ", cityName=" + cityName + ", stateName=" + stateName + ", notes=" + notes + "]";
    }
}