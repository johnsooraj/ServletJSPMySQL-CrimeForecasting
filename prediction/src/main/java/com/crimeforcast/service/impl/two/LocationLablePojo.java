package com.crimeforcast.service.impl.two;

public class LocationLablePojo {

	private String message;
	private String place;
	private String latitude;
	private String longitude;
	private String caseFullForm;
	private Character icon;

	public LocationLablePojo() {
		// TODO Auto-generated constructor stub
	}

	public String getCaseFullForm() {
		return caseFullForm;
	}

	public void setCaseFullForm(String caseFullForm) {
		this.caseFullForm = caseFullForm;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Character getIcon() {
		return icon;
	}

	public void setIcon(Character c) {
		this.icon = c;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "LocationLablePojo [message=" + message + ", place=" + place + ", latitude=" + latitude + ", longitude="
				+ longitude + ", caseFullForm=" + caseFullForm + ", icon=" + icon + "]";
	}

}