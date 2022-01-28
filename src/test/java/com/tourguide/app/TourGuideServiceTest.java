package com.tourguide.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.app.model.Attraction;
import com.tourguide.app.model.TripDeal;
import com.tourguide.app.model.VisitedLocation;
import com.tourguide.app.service.TourGuideService;

@SpringBootTest
public class TourGuideServiceTest {

	@Autowired
	private TourGuideService tourGuideService;
	
	@Before
	public void setUp() {
		tourGuideService = new TourGuideService();
	}

	@Test
	public void getCurrentLocationTest() {
		UUID uuid = UUID.randomUUID();
		VisitedLocation userCurrentLocation = tourGuideService.getCurrentLocation(uuid);
		assertThat(userCurrentLocation.getUserId()).isEqualByComparingTo(uuid);
		
	}
	
	@Test
	public void getAllCurrentLocationsTest() {
		List<VisitedLocation> lastVisitedLocations = tourGuideService.getAllCurrentLocations();
		for (VisitedLocation visitedLocation : lastVisitedLocations) {
			assertThat(visitedLocation.getLatitude()).isNotNull();
		}
	}
	
	
	@Test
	public void getTripDealsTest() {
		UUID uuid = UUID.randomUUID();
		String attractionName = "Disneyland";
		List<TripDeal> tripDeals = tourGuideService.getTripDeals(uuid, attractionName);
		for (TripDeal tripDeal : tripDeals) {
			assertThat(tripDeal.getAttractionName()).isEqualTo(attractionName);
		}
	}
	
	@Test
	public void getNearByAttractionsTest() {
		UUID uuid = UUID.randomUUID();
		tourGuideService.getCurrentLocation(uuid);
		List<Attraction> attractions = tourGuideService.getNearByAttractions(uuid);
		for (Attraction attraction : attractions) {
			assertThat(attraction.getReward()).isNotNull();
		}
	}
	
	
	
	
	
	
	
	
}
