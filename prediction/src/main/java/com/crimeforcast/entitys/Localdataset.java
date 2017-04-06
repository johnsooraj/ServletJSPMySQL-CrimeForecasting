package com.crimeforcast.entitys;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "localdataset")
@NamedQuery(name = "Localdataset.findAll", query = "SELECT l FROM Localdataset l")
public class Localdataset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "any_suspect")
	private Boolean anySuspect;

	@Column(name = "any_vitness")
	private Boolean anyVitness;

	@Column(name = "`Crime time`")
	private String crime_time;

	@Column(name = "crime_date")
	private String crimeDate;

	private String district;

	private String latitude;

	@Column(name = "location_type")
	private String locationType;

	private String longitude;

	@Column(name = "nearest_police_station")
	private String nearestPoliceStation;

	private String place;

	private String state;

	@Column(name = "suspect_age")
	private int suspectAge;

	@Column(name = "suspect_gender")
	private String suspectGender;

	@Column(name = "`type_of _crime`")
	private String typeOf_Crime;

	@Column(name = "victim_age")
	private String victimAge;

	@Column(name = "victim_gender")
	private String victimGender;

	@Column(name = "vitness_age")
	private int vitnessAge;

	public Localdataset() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getAnySuspect() {
		return this.anySuspect;
	}

	public void setAnySuspect(Boolean anySuspect) {
		this.anySuspect = anySuspect;
	}

	public Boolean getAnyVitness() {
		return this.anyVitness;
	}

	public void setAnyVitness(Boolean anyVitness) {
		this.anyVitness = anyVitness;
	}

	public String getCrime_time() {
		return this.crime_time;
	}

	public void setCrime_time(String crime_time) {
		this.crime_time = crime_time;
	}

	public String getCrimeDate() {
		return this.crimeDate;
	}

	public void setCrimeDate(String crimeDate) {
		this.crimeDate = crimeDate;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLocationType() {
		return this.locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNearestPoliceStation() {
		return this.nearestPoliceStation;
	}

	public void setNearestPoliceStation(String nearestPoliceStation) {
		this.nearestPoliceStation = nearestPoliceStation;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSuspectAge() {
		return this.suspectAge;
	}

	public void setSuspectAge(int suspectAge) {
		this.suspectAge = suspectAge;
	}

	public String getSuspectGender() {
		return this.suspectGender;
	}

	public void setSuspectGender(String suspectGender) {
		this.suspectGender = suspectGender;
	}

	public String getTypeOf_Crime() {
		return this.typeOf_Crime;
	}

	public void setTypeOf_Crime(String typeOf_Crime) {
		this.typeOf_Crime = typeOf_Crime;
	}

	public String getVictimAge() {
		return this.victimAge;
	}

	public void setVictimAge(String victimAge) {
		this.victimAge = victimAge;
	}

	public String getVictimGender() {
		return this.victimGender;
	}

	public void setVictimGender(String victimGender) {
		this.victimGender = victimGender;
	}

	public int getVitnessAge() {
		return this.vitnessAge;
	}

	public void setVitnessAge(int vitnessAge) {
		this.vitnessAge = vitnessAge;
	}

	@Override
	public String toString() {
		return "Localdataset [id=" + id + ", anySuspect=" + anySuspect + ", anyVitness=" + anyVitness + ", crime_time="
				+ crime_time + ", crimeDate=" + crimeDate + ", district=" + district + ", latitude=" + latitude
				+ ", locationType=" + locationType + ", longitude=" + longitude + ", nearestPoliceStation="
				+ nearestPoliceStation + ", place=" + place + ", state=" + state + ", suspectAge=" + suspectAge
				+ ", suspectGender=" + suspectGender + ", typeOf_Crime=" + typeOf_Crime + ", victimAge=" + victimAge
				+ ", victimGender=" + victimGender + ", vitnessAge=" + vitnessAge + "]";
	}

}