package com.auto1.puzzel.decision;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.exception.FightingBussinesException;
import com.auto1.puzzel.rules.GameRules;

public class PlayerFightingTest extends GameTestUtility {
	private static Game game;
	FightEnemyDecisionHandler fightEnemyDecisionHandler;

	@Before
	public void setupNewGame() {
		game = setupGame();
		fightEnemyDecisionHandler = new FightEnemyDecisionHandler(game);
	}

	@Test(expected = FightingBussinesException.class)
	public void fightNoOneShouldThrowException() {
		fightEnemyDecisionHandler.preProcess();
	}

	@Test(expected = FightingBussinesException.class)
	public void fightDiedEnemyShouldThrowException() {
		game.getPlayer().setCoordinates(new Coordinates(1, 2));
		fightEnemyDecisionHandler.preProcess();
	}

	@Test(expected = FightingBussinesException.class)
	public void testProcessfightingStrongerEnemyShouldThrowException() {
		game.getPlayer().setCoordinates(new Coordinates(3, 2));
		fightEnemyDecisionHandler.preProcess();
		fightEnemyDecisionHandler.process();
	}

	@Test
	public void testProcessfightingWeakerEnemyShouldWork() {
		game.getPlayer().setCoordinates(new Coordinates(2, 2));
		fightEnemyDecisionHandler.preProcess();
		fightEnemyDecisionHandler.process();
	}

	@Test
	public void testHealthPointsOfEnemyAfterFight() {
		game.getPlayer().setCoordinates(new Coordinates(2, 2));
		fightEnemyDecisionHandler.preProcess();
		fightEnemyDecisionHandler.process();
		assertEquals(fightEnemyDecisionHandler.getEnemy().getHealthPoints(), 15);
	}

	@Test
	public void testPlayerExperienceAfterKillEnemy() {
		game.getPlayer().setCoordinates(new Coordinates(2, 2));
		fightEnemyDecisionHandler.preProcess();
		fightEnemyDecisionHandler.process();
		fightEnemyDecisionHandler.process();
		fightEnemyDecisionHandler.process();
		fightEnemyDecisionHandler.process();
		assertEquals(fightEnemyDecisionHandler.getEnemy().getHealthPoints(), 0);
		assertEquals(game.getPlayer().getExperience().getStarsNo(), 5);
		assertEquals(game.getPlayer().getExperience().getEnemiesKilledNo(), 1);
		assertEquals(game.getPlayer().getFightingPower(), 5 + GameRules.FIGHTING_POWER_POINTS_WHIEN_KILL_ENEMY);
	}
	
}
