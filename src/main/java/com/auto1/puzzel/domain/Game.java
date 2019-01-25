package com.auto1.puzzel.domain;

import java.io.Serializable;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	private PlayeZone playeZone;
	private Player player;

	public Game(PlayeZone playeZone, Player player) {
		this.playeZone = playeZone;
		this.player = player;
	}

	public PlayeZone getPlayeZone() {
		return playeZone;
	}

	public void setPlayeZone(PlayeZone playeZone) {
		this.playeZone = playeZone;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	
}
