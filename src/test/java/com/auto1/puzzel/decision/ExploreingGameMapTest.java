package com.auto1.puzzel.decision;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.auto1.puzzel.domain.Coordinates;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.exception.GameOutOfZoneException;

public class ExploreingGameMapTest extends GameTestUtility {
	private static Game game;
	private static ExplorDecisionHandler explorDecisionHandler;

	@Before 
	public void setupNewGame()
	{
		game = setupGame();
	}

	@Test
	public void testIsValidCoordinatesWithinRange() {
		game = setupGame();
		explorDecisionHandler = new ExplorDecisionHandler(game, new Coordinates(2, 3));
		explorDecisionHandler.preProcess();
		assertEquals(explorDecisionHandler.isValidCoordinates(), true);

	}

	@Test(expected = GameOutOfZoneException.class)
	public void testCoordinatesOutOfRangeShouldThrowException() {
		explorDecisionHandler = new ExplorDecisionHandler(game, new Coordinates(6, 3));
		explorDecisionHandler.preProcess();
	}

	@Test
	public void testMoveToNewCoordinate() {
		explorDecisionHandler = new ExplorDecisionHandler(game, new Coordinates(2, 3));
		explorDecisionHandler.isValidCoordinates = true;
		explorDecisionHandler.process();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(2, 3));
	}

	@Test
	public void testMoveToCornerCoordinate() {
		explorDecisionHandler = new ExplorDecisionHandler(game, new Coordinates(0, 0));
		explorDecisionHandler.isValidCoordinates = true;
		explorDecisionHandler.process();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(0, 0));
	}

	@Test
	public void testExecuateWithOutOfRangeCoordinate() {
		explorDecisionHandler = new ExplorDecisionHandler(game, new Coordinates(9, 0));
		explorDecisionHandler.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(1, 1));
	}

	@Test
	public void testExecuateWithInRangeCoordinate() {
		explorDecisionHandler = new ExplorDecisionHandler(game, new Coordinates(3, 0));
		explorDecisionHandler.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(3, 0));
	}

}
