package com.auto1.puzzel.configration;

public class PlayerConfiguration {
	protected final String name;
	protected final String fightingMsg;
	protected int healthPoints;
	protected int fightingPower;

	private PlayerConfiguration(String name, String fightingMsg, int healthPoints, int fightingPower) {
		this.name = name;
		this.fightingMsg = fightingMsg;
		this.healthPoints = healthPoints;
		this.fightingPower = fightingPower;
	}

	public String getName() {
		return name;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getFightingPower() {
		return fightingPower;
	}

	public void setFightingPower(int fightingPower) {
		this.fightingPower = fightingPower;
	}

	public String getFightingMsg() {
		return fightingMsg;
	}

	public static final class PlayerConfigurationBuilder {
		private String name;
		private String fightingMsg;
		private int healthPoints;
		private int fightingPower;
		public PlayerConfigurationBuilder setName(String name)
		{
			this.name = name; 
			return this;
		}
		public PlayerConfigurationBuilder setFightingMsg(String msg)
		{
			this.fightingMsg = msg;
			return this;
		}
		public PlayerConfigurationBuilder setHeathPoints(int points)
		{
			this.healthPoints = points;
			return this;
		}
		public PlayerConfigurationBuilder setFightingPower(int power)
		{
			this.fightingPower = power;
			return this;
		}
		public PlayerConfiguration Build() {
			return new PlayerConfiguration(name, fightingMsg, healthPoints, fightingPower);
		}
	}
}
