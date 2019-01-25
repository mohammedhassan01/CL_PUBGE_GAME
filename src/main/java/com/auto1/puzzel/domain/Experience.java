package com.auto1.puzzel.domain;

import java.io.Serializable;

public class Experience implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int enemieskilledNo;
	private int starsNo;
	
	public int getLevel() {
		return this.starsNo/10 + enemieskilledNo/5 ;
	}
	public int getEnemiesKilledNo() {
		return enemieskilledNo;
	}
	public void increaseEnemiesKilled() {
		this.enemieskilledNo++;
	}
	

	
	public int addStars(int starsNo)
	{
		this.starsNo += starsNo;
		return this.starsNo;
	}
	public int getStarsNo() {
		return starsNo;
	}


}
