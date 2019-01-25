package com.auto1.puzzel.domain;

import java.util.Formatter;

public abstract class NonPlayerCharacter extends Character {

	private static final long serialVersionUID = 1L;
	private final int reward;

	public NonPlayerCharacter(String name, String fightingMsg, int healthPoints, int fightPower, int reward) {
		super(name, fightingMsg, healthPoints, fightPower);
		this.reward = reward;
	}

	public int getReward() {
		return reward;
	}

	public boolean isEnemy() {
		return this instanceof Enemy;
	}

	public RealmCellType getlocationType() {
		if (!live) {
			return RealmCellType.NPC_DEAD;
		} else {
			return locationType();
		}
	}

	public static String getEnemyInfo(Enemy enemy) {
		StringBuilder enemyInfo = new StringBuilder();
		Formatter formatter = new Formatter(enemyInfo);
		formatter.format(GameStaticMessages.ENEMY_INFO, enemy.getName(), enemy.getReward(), enemy.getHealthPoints());
		formatter.close();
		return enemyInfo.toString();
	}

	protected abstract RealmCellType locationType();

}
