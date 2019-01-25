package com.auto1.puzzel.decision;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.auto1.puzzel.configration.PlayerConfiguration;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.exception.GameBussinesException;
import com.auto1.puzzel.rules.GameRules;

public class createCharacterTest extends GameTestUtility {

	private static Game game;
	private static CreateCharacterDecisonHandler createCharacterDecisonHandler;

	int validHealthPoints = GameRules.MAX_HEALTH_POINTS;
	int validFightingPower = GameRules.MAX_HEALTH_POINTS;
	int notValidHealthPoints = GameRules.MAX_HEALTH_POINTS + 1;
	int notValidFightingPower = GameRules.MAX_HEALTH_POINTS + 1;

	@Before
	public  void onceExecutedBeforeAll() {

		game = setupGame();
		createCharacterDecisonHandler = new CreateCharacterDecisonHandler(game);
	}

	@Test(expected = GameBussinesException.class)
	public void shouldThrowExceptionWithNullUserName() {

		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder().setName(null)
				.setFightingMsg(null).setHeathPoints(validHealthPoints).setFightingPower(validFightingPower).Build();
		createCharacterDecisonHandler.setPlayerConfiguration(playerConfiguration);
		createCharacterDecisonHandler.process();

	}

	@Test(expected = GameBussinesException.class)
	public void shouldThrowExceptionWithOutOfRangHealthPoint() {

		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder()
				.setName("Player1").setFightingMsg(null).setHeathPoints(notValidHealthPoints)
				.setFightingPower(validFightingPower).Build();
		createCharacterDecisonHandler.setPlayerConfiguration(playerConfiguration);
		createCharacterDecisonHandler.process();
	}

	@Test(expected = GameBussinesException.class)
	public void shouldThrowExceptionWithOutOfRangFightingPoint() {

		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder()
				.setName("Player1").setFightingMsg(null).setHeathPoints(validHealthPoints)
				.setFightingPower(notValidHealthPoints).Build();
		createCharacterDecisonHandler.setPlayerConfiguration(playerConfiguration);
		createCharacterDecisonHandler.process();
	}

	@Test
	public void shouldWorkAllValuesInRang() {

		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder()
				.setName("Player1").setFightingMsg(null).setHeathPoints(validHealthPoints)
				.setFightingPower(validFightingPower).Build();
		createCharacterDecisonHandler.setPlayerConfiguration(playerConfiguration);
		createCharacterDecisonHandler.process();
		assertEquals("Player1", game.getPlayer().getName());
		assertEquals(null, game.getPlayer().getFightingMsg());
		assertEquals(validHealthPoints, game.getPlayer().getHealthPoints());
		assertEquals(validFightingPower, game.getPlayer().getFightingPower());

	}

}
