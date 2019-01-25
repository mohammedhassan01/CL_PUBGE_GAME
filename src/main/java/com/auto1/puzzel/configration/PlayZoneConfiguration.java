package com.auto1.puzzel.configration;

import java.util.List;
import com.auto1.puzzel.rules.GameRules;

public class PlayZoneConfiguration {
	private final String name;
	private final int realmSize;
	private final int numberOfEnemies;
	private final List<EnemyConfiguration> enemiesConfig;
	private final int noOfEnergyCells;

	private PlayZoneConfiguration(String name, int realmSize, List<EnemyConfiguration> enemies) {
		this.name = name;
		this.realmSize = realmSize;
		this.enemiesConfig = enemies;
		this.numberOfEnemies = GameRules.getEnemisSize(realmSize);
		this.noOfEnergyCells = GameRules.getNumberOfEnergyOnMap(realmSize);
	}

	public int getNoOfEnergyCells() {
		return noOfEnergyCells;
	}

	public int getNumberOfEnemies() {
		return numberOfEnemies;
	}

	public List<EnemyConfiguration> getEnemies() {
		return enemiesConfig;
	}

	public String getName() {
		return name;
	}

	public int getRealmSize() {
		return realmSize;
	}

	public List<EnemyConfiguration> getEnemyConfiguration() {
		return enemiesConfig;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getEnregyCellSize() {
		return 10;
	}

	public static final class PlayeZoneConfigurationBuilder {
		private String name;
		private int realmSize;
		private List<EnemyConfiguration> enemiesConfig;

		public PlayeZoneConfigurationBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public PlayeZoneConfigurationBuilder setRealmSize(int realmSize) {
			this.realmSize = realmSize;
			return this;
		}


		public PlayeZoneConfigurationBuilder setEnemiseConfig(List<EnemyConfiguration> enemiesConfig) {
			this.enemiesConfig = enemiesConfig;
			return this;
		}

		public PlayZoneConfiguration Build() {
			return new PlayZoneConfiguration(name, realmSize, enemiesConfig);
		}
	}
}
