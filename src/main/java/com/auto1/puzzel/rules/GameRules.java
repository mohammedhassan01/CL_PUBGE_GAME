package com.auto1.puzzel.rules;

public interface GameRules {
	static final int MAX_HEALTH_POINTS = 100;
	static final int DEFAULT_PLAYER_HEALTH_POINTS = 50;
	static final String DEFAULT_PLAYER_NAME = "MO HASSAN";
	static final int MAX_FIGHTING_POWER = 10;
	static final int MAX_KILL_AWARD = 5;
	static final int MAX_MAP_SIZE = 30;
	static final int MIN_MAP_SIZE = 5;
	static final double NUMBER_OF_ENEMIES_TO_MAP_SIZE_RATIO = 0.2;
	static final double NUMBER_OF_ENERGY_TO_MAP_SIZE_RATIO = 0.1;
	static final int MIN_HEALTH_POINTS = 1;
	static final int MIN_FIGHTING_POWER = 1;
	public final int FIGHTING_POWER_POINTS_WHIEN_KILL_ENEMY = 5;
	
	
	static int getEnemisSize(int mapSize)
	{
		return (int) (mapSize*mapSize*NUMBER_OF_ENEMIES_TO_MAP_SIZE_RATIO);
		
	}
	static int getNumberOfEnergyOnMap(int mapSize)
	{
		return (int) (mapSize*mapSize*NUMBER_OF_ENERGY_TO_MAP_SIZE_RATIO);
		
	}

}
