package com.auto1.puzzel.configration;

public class PlayerDefaultConfigurationBuilder {
	private static String PLAYER_NAME = "MOHAMED HASSAN";
	private static String PLAYER_FIGHT_MSG = "I WILL KILL YOU ALL!!";
	private static int PLAYER_HEALTH_POINTS = 100;
	private static int PLAYER_FIGHT_POWER = 5;

	public static PlayerConfiguration getDefaultPlayerConfiguration() {
		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder()
				.setName(PLAYER_NAME).setFightingMsg(PLAYER_FIGHT_MSG).setHeathPoints(PLAYER_HEALTH_POINTS)
				.setFightingPower(PLAYER_FIGHT_POWER).Build();
		return playerConfiguration;
	}
}
