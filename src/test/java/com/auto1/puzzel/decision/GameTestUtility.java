package com.auto1.puzzel.decision;


import com.auto1.puzzel.configration.PlayerConfiguration;
import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Enemy;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.PlayeZone;
import com.auto1.puzzel.domain.Player;
import com.auto1.puzzel.domain.RealmCell;
import com.auto1.puzzel.domain.RealmCellType;

public class GameTestUtility {

	public Game setupGame() {
		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder()
				.setName("TestPlayer").setFightingPower(5).setHeathPoints(20).Build();
		Player player = new Player(playerConfiguration, new Coordinates(1, 1));
		RealmCell[][] yardMap = new RealmCell[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				yardMap[i][j] = new RealmCell(new Coordinates(j, j));
			}
		}
		
		Enemy diedEnemy = new Enemy("Died1","", 5,5,5);
		diedEnemy.setLive(false);
		
		yardMap[2][2].setFighter(new Enemy("Enemy1", "", 20, 5, 5));
		yardMap[2][2].setType(RealmCellType.ENEMY);
		yardMap[3][2].setFighter(new Enemy("Enemy2", "", 20, 10, 10));
		yardMap[3][2].setType(RealmCellType.ENEMY);
		
		yardMap[1][2].setFighter(diedEnemy);
		yardMap[1][2].setType(RealmCellType.NPC_DEAD);
		
		yardMap[1][0].setHasEnergy(true);
		yardMap[1][0].setType(RealmCellType.ENERGY);
		yardMap[1][4].setHasEnergy(true);
		yardMap[1][4].setType(RealmCellType.ENERGY);
		
		PlayeZone playeZone = new PlayeZone("TESTZONE", 5, 5, yardMap);
		return new Game(playeZone, player);
	}

}
