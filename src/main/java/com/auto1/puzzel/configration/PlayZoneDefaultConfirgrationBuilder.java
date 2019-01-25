package com.auto1.puzzel.configration;

import java.util.ArrayList;
import java.util.List;

import com.auto1.puzzel.io.utility.NumbersUtilis;

public class PlayZoneDefaultConfirgrationBuilder {

	public static String PLAY_ZONE_NAME = "PUBG ZONE 1";
	public static int PLAY_ZONE_SIZE = 20;
	public static int PLAY_ZONE_NO_OF_ENEMIES = 30;
	public static int ENEMY_HEALTH_POINTS_MIN = 10;
	public static int ENEMY_HEALTH_POINTS_MAX = 50;
	public static int ENEMY_FIGHT_POWER_MIN = 1;
	public static int ENEMY_FIGHT_POWER_MAX = 10;
	public static int ENEMY_KILLER_REWARD_MIN = 1;
	public static int ENEMY_KILLER_REWARD_MAX = 5;

	public static int NO_OF_ENERGY_CELLS = 5;

	public static PlayZoneConfiguration getPLayZoneConfiguration() {

		PlayZoneConfiguration playZoneConfiguration = new PlayZoneConfiguration.PlayeZoneConfigurationBuilder()
				.setName(PLAY_ZONE_NAME).setRealmSize(PLAY_ZONE_SIZE).setEnemiseConfig(getEnemiesConfiguration()).Build();
		return playZoneConfiguration;
	}

	private static List<EnemyConfiguration> getEnemiesConfiguration() {
		List<EnemyConfiguration> enemiesConfig = new ArrayList<>();
		for (int i = 0; i < PLAY_ZONE_NO_OF_ENEMIES; i++) {
			int healthPoints = NumbersUtilis.randomIntInclusive(ENEMY_HEALTH_POINTS_MIN, ENEMY_HEALTH_POINTS_MAX);
			int fightingPower = NumbersUtilis.randomIntInclusive(ENEMY_FIGHT_POWER_MIN, ENEMY_FIGHT_POWER_MAX);
			int reward = NumbersUtilis.randomIntInclusive(ENEMY_KILLER_REWARD_MIN, ENEMY_KILLER_REWARD_MAX);
			int randomeInt = NumbersUtilis.randomIntInclusive(0, PLAY_ZONE_NO_OF_ENEMIES * 3);
			String enemyName = "ENEMY_" + String.valueOf(randomeInt);
			String fightingMsg = "I WILL KILL YOU BY " + String.valueOf(randomeInt) + " PULLTS";
			EnemyConfiguration enemyConfiguration = new EnemyConfiguration(enemyName, fightingMsg, healthPoints,
					fightingPower, reward);
			enemiesConfig.add(enemyConfiguration);
		}
		return enemiesConfig;
	}

}
