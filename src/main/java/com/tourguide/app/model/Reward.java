package com.tourguide.app.model;

import java.util.Date;
import java.util.UUID;

public class Reward {

	private UUID id;
	private UUID userId;
	private UUID attractionId;
	private int RewardPoints;
	private Date timeVisited;

	public Reward() {
	}

	public Reward(UUID id, UUID userId, UUID attractionId, int rewardPoints, Date timeVisited) {
		super();
		this.id = id;
		this.userId = userId;
		this.attractionId = attractionId;
		this.RewardPoints = rewardPoints;
		this.timeVisited = timeVisited;
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

	public int getRewardPoints() {
		return RewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		RewardPoints = rewardPoints;
	}

	public Date getTimeVisited() {
		return timeVisited;
	}

	public void setTimeVisited(Date timeVisited) {
		this.timeVisited = timeVisited;
	}
	
	}
	