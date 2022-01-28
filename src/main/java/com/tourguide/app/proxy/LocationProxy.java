package com.tourguide.app.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tourguide.app.CustomProperties;
import com.tourguide.app.model.VisitedLocation;

@Component
public class LocationProxy {

	@Autowired
	private CustomProperties props;
	//private CustomProperties props = new CustomProperties();
	
	public VisitedLocation getCurrentLocation(UUID userId) {
		String baseApiUrl = "http://localhost:9006";
		String getCurrentLocationUrl = baseApiUrl + "/getCurrentLocation/" + userId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<VisitedLocation> response = restTemplate.exchange(
				getCurrentLocationUrl, 
				HttpMethod.GET, 
				null,
				VisitedLocation.class
			);
		return response.getBody();
	}
	
	
	public VisitedLocation getLastLocation(UUID userId) {
		String baseApiUrl = "http://localhost:9006";
		String getLastLocationUrl = baseApiUrl + "/getLastLocation/" + userId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity <VisitedLocation> response = restTemplate.exchange(
				getLastLocationUrl, 
				HttpMethod.GET, 
				null,
				VisitedLocation.class
			);
		return response.getBody();
	}

}
