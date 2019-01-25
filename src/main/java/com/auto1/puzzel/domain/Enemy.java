package com.auto1.puzzel.domain;

import java.util.Formatter;

import com.auto1.puzzel.configration.EnemyConfiguration;

public class Enemy extends NonPlayerCharacter {
	private static final long serialVersionUID = 1L;


	public Enemy(String name, String fightingMsg, int healthPoints, int fightPower, int reward) {
        super(name, fightingMsg,healthPoints, fightPower, reward);
     }
   

    public Enemy(EnemyConfiguration enemyConfig) {
        this(enemyConfig.getName(), enemyConfig.getFightingMsg(), enemyConfig.getHealthPoints(), enemyConfig.getFightingPower(), enemyConfig.getRewardToKiller());
    }


	@Override
	protected RealmCellType locationType() {
		return RealmCellType.ENEMY;
	}


	@Override
	public String getCharacterInfo() {
		StringBuilder enemyInfo = new StringBuilder();
    	Formatter formatter = new Formatter(enemyInfo);
    	formatter.format(GameStaticMessages.ENEMY_INFO, this.getName(), this.getReward() ,this.getFightingPower() ,  this.getHealthPoints());
    	formatter.close();
     	return  enemyInfo.toString();
	}
	
}
