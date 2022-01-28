package com.tourguide.app;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.StopWatch;

import com.tourguide.app.helper.InternalTestHelper;
import com.tourguide.app.model.User;
import com.tourguide.app.service.TourGuideService;

public class TestPerformance {
	
	/*
	 * A note on performance improvements:
	 *     
	 *     The number of users generated for the high volume tests can be easily adjusted via this method:
	 *     
	 *     		InternalTestHelper.setInternalUserNumber(100000);
	 *     
	 *     
	 *     These tests can be modified to suit new solutions, just as long as the performance metrics
	 *     at the end of the tests remains consistent. 
	 * 
	 *     These are performance metrics that we are trying to hit:
	 *     
	 *     highVolumeTrackLocation: 100,000 users within 15 minutes:
	 *     		assertTrue(TimeUnit.MINUTES.toSeconds(15) >= TimeUnit.MILLISECONDS.toSeconds(stopWatch.getTime()));
     *
     *     highVolumeGetRewards: 100,000 users within 20 minutes:
	 *          assertTrue(TimeUnit.MINUTES.toSeconds(20) >= TimeUnit.MILLISECONDS.toSeconds(stopWatch.getTime()));
	 */
	
	
	
	@Test
	public void highVolumeTrackLocation() {
		//GpsUtil gpsUtil = new GpsUtil();
		//RewardsService rewardsService = new RewardsService(gpsUtil, new RewardCentral());
		
		// Users should be incremented up to 100,000, and test finishes within 15 minutes
		InternalTestHelper.setInternalUserNumber(100);
		TourGuideService tourGuideService = new TourGuideService();

		List<User> allUsers = new ArrayList<>();
		allUsers = tourGuideService.getAllUsers();
		
	    StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for(User user : allUsers) {
			tourGuideService.getCurrentLocation(user.getUserId());
		}
		stopWatch.stop();
		tourGuideService.tracker.stopTracking();

		System.out.println("highVolumeTrackLocation: Time Elapsed: " + TimeUnit.MILLISECONDS.toSeconds(stopWatch.getTotalTimeMillis()) + " seconds."); 
		assertTrue(TimeUnit.MINUTES.toSeconds(20) >= TimeUnit.MILLISECONDS.toSeconds(stopWatch.getTotalTimeMillis()));
	}
	
	@Test
	public void highVolumeGetRewards() {
		//GpsUtil gpsUtil = new GpsUtil();
		//RewardsService rewardsService = new RewardsService(gpsUtil, new RewardCentral());

		// Users should be incremented up to 100,000, and test finishes within 20 minutes
		InternalTestHelper.setInternalUserNumber(100);
		TourGuideService tourGuideService = new TourGuideService();

		List<User> allUsers = new ArrayList<>();
		allUsers = tourGuideService.getAllUsers();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for(User user : allUsers) {
			tourGuideService.getRewardPointsByAttraction("Dysneyland");
		}
		stopWatch.stop();
		tourGuideService.tracker.stopTracking();

		System.out.println("highVolumeGetRewards: Time Elapsed: " + TimeUnit.MILLISECONDS.toSeconds(stopWatch.getTotalTimeMillis()) + " seconds."); 
		assertTrue(TimeUnit.MINUTES.toSeconds(20) >= TimeUnit.MILLISECONDS.toSeconds(stopWatch.getTotalTimeMillis()));
	}
	
}
