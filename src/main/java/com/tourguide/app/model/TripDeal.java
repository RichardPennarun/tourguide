package com.tourguide.app.model;

import java.util.Date;
import java.util.Currency;
import java.util.UUID;

import javax.money.CurrencyUnit;

import org.javamoney.moneta.Money;

public class TripDeal {
	
	public UUID id;
	public UUID userId;
	public UUID attractionId;
	public String attractionName;
    public String providerName;
    public double price;
	public Currency currency;
    public int nightsStay;
    public int numberOfAdults;
    public int numberOfChildren;
    public Date tripDealDate;
	
    public TripDeal() {
    	super();
    }

	public TripDeal(UUID id, UUID userId, UUID attractionId, String attractionName, String providerName,
			double price, Currency currency, int nightsStay, int numberOfAdults, int numberOfChildren,
			Date tripDealDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.attractionId = attractionId;
		this.attractionName = attractionName;
		this.providerName = providerName;
		this.currency = currency;
		this.price = price;
		this.nightsStay = nightsStay;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.tripDealDate = tripDealDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public Date getTripDealDate() {
		return tripDealDate;
	}

	public void setTripDealDate(Date tripDealDate) {
		this.tripDealDate = tripDealDate;
	}

	
    

}
