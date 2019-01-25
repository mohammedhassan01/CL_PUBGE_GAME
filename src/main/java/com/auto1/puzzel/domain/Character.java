package com.auto1.puzzel.domain;

import java.io.Serializable;

public abstract class Character implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final String name;
	protected final String fightingMsg;
	protected int healthPoints;
	protected int fightingPower;
	protected boolean live;

	public Character(String name, String fightingMsg, int healthPoints, int fightingPower) {
		this.name = name;
		this.fightingMsg = fightingMsg;
		this.healthPoints = healthPoints;
		this.fightingPower = fightingPower;
		this.live = true;
	}
	
	

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		if(healthPoints <= 0 )
		{
			this.live = false;
		}
		this.healthPoints = healthPoints;
	}

	public int getFightingPower() {
		return fightingPower;
	}

	public void setFightingPower(int fightingPower) {
		this.fightingPower = fightingPower;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public String getName() {
		return name;
	}

	public String getFightingMsg() {
		return fightingMsg;
	}
	
	public abstract String getCharacterInfo();
	

}
