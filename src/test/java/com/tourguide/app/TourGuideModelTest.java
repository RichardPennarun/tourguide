package com.tourguide.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Currency;
import java.util.Date;
import java.util.UUID;

import org.javamoney.moneta.Money;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.app.model.Attraction;
import com.tourguide.app.model.Reward;
import com.tourguide.app.model.TripDeal;
import com.tourguide.app.model.TripRequest;
import com.tourguide.app.model.UserPreferences;
import com.tourguide.app.model.VisitedLocation;


@SpringBootTest
public class TourGuideModelTest {


	@Test
	public void getVisitedLocationTest() {
		VisitedLocation vl = new VisitedLocation();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		vl.setUserId(uuid);
		vl.setLatitude(-125.808708);
		vl.setLongitude(5.64892);
		vl.setTimeVisited(timeVisited);
		assertThat(vl.getUserId()).isEqualTo(uuid);
		assertThat(vl.getLatitude()).isEqualTo(-125.808708);
		assertThat(vl.getLongitude()).isEqualTo(5.64892);
		assertThat(vl.getTimeVisited()).isEqualTo(timeVisited);
	}
	
	@Test
	public void setVisitedLocationTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		VisitedLocation visitedLocation = new VisitedLocation(id, uuid, -125.808708, 5.64892, timeVisited);
		assertThat(visitedLocation.getId()).isEqualTo(id);
		assertThat(visitedLocation.getUserId()).isEqualTo(uuid);
		assertThat(visitedLocation.getLatitude()).isEqualTo(-125.808708);
		assertThat(visitedLocation.getLongitude()).isEqualTo(5.64892);
		assertThat(visitedLocation.getTimeVisited()).isEqualTo(timeVisited);
	}
	
	@Test
	public void getTripRequestTest() {
		TripRequest tr = new TripRequest();
		final Date requestDate = new Date();
		final UUID uuid = UUID.randomUUID();
		final int userRewardPoints = 75;
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final int attractionRewardpoints= 15;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		tr.setRequestDate(requestDate);
		tr.setUserId(uuid);
		tr.setUserRewardPoints(userRewardPoints);
		tr.setAttractionId(uuid2);
		tr.setAttractionName(attractionName);
		tr.setAttractionRewardpoints(attractionRewardpoints);
		tr.setCurrency(currency);
		tr.setNightsStay(4);
		tr.setNumberOfAdults(2);
		tr.setNumberOfChildren(2);
		assertThat(tr.getRequestDate()).isEqualTo(requestDate);
		assertThat(tr.getUserId()).isEqualTo(uuid);
		assertThat(tr.getUserRewardPoints()).isEqualTo(userRewardPoints);
		assertThat(tr.getAttractionId()).isEqualTo(uuid2);
		assertThat(tr.getAttractionName()).isEqualTo(attractionName);
		assertThat(tr.getAttractionRewardpoints()).isEqualTo(attractionRewardpoints);
		assertThat(tr.getCurrency()).isEqualTo(currency);
		assertThat(tr.getNightsStay()).isEqualTo(nightsStay);
		assertThat(tr.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(tr.getNumberOfChildren()).isEqualTo(numberOfChildren);
	}
	
	@Test
	public void setTripRequestTest() {
		final UUID id = UUID.randomUUID();
		final Date requestDate = new Date();
		final UUID uuid = UUID.randomUUID();
		final int userRewardPoints = 25;
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final int attractionRewardpoints = 15;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		
		TripRequest tripRequest = new TripRequest(id, requestDate, uuid, userRewardPoints, uuid2, attractionName, 
				attractionRewardpoints, currency, nightsStay, numberOfAdults, numberOfChildren);
		assertThat(tripRequest.getId()).isEqualTo(id);
		assertThat(tripRequest.getRequestDate()).isEqualTo(requestDate);
		assertThat(tripRequest.getUserId()).isEqualTo(uuid);
		assertThat(tripRequest.getUserRewardPoints()).isEqualTo(userRewardPoints);
		assertThat(tripRequest.getAttractionId()).isEqualTo(uuid2);
		assertThat(tripRequest.getAttractionName()).isEqualTo(attractionName);
		assertThat(tripRequest.getAttractionRewardpoints()).isEqualTo(attractionRewardpoints);
		assertThat(tripRequest.getCurrency()).isEqualTo(currency);
		assertThat(tripRequest.getNightsStay()).isEqualTo(nightsStay);
		assertThat(tripRequest.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(tripRequest.getNumberOfChildren()).isEqualTo(numberOfChildren);
	}
	
	@Test
	public void getTripDealTest() {
		TripDeal td = new TripDeal();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final String providerName = "Blue Sky";
		final double price= 500;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		final Date tripDealDate = new Date();
		td.setUserId(uuid);
		td.setAttractionId(uuid2);
		td.setAttractionName(attractionName);
		td.setProviderName(providerName);
		td.setPrice(price);
		td.setCurrency(currency);
		td.setNightsStay(4);
		td.setNumberOfAdults(2);
		td.setNumberOfChildren(2);
		td.setTripDealDate(tripDealDate);
		assertThat(td.getUserId()).isEqualTo(uuid);
		assertThat(td.getAttractionId()).isEqualTo(uuid2);
		assertThat(td.getAttractionName()).isEqualTo(attractionName);
		assertThat(td.getProviderName()).isEqualTo(providerName);
		assertThat(td.getPrice()).isEqualTo(price);
		assertThat(td.getCurrency()).isEqualTo(currency);
		assertThat(td.getNightsStay()).isEqualTo(nightsStay);
		assertThat(td.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(td.getNumberOfChildren()).isEqualTo(numberOfChildren);
		assertThat(td.getTripDealDate()).isEqualTo(tripDealDate);
	}
	
	@Test
	public void setTripDealTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final String providerName = "Blue Sky";
		final double price= 500;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		final Date tripDealDate = new Date();
		
		TripDeal tripDeal = new TripDeal(id, uuid, uuid2, attractionName, providerName, 
				price, currency, nightsStay, numberOfAdults, numberOfChildren, tripDealDate);
		assertThat(tripDeal.getId()).isEqualTo(id);
		assertThat(tripDeal.getUserId()).isEqualTo(uuid);
		assertThat(tripDeal.getAttractionId()).isEqualTo(uuid2);
		assertThat(tripDeal.getAttractionName()).isEqualTo(attractionName);
		assertThat(tripDeal.getProviderName()).isEqualTo(providerName);
		assertThat(tripDeal.getPrice()).isEqualTo(price);
		assertThat(tripDeal.getCurrency()).isEqualTo(currency);
		assertThat(tripDeal.getNightsStay()).isEqualTo(nightsStay);
		assertThat(tripDeal.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(tripDeal.getNumberOfChildren()).isEqualTo(numberOfChildren);
		assertThat(tripDeal.getTripDealDate()).isEqualTo(tripDealDate);
	}
	

	@Test
	public void getUserPreferencesTest() {
		UserPreferences up = new UserPreferences();
		final UUID uuid = UUID.randomUUID();
		up.setUserId(uuid);
		up.setCurrency(null);
		up.setAttractionProximity(550);
		up.setLowerPricePoint(null);
		up.setHighPricePoint(null);
		up.setNightsStay(4);
		up.setNumberOfAdults(2);
		up.setNumberOfChildren(2);
		assertThat(up.getUserId()).isEqualTo(uuid);
		assertThat(up.getCurrency()).isEqualTo(null);
		assertThat(up.getAttractionProximity()).isEqualTo(550);
		assertThat(up.getLowerPricePoint()).isEqualTo(null);
		assertThat(up.getHighPricePoint()).isEqualTo(null);
		assertThat(up.getNightsStay()).isEqualTo(4);
		assertThat(up.getNumberOfAdults()).isEqualTo(2);
		assertThat(up.getNumberOfChildren()).isEqualTo(2);
	}
	
	@Test
	public void setUserPreferencesTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final Currency currency = null;
		final int attractionProximity = 1500;
		final Money lowerPricePoint = null;
		final Money highPricePoint = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		
		UserPreferences userPreferences = new UserPreferences(id, uuid, currency, attractionProximity, lowerPricePoint,
				highPricePoint, nightsStay, numberOfAdults, numberOfChildren);
		assertThat(userPreferences.getId()).isEqualTo(id);
		assertThat(userPreferences.getUserId()).isEqualTo(uuid);
		assertThat(userPreferences.getCurrency()).isEqualTo(currency);
		assertThat(userPreferences.getAttractionProximity()).isEqualTo(attractionProximity);
		assertThat(userPreferences.getLowerPricePoint()).isEqualTo(lowerPricePoint);
		assertThat(userPreferences.getHighPricePoint()).isEqualTo(highPricePoint);
		assertThat(userPreferences.getNightsStay()).isEqualTo(nightsStay);
		assertThat(userPreferences.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(userPreferences.getNumberOfChildren()).isEqualTo(numberOfChildren);
	}


	@Test
	public void getRewardTest() {
		Reward r = new Reward();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final int rewardPoints = 15;
		final Date timeVisited = new Date();
		r.setUserId(uuid);
		r.setAttractionId(uuid2);
		r.setRewardPoints(rewardPoints);
		r.setTimeVisited(timeVisited);
		assertThat(r.getUserId()).isEqualTo(uuid);
		assertThat(r.getAttractionId()).isEqualTo(uuid2);
		assertThat(r.getRewardPoints()).isEqualTo(rewardPoints);
		assertThat(r.getTimeVisited()).isEqualTo(timeVisited);
	}
	
	@Test
	public void setRewardTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final int rewardPoints = 15;
		final Date timeVisited = new Date();
		Reward reward = new Reward(id, uuid, uuid2, rewardPoints, timeVisited);
		assertThat(reward.getId()).isEqualTo(id);
		assertThat(reward.getUserId()).isEqualTo(uuid);
		assertThat(reward.getAttractionId()).isEqualTo(uuid2);
		assertThat(reward.getRewardPoints()).isEqualTo(rewardPoints);
		assertThat(reward.getTimeVisited()).isEqualTo(timeVisited);
	}


	@Test
	public void getAttractionTest() {
		Attraction a = new Attraction();
		final UUID id = UUID.randomUUID();
		
		a.setId(id);
		a.setAttractionName("Disneyland");
		a.setCity("Orlando");
		a.setState("Florida");
		a.setLatitude(-125.808708);
		a.setLongitude(5.64892);
		a.setDistance(550);
		a.setReward(15);
		assertThat(a.getId()).isEqualTo(id);
		assertThat(a.getAttractionName()).isEqualTo("Disneyland");
		assertThat(a.getCity()).isEqualTo("Orlando");
		assertThat(a.getState()).isEqualTo("Florida");
		assertThat(a.getLatitude()).isEqualTo(-125.808708);
		assertThat(a.getLongitude()).isEqualTo(5.64892);
		assertThat(a.getDistance()).isEqualTo(550);
		assertThat(a.getReward()).isEqualTo(15);
	}
	
	@Test
	public void setAttractionTest() {
		final UUID id = UUID.randomUUID();
		Attraction attraction = new Attraction(id, "Disneyland", "Orlando", "Florida", -125.808708, 5.64892, 550, 15);
		assertThat(attraction.getId()).isEqualTo(id);
		assertThat(attraction.getAttractionName()).isEqualTo("Disneyland");
		assertThat(attraction.getCity()).isEqualTo("Orlando");
		assertThat(attraction.getState()).isEqualTo("Florida");
		assertThat(attraction.getLatitude()).isEqualTo(-125.808708);
		assertThat(attraction.getLongitude()).isEqualTo(5.64892);
		assertThat(attraction.getDistance()).isEqualTo(550);
		assertThat(attraction.getReward()).isEqualTo(15);
	}

	
	
	
	
}
