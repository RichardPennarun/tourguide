package com.tourguide.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tourguide.app.helper.InternalTestHelper;
import com.tourguide.app.helper.Tracker;
import com.tourguide.app.model.Attraction;
import com.tourguide.app.model.Reward;
import com.tourguide.app.model.TripDeal;
import com.tourguide.app.model.TripRequest;
import com.tourguide.app.model.User;
import com.tourguide.app.model.UserPreferences;
import com.tourguide.app.model.VisitedLocation;
import com.tourguide.app.proxy.AttractionProxy;
import com.tourguide.app.proxy.LocationProxy;
import com.tourguide.app.proxy.PricerProxy;
import com.tourguide.app.proxy.UserProxy;


@Service
public class TourGuideService {

	//@Autowired
	//private UserProxy userProxy;

	private Logger logger = LoggerFactory.getLogger(TourGuideService.class);
	private final LocationProxy locationProxy = new LocationProxy();
	private final AttractionProxy attractionProxy = new AttractionProxy();
	private final PricerProxy pricerProxy = new PricerProxy();
	private final UserProxy userProxy = new UserProxy();
	// private final GpsUtil gpsUtil;
	// private final RewardsService rewardsService;
	// private final TripPricer tripPricer = new TripPricer();
	public final Tracker tracker;
	boolean testMode = true;

	public TourGuideService() {
		// this.locationProxy = locationProxy;
		// this.gpsUtil = gpsUtil;
		// this.rewardsService = rewardsService;

		if (testMode) {
			logger.info("TestMode enabled");
			logger.debug("Initializing users");
			initializeInternalUsers();
			logger.debug("Finished initializing users");
		}
		tracker = new Tracker(this);
		addShutDownHook();
	}

	
	
	/*
	 * 
	 * Location API
	 * 
	 */
	public VisitedLocation getCurrentLocation(UUID userId) {
		VisitedLocation currentLocation = locationProxy.getCurrentLocation(userId);
		return currentLocation;
	}

	public VisitedLocation getLastLocation(UUID userId) {
		VisitedLocation lastVisitedLocation = locationProxy.getLastLocation(userId);
		return lastVisitedLocation;
	}

	public List<VisitedLocation> getAllCurrentLocations() {
		List<VisitedLocation> lastVisitedLocations = new ArrayList<>();
		InternalTestHelper.setInternalUserNumber(10);
		List<User> allUsers = new ArrayList<>();
		for (User user : allUsers) {
			VisitedLocation visitedLocation = getLastLocation(user.getUserId());
			lastVisitedLocations.add(visitedLocation);
		}
		return lastVisitedLocations;
	}

	
	
	
	/*
	 * 
	 * Attraction API
	 * 
	 */
	public List<Attraction> getNearByAttractions(UUID userId) {
		VisitedLocation visitedLocation = locationProxy.getLastLocation(userId);
		List<Attraction> nearbyAttractions = attractionProxy.getNearByAttractions(visitedLocation);
		return nearbyAttractions;
	}

	public Attraction getRewardPointsByAttraction(String attractionName) {
		Attraction attractionWithRewardPoints = attractionProxy.getRewardPointsByAttraction(attractionName);
		return attractionWithRewardPoints;
	}
	
	public int getRewardPointsByUser(UUID userId) {
		List<Reward> UserRewards = getRewardsByUser(userId);
		int userRewardPoints = 0;
		for (Reward userReward : UserRewards) {
			userRewardPoints = userRewardPoints + userReward.getRewardPoints();
		}
		return userRewardPoints;
	}

	private List<Reward> getRewardsByUser(UUID userId) {
		List<Reward> userRewards = attractionProxy.getRewardsByUser(userId);
		return userRewards;
	}


	
	
	/*
	 * 
	 * Pricer API
	 * 
	 */
	public List<TripDeal> getTripDeals(UUID userId, String attractionName) {
		UserPreferences userPreferences = userProxy.getUserPreferences(userId);
		Attraction attractionWithRewardPoints = attractionProxy.getRewardPointsByAttraction(attractionName);
		TripRequest tripRequest = new TripRequest();
		tripRequest.setId(UUID.randomUUID());
		tripRequest.setRequestDate(new Timestamp(System.currentTimeMillis()));
		tripRequest.setUserId(userId);
		tripRequest.setUserRewardPoints(getRewardPointsByUser(userId));
		tripRequest.setAttractionId(attractionWithRewardPoints.getId());
		tripRequest.setAttractionName(attractionWithRewardPoints.getAttractionName());
		tripRequest.setAttractionRewardpoints(attractionWithRewardPoints.getReward());
		tripRequest.setNightsStay(4);
		tripRequest.setNumberOfAdults(2);
		tripRequest.setNumberOfChildren(2);
		
		List<TripDeal> tripDeals = pricerProxy.getTripDeals(tripRequest);
		
		return tripDeals;

	}


	
	/*
	 * 
	 * User API
	 * 
	 */

	public UserPreferences getUserPreferences(@PathVariable("userId") final UUID userId) {
		UserPreferences userPreferences = userProxy.getUserPreferences(userId);
		return userPreferences;

	}
	
	public UserPreferences saveUserPreferences(@PathVariable("userId") final UUID userId) {
		UserPreferences userPreferences = userProxy.getUserPreferences(userId);
		UserPreferences savedUserPreferences = userProxy.saveUserPreferences(userPreferences);
		return savedUserPreferences;
	}
	
	
	
	public User getUser(UUID userId) {
		return internalUserMap.get(userId);
	}

	public User getUser(String userName) {
		return internalUserMap.get(userName);
	}

	public List<User> getAllUsers() {
		return internalUserMap.values().stream().collect(Collectors.toList());
	}

	public void addUser(User user) {
		if (!internalUserMap.containsKey(user.getUserName())) {
			internalUserMap.put(user.getUserName(), user);
		}
	}

	private void addShutDownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				tracker.stopTracking();
			}
		});
	}

	
	/**********************************************************************************
	 * 
	 * Methods Below: For Internal Testing
	 * 
	 **********************************************************************************/
	// private static final String tripPricerApiKey = "test-server-api-key";
	// Database connection will be used for external users, but for testing purposes
	// internal users are provided and stored in memory
	private final Map<String, User> internalUserMap = new HashMap<>();

	private void initializeInternalUsers() {
		IntStream.range(0, InternalTestHelper.getInternalUserNumber()).forEach(i -> {
			String userName = "internalUser" + i;
			String phone = "000";
			String email = userName + "@com.tourguide.app.com";
			User user = new User(UUID.randomUUID(), userName, phone, email);
			// generateUserLocationHistory(user);

			internalUserMap.put(userName, user);
		});
		logger.debug("Created " + InternalTestHelper.getInternalUserNumber() + " internal test users.");
	}

	/*
	 * private void generateUserLocationHistory(User user) { IntStream.range(0,
	 * 3).forEach(i-> { user.addToVisitedLocations(new
	 * VisitedLocation(user.getUserId(), new Location(generateRandomLatitude(),
	 * generateRandomLongitude()), getRandomTime())); }); }
	 */

	/*
	 * private double generateRandomLongitude() { double leftLimit = -180; double
	 * rightLimit = 180; return leftLimit + new Random().nextDouble() * (rightLimit
	 * - leftLimit); }
	 * 
	 * private double generateRandomLatitude() { double leftLimit = -85.05112878;
	 * double rightLimit = 85.05112878; return leftLimit + new Random().nextDouble()
	 * * (rightLimit - leftLimit); }
	 * 
	 * private Date getRandomTime() { LocalDateTime localDateTime =
	 * LocalDateTime.now().minusDays(new Random().nextInt(30)); return
	 * Date.from(localDateTime.toInstant(ZoneOffset.UTC)); }
	 */

}
