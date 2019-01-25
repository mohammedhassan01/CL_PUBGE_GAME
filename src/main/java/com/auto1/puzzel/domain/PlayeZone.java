package com.auto1.puzzel.domain;

import java.io.Serializable;
import java.util.List;

import com.auto1.puzzel.configration.EnemyConfiguration;
import com.auto1.puzzel.configration.PlayZoneConfiguration;
import com.auto1.puzzel.io.utility.NumbersUtilis;

public class PlayeZone implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String name;
	private final int yardMapX;
	private final int yardMapY;
	private RealmCell[][] yardMap;

	public PlayeZone(PlayZoneConfiguration realmConfiguration) {
		this.yardMapX = realmConfiguration.getRealmSize();
		this.yardMapY = realmConfiguration.getRealmSize();
		this.yardMap = new RealmCell[realmConfiguration.getRealmSize()][realmConfiguration.getRealmSize()];
		this.name = realmConfiguration.getName();
		initYardMap();
		allocateEnemies(yardMapX, yardMapY, realmConfiguration.getEnemyConfiguration());
		allocateEnergy(realmConfiguration.getNoOfEnergyCells());
	}

	public PlayeZone(String name, int yardMapX, int yardMapY, RealmCell[][] yardMap) {
		this.name = name;
		this.yardMapX = yardMapX;
		this.yardMapY = yardMapY;
		this.yardMap = yardMap;
	}

	public int getYardMapX() {
		return yardMapX;
	}

	public int getYardMapY() {
		return yardMapY;
	}

	public RealmCell[][] getYardMap() {
		return yardMap;
	}

	public void setYardMap(RealmCell[][] yardMap) {
		this.yardMap = yardMap;
	}

	public RealmCell getCell(Coordinates coordinates) {
		if (NumbersUtilis.isWithinRangeExclusive(coordinates.getX(), 0, yardMapX)
				&& NumbersUtilis.isWithinRangeExclusive(coordinates.getY(), 0, yardMapY)) {
			return yardMap[coordinates.getX()][coordinates.getY()];
		}
		return null;
	}

	public String getName() {
		return name;
	}

	private void allocateEnemies(int yardX, int yardY, List<EnemyConfiguration> enemiesConfigs) {
		for (EnemyConfiguration enemyConfig : enemiesConfigs) {
			int x = NumbersUtilis.randomIntExclusive(0, yardMapX);
			int y = NumbersUtilis.randomIntExclusive(0, yardMapY);
			Coordinates coordinates = new Coordinates(x, y);
			Enemy enemy = new Enemy(enemyConfig);
			yardMap[x][y] = new RealmCell(coordinates, enemy);
		}

	}

	private void allocateEnergy(int energyCellSize) {
		while (energyCellSize > 0) {
			int x = NumbersUtilis.randomIntExclusive(0, yardMapX);
			int y = NumbersUtilis.randomIntExclusive(0, yardMapY);
			Coordinates coordinates = new Coordinates(x, y);
			if (yardMap[x][y].getFighter() == null) {
				yardMap[x][y] = new RealmCell(coordinates, true);
				energyCellSize--;
			}
		}

	}

	private void initYardMap() {
		for (int x = 0; x < yardMapX; x++) {
			for (int y = 0; y < yardMapY; y++) {
				yardMap[x][y] = new RealmCell(new Coordinates(x, y));
			}
		}
	}

}
