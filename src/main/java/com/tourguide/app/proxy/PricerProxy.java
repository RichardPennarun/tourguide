package com.tourguide.app.proxy;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tourguide.app.model.TripDeal;
import com.tourguide.app.model.TripRequest;

@Component
public class PricerProxy {
	
	public List<TripDeal> getTripDeals(TripRequest tripRequest) {
		String baseApiUrl = "http://localhost:9008";
		String getTripDealsUrl = baseApiUrl + "/getTripDeals";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<TripRequest> request = new HttpEntity<TripRequest>(tripRequest);
		ResponseEntity<List<TripDeal>> response = restTemplate.exchange(
				getTripDealsUrl, 
				HttpMethod.POST, 
				request,
				new ParameterizedTypeReference<List<TripDeal>>() {}
			);
		return response.getBody();
	}

}
