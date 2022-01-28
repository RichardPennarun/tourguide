package com.tourguide.app.model;

import java.util.Date;
import java.util.UUID;

public class VisitedLocation {
	
	private UUID id;
	private UUID userId;
	private double latitude;
	private double longitude;
	private Date timeVisited;

	public VisitedLocation() {
		
	}

	public VisitedLocation(UUID id, UUID userId, double latitude, double longitude, Date timeVisited) {
        this.id = id;
		this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeVisited = timeVisited;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID userId) {
		this.userId = userId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
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

	public Date getTimeVisited() {
		return timeVisited;
	}

	public void setTimeVisited(Date timeVisited) {
		this.timeVisited = timeVisited;
	}
    

}
