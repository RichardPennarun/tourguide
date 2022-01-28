package com.tourguide.app.proxy;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tourguide.app.model.UserPreferences;

@Component
public class UserProxy {
	
	public UserPreferences getUserPreferences(UUID userId) {
		String baseApiUrl = "http://localhost:9009";
		String getUserPreferencesUrl = baseApiUrl + "/getUserPreferences/" + userId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserPreferences> response = restTemplate.exchange(
				getUserPreferencesUrl, 
				HttpMethod.GET, 
				null,
				UserPreferences.class
			);
		
		return response.getBody();
	}
	
	public UserPreferences saveUserPreferences(UserPreferences userPreferences) {
		String baseApiUrl = "http://localhost:9009";
		String saveUserPreferencesUrl = baseApiUrl + "/saveUserPreferences";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<UserPreferences> request = new HttpEntity<UserPreferences>(userPreferences);
		ResponseEntity<UserPreferences> response = restTemplate.exchange(
				saveUserPreferencesUrl, 
				HttpMethod.POST, 
				request,
				UserPreferences.class
			);
		
		return response.getBody();
	}

}
