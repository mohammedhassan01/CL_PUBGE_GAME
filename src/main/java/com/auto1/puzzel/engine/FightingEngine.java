package com.auto1.puzzel.engine;


import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.NonPlayerCharacter;
import com.auto1.puzzel.domain.Player;
import com.auto1.puzzel.exception.FightingBussinesException;
import com.auto1.puzzel.exception.GameBussinesException;
import com.auto1.puzzel.rules.GameRules;

// TODO apply fighting  experience rules here

public class FightingEngine {
	private NonPlayerCharacter enemy;
	private Game game;

	public FightingEngine(NonPlayerCharacter enemy, Game game) {
		this.enemy = enemy;
		this.game = game;
	}

	public void fight() {
		Player player = game.getPlayer();
		if (enemy != null && enemy.isLive()) {
			if (player.getFightingPower() >= enemy.getFightingPower()) {
				setHealthPointsForEnemyAndPlayer(player);
				if (!enemy.isLive()) {
					gainTheEnemyPowerAfterDied(player);
					checkGameOver();
				}
			} else {
				throw new FightingBussinesException("You can't fight Enemy With Fighting Power = "
						+ enemy.getFightingPower() + " No Collect Energy or fight weaker first go awy!!. ");
			}
		}
	}

	public void gainTheEnemyPowerAfterDied(Player player) {
		player.getExperience().increaseEnemiesKilled();
		player.getExperience().addStars(enemy.getReward());
		player.setFightingPower(player.getFightingPower() + GameRules.FIGHTING_POWER_POINTS_WHIEN_KILL_ENEMY);

	}

	public void setHealthPointsForEnemyAndPlayer(Player player) {
		if (player.getFightingPower() >= enemy.getFightingPower()) {
			int beforeHealthPoints = enemy.getHealthPoints();
			enemy.setHealthPoints(beforeHealthPoints - player.getFightingPower());
		} else {
			player.setHealthPoints(player.getHealthPoints() - 1);
		}
	}

	public boolean checkGameOver() {
		boolean allEnemiesDied = true;
		for (int x = 0; x < game.getPlayeZone().getYardMapX(); x++) {
			for (int y = 0; y < game.getPlayeZone().getYardMapY(); y++) {
				NonPlayerCharacter enemy =  game.getPlayeZone().getCell(new Coordinates(x, y)).getFighter();
				if(enemy != null && enemy.isLive()) {
					allEnemiesDied = false;
					break;
				}
			}
		}
		if(allEnemiesDied)
		{
			throw new GameBussinesException("You Win, :D :D");
		}
		return allEnemiesDied;
		
	}

}
