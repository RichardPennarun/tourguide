package com.tourguide.app.model;

import java.util.Date;
import java.util.Currency;
import java.util.UUID;

import javax.money.CurrencyUnit;

public class TripRequest {
	
	private UUID id;
	private Date requestDate;
	private UUID userId;
	private int userRewardPoints;
	private UUID attractionId;
	private String attractionName;
	private int attractionRewardpoints;
	private Currency currency;
	private int nightsStay;
	private int numberOfAdults;
	private int numberOfChildren;
	
    public TripRequest() {
		super();
	}

	public TripRequest(UUID id, Date requestDate2, UUID userId, int userRewardPoints, UUID attractionId, 
			String attractionName, int attractionRewardpoints, Currency currency, int nightsStay, int numberOfAdults,
			int numberOfChildren) {
		super();
		this.id = id;
		this.requestDate = requestDate2;
		this.userId = userId;
		this.userRewardPoints = userRewardPoints;
		this.attractionId = attractionId;
		this.attractionName = attractionName;
		this.attractionRewardpoints = attractionRewardpoints;
		this.currency = currency;
		this.nightsStay = nightsStay;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public int getUserRewardPoints() {
		return userRewardPoints;
	}
	public void setUserRewardPoints(int userRewardPoints) {
		this.userRewardPoints = userRewardPoints;
	}
	public UUID getAttractionId() {
		return attractionId;
	}
	public void setAttractionId(UUID attractionId) {
		this.attractionId = attractionId;
	}
	public String getAttractionName() {
		return attractionName;
	}
	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}
	public int getAttractionRewardpoints() {
		return attractionRewardpoints;
	}
	public void setAttractionRewardpoints(int attractionRewardpoints) {
		this.attractionRewardpoints = attractionRewardpoints;
	}
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getNightsStay() {
		return nightsStay;
	}
	public void setNightsStay(int nightsStay) {
		this.nightsStay = nightsStay;
	}
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}


}
