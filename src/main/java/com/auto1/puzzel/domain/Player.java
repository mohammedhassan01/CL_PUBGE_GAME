package com.auto1.puzzel.domain;

import java.util.Formatter;

import com.auto1.puzzel.configration.PlayerConfiguration;

public class Player extends Character {

	private static final long serialVersionUID = 1L;
	private Coordinates coordinates;
	private Experience experience;

	public Player(String name, String fightingMsg, int healthPoints, int fightingPower) {
		super(name, fightingMsg, healthPoints, fightingPower);
		this.experience = new Experience();

	}

	public Player(PlayerConfiguration conf, Coordinates coordinates) {
		this(conf.getName(), conf.getFightingMsg(), conf.getHealthPoints(), conf.getFightingPower());
		this.coordinates = coordinates;
	}
	

	public Coordinates exploreUp() {
		return coordinates.up();
	}

	public Coordinates exploreDown() {
		return coordinates.down();
	}

	public Coordinates exploreLeft() {
		return coordinates = coordinates.left();
	}

	public Coordinates exploreRight() {
		return coordinates.right();
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Experience getExperience() {
		return experience;
	}

	@Override
	public String getCharacterInfo() {
		StringBuilder playerInfo = new StringBuilder();
		Formatter formatter = new Formatter(playerInfo);
		formatter.format(GameStaticMessages.PLAYER_INFO, this.getName(), this.getHealthPoints(),
				this.experience.getLevel(),this.getFightingPower(), this.experience.getEnemiesKilledNo(), this.experience.getStarsNo());
		formatter.close();
		return playerInfo.toString();
	}


}
