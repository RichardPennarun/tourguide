package com.tourguide.app.proxy;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tourguide.app.CustomProperties;
import com.tourguide.app.model.Attraction;
import com.tourguide.app.model.Reward;
import com.tourguide.app.model.VisitedLocation;

@Component
public class AttractionProxy {

	@Autowired
	private CustomProperties props;
	//private CustomProperties props = new CustomProperties();

	
	public List<Attraction> getNearByAttractions(VisitedLocation visitedLocation) {
		String baseApiUrl = "http://localhost:9007";
		String getNearByAttractionsUrl = baseApiUrl + "/getNearByAttractions";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<VisitedLocation> request = new HttpEntity<VisitedLocation>(visitedLocation);
		ResponseEntity<List<Attraction>> response = restTemplate.exchange(
				getNearByAttractionsUrl, 
				HttpMethod.POST, 
				request,
				new ParameterizedTypeReference<List<Attraction>>() {}
			);
		return response.getBody();
	}
	
	
	public Attraction getRewardPointsByAttraction(String attractionName) {
		String baseApiUrl = "http://localhost:9007";
		String getRewardPointsByAttractionUrl = baseApiUrl + "/getRewardPointsByAttraction/" + attractionName;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Attraction> response = restTemplate.exchange(
				getRewardPointsByAttractionUrl, 
				HttpMethod.GET, 
				null,
				Attraction.class
			);
		return response.getBody();
	}
	
	
	public List<Reward> getRewardsByUser(UUID userId) {
		String baseApiUrl = "http://localhost:9007";
		String getRewardsByUserUrl = baseApiUrl + "/getRewardsByUser/" + userId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Reward>> response = restTemplate.exchange(
				getRewardsByUserUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Reward>>() {}
			);
		
		return response.getBody();
	}
}
