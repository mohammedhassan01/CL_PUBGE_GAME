package com.auto1.puzzel.decision;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.exception.GameIOException;
import com.auto1.puzzel.io.utility.GameResourceHandler;

public class SaveLoadGameTest extends GameTestUtility {
	private static Game game;
	GameResourceHandler gameResourceHandlerHandler;

	@Before
	public void setup() {
		game = setupGame();

	}

	@Test
	public void testWriteGame() throws GameIOException {
		gameResourceHandlerHandler = new GameResourceHandler(game, "G33");
		gameResourceHandlerHandler.Save();
	}

	@Test
	public void testLoadGameWithNameExistShouldWork() throws GameIOException {
		gameResourceHandlerHandler = new GameResourceHandler(game, "xxxx");
		gameResourceHandlerHandler.Save();
		gameResourceHandlerHandler.setFileName("xxxx");
		gameResourceHandlerHandler.Load();
	}
	
	@Test
	public void testCheckTheGameStatusAfterLoad() throws GameIOException {
		gameResourceHandlerHandler = new GameResourceHandler(game, "xxxx");
		gameResourceHandlerHandler.Save();
		gameResourceHandlerHandler.setFileName("xxxx");
		Game game = gameResourceHandlerHandler.Load();
		assertEquals(game.getPlayer().getName(), "TestPlayer");
		assertEquals(game.getPlayer().getHealthPoints(), 20);
		assertEquals(game.getPlayeZone().getName(), "TESTZONE");
	}
	

	@Test(expected = GameIOException.class)
	public void testWriteGameToNullFileShouldThrowException() throws GameIOException {
		gameResourceHandlerHandler = new GameResourceHandler(game, null);
		gameResourceHandlerHandler.Save();
	}

	@Test(expected = GameIOException.class)
	public void testLoadGameWithNullFileName() throws GameIOException {
		gameResourceHandlerHandler = new GameResourceHandler(game, null);
		gameResourceHandlerHandler.Load();
	}

	@Test(expected = GameIOException.class)
	public void testLoadGameWithNameNotExist() throws GameIOException {
		gameResourceHandlerHandler = new GameResourceHandler(game, "zzzz");
		gameResourceHandlerHandler.Load();
	}

}
