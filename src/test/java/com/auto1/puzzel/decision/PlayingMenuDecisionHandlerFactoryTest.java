package com.auto1.puzzel.decision;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.menu.CLPlayingMenuHandler;
import com.auto1.puzzel.menu.PlayingMenuOptions;

public class PlayingMenuDecisionHandlerFactoryTest extends GameTestUtility {
	private static Game game;
	private static PlayingMenuDecisionHandlerFactory playingMenuDecisionHandlerFactory;

	@Before
	public void setupNewGame() {
		game = setupGame();
		playingMenuDecisionHandlerFactory = new PlayingMenuDecisionHandlerFactory(game, null);
	}

	@Test
	public void TestExploreingHandler() {
		Object exploreHandler = playingMenuDecisionHandlerFactory.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_UP);
		assertEquals(exploreHandler.getClass(), ExplorDecisionHandler.class);

		Object downHandler = playingMenuDecisionHandlerFactory.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_DOWN);
		assertEquals(downHandler.getClass(), ExplorDecisionHandler.class);

		Object leftHandler = playingMenuDecisionHandlerFactory.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_LEFT);
		assertEquals(leftHandler.getClass(), ExplorDecisionHandler.class);

		Object rightHandler = playingMenuDecisionHandlerFactory
				.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_RIGHT);
		assertEquals(rightHandler.getClass(), ExplorDecisionHandler.class);
	}

	@Test
	public void TestExploreingUpInRange() {
		UserDecisionExecutor<Game> executor = playingMenuDecisionHandlerFactory
				.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_UP);
		Object returned = executor.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(1, 0));
		assertEquals(returned.getClass(), CLPlayingMenuHandler.class);
	}

	@Test
	public void TestExploreingUpOutOfRange() {
		game.getPlayer().setCoordinates(new Coordinates(0, 0));
		UserDecisionExecutor<Game> executor = playingMenuDecisionHandlerFactory
				.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_UP);
		Object returned = executor.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(0, 0));
		assertEquals(returned.getClass(), CLPlayingMenuHandler.class);
	}

	@Test
	public void TestExploreingDownInRange() {
		UserDecisionExecutor<Game> executor = playingMenuDecisionHandlerFactory
				.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_DOWN);
		Object returned = executor.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(1, 2));
		assertEquals(returned.getClass(), CLPlayingMenuHandler.class);
	}

	@Test
	public void TestExploreingLeftInRange() {
		UserDecisionExecutor<Game> executor = playingMenuDecisionHandlerFactory
				.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_LEFT);
		Object returned = executor.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(0, 1));
		assertEquals(returned.getClass(), CLPlayingMenuHandler.class);
	}

	@Test
	public void TestExploreingRightInRange() {
		UserDecisionExecutor<Game> executor = playingMenuDecisionHandlerFactory
				.getUserDecisionHandler(PlayingMenuOptions.EXPLORE_RIGHT);
		Object returned = executor.execute();
		assertEquals(game.getPlayer().getCoordinates(), new Coordinates(2, 1));
		assertEquals(returned.getClass(), CLPlayingMenuHandler.class);
	}

}
