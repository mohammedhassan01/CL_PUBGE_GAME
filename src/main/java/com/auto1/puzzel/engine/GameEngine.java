package com.auto1.puzzel.engine;

import com.auto1.puzzel.configration.PlayZoneConfiguration;
import com.auto1.puzzel.configration.PlayZoneDefaultConfirgrationBuilder;
import com.auto1.puzzel.configration.PlayerConfiguration;
import com.auto1.puzzel.configration.PlayerDefaultConfigurationBuilder;
import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.PlayeZone;
import com.auto1.puzzel.domain.Player;
import com.auto1.puzzel.viwer.CLGameViewBuilder;

public class GameEngine {
	private PlayeZone playeZone;
	private Player player;

	public PlayeZone getPlayeZone() {
		return playeZone;
	}

	public void setPlayeZone(PlayeZone playeZone) {
		this.playeZone = playeZone;
	}

	public GameEngine() {
		initPlayZone();
		initPlayer();
	}

	public void showPlayZone() {
		CLGameViewBuilder clGameViewBuilder = new CLGameViewBuilder(this.playeZone, this.player);
		System.out.println(clGameViewBuilder.viewMap());
	}

	private void initPlayZone() {
		PlayZoneConfiguration playZoneConfiguration = PlayZoneDefaultConfirgrationBuilder.getPLayZoneConfiguration();
		this.playeZone = new PlayeZone(playZoneConfiguration);
	}

	private void initPlayer() {
		PlayerConfiguration playerConfiguration = PlayerDefaultConfigurationBuilder.getDefaultPlayerConfiguration();
		Coordinates coordinates = new Coordinates(1, 3);
		this.player = new Player(playerConfiguration, coordinates);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
