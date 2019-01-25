package com.auto1.puzzel.configration;

public class EnemyConfiguration {

	protected final String name;
	protected final String fightingMsg;
	protected int healthPoints;
	protected int fightingPower;
	protected int rewardToKiller;
	
	public EnemyConfiguration(String name, String fightingMsg, int healthPoints, int fightingPower, int reward) {
        this.name = name;
        this.fightingMsg = fightingMsg;
        this.healthPoints = healthPoints;
        this.fightingPower = fightingPower;
        this.rewardToKiller = reward;
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

	public int getRewardToKiller() {
		return rewardToKiller;
	}

	public void setRewardToKiller(int rewardToKiller) {
		this.rewardToKiller = rewardToKiller;
	}

	public String getFightingMsg() {
		return fightingMsg;
	}

	
    public String getName() {
        return name;
    }

}
