package com.tourguide.app;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.app.model.Attraction;
import com.tourguide.app.model.TripDeal;
import com.tourguide.app.model.UserPreferences;
import com.tourguide.app.model.VisitedLocation;
import com.tourguide.app.service.TourGuideService;

@RestController
public class TourGuideController {

	
	@Autowired
	TourGuideService tourGuideService;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from TourGuide!";
    }
    
    /*
   	 * 
   	 * API TourGuideLocation
   	 * 
   	 */
    
    /*
	 * Read - Get current GPS location
	 * @param Id The user id
	 * @return An object VisitedLocation that has bean saved
	 */
	@RequestMapping("/getCurrentLocation/{userId}") 
	public VisitedLocation getCurrentLocation(@PathVariable("userId") final UUID userId) { 
		VisitedLocation visitedLocation = tourGuideService.getCurrentLocation(userId); 
		return visitedLocation; 
	}

	/*
	 * Read - Get last GPS location saved
	 * @param Id The user id
	 * @return An object VisitedLocation
	 */
	@RequestMapping("/getLastLocation/{userId}")
    public VisitedLocation getLastLocations(@PathVariable("userId") final UUID userId) {
    	VisitedLocation lastVisitedLocation = tourGuideService.getLastLocation(userId);
    	return lastVisitedLocation;
    }
    
	/*
	 * Read Get all users last location
	 * @return A list of objects VisitedLocation
	 */
	@RequestMapping("/getAllCurrentLocations")
    public List<VisitedLocation> getAllCurrentLocations() {
    	List<VisitedLocation> lastVisitedLocations = tourGuideService.getAllCurrentLocations();
    	return lastVisitedLocations;
    }
	
	

    /*
   	 * 
   	 * API TourGuideAttraction
   	 * 
   	 */
	
	/*
	 * Read - Get 5 Attractions that are the closest to user last saved location
	 * @param Id The user id
	 * @return A list of objects Attraction full filled (with reward points and distance to user)
	 */
	@RequestMapping("/getNearbyAttractions/{userId}") 
	public List<Attraction> getNearbyAttractions(@PathVariable("userId") final UUID userId) { 
		List<Attraction> attractions = tourGuideService.getNearByAttractions(userId); 
		return attractions;
	}
	
	/*
	 * Read - Get reward points for an Attraction
	 * @param String The Attraction name
	 * @return An object Attraction full filled
	 */
	@RequestMapping("/getRewardPointsByAttraction/{attractionName}") 
    public Attraction getRewardPointsByAttraction(@PathVariable("attractionName") final String attractionName) {
    	Attraction attractionWithReward = tourGuideService.getRewardPointsByAttraction(attractionName);
    	return attractionWithReward;
    }
	
	/*
	 * Read - Get reward points for a User
	 * @param Id The User id
	 * @return Int The number of reward points
	 */
	@RequestMapping("/getRewardPointsByUser/{userId}") 
    public int getRewardPointsByUser(@PathVariable("userId") final UUID userId) {
    	int userRewardPoints = tourGuideService.getRewardPointsByUser(userId);
    	return userRewardPoints;
    }
    
	

    /*
   	 * 
   	 * API TourGuidePricer
   	 * 
   	 */
	
	/*
	 * Read - Get trip deals
	 * @param userId and attractionId
	 * @return A list of objects TripDeal
	 */
	@RequestMapping("/getTripDeals/{userId}/{attractionName}")
    public List<TripDeal> getTripDeals(@PathVariable("userId") final UUID userId, 
    		@PathVariable("attractionName") final String attractionName) {
    	List<TripDeal> tripDeals = tourGuideService.getTripDeals(userId, attractionName);
    	return tripDeals;
    }
    
    

	

    /*
   	 * 
   	 * API TourGuideUser
   	 * 
   	 */

	/*
	 * Read - get user preferences 
	 * @param userId UUID
	 * @return the object to update
	 */

	@GetMapping("/getUserPreferences/{userId}")
	public UserPreferences getUserPreferences(@PathVariable("userId") final UUID userId) {
		UserPreferences userPreferences = tourGuideService.getUserPreferences(userId);
		return userPreferences;
	}

	/*
	 * Create - Save or modify user preferences
	 * @param userPreferencesId UUID
	 * @return the object saved 
	 */
	@PostMapping("/saveUserPreferences/{userId}")
	public UserPreferences saveUserPreferences(@PathVariable("userId") final UUID userId) {
		UserPreferences userPreferences = tourGuideService.saveUserPreferences(userId);
		return userPreferences;
	}

   

}