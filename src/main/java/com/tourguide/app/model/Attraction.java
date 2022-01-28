package com.tourguide.app.model;

import java.util.UUID;

public class Attraction {

	private UUID id;
	private String attractionName;
	private String city;
	private String state;
	private double latitude;
	private double longitude;
	private double distance;
	private int reward;

	public Attraction() {
	}
	
	

	public Attraction(String attractionName, String city, String state, double latitude, double longitude) {
		super();
		this.attractionName = attractionName;
		this.city = city;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public Attraction(UUID id, String attractionName, String city, String state, double latitude, double longitude,
			double distance, int reward) {
		super();
		this.id = id;
		this.attractionName = attractionName;
		this.city = city;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
		this.reward = reward;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID attractionId) {
		this.id = attractionId;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}
    
}
