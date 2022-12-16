package com.foodexpress.model;

import lombok.Data;

@Data
public class Address {
	private String buildingName;
	private String streetNo;
	private String area;
	private String city;
	private String State;
	private String pincode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String buildingName, String streetNo, String area, String city, String state, String pincode) {
		super();
		this.buildingName = buildingName;
		this.streetNo = streetNo;
		this.area = area;
		this.city = city;
		State = state;
		this.pincode = pincode;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
