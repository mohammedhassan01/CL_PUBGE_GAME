package com.auto1.puzzel.decision;

import com.auto1.puzzel.configration.PlayerConfiguration;
import com.auto1.puzzel.context.ApplicationContext;
import com.auto1.puzzel.domain.GameStaticMessages;
import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.rules.GameRules;

public class CharacterCustomizationHandler {


	private InputParser inputParser = (InputParser) ApplicationContext.context.get(InputParser.class);

	public PlayerConfiguration getCutomizePlayerConfig() {

		PlayerConfiguration playerConfiguration = new PlayerConfiguration.PlayerConfigurationBuilder()
				.setName(getPlayerName()).setFightingMsg(getPlayerFighterMsg())
				.setHeathPoints(getHealthStartingPoints()).setFightingPower(getFightingPower()).Build();
		return playerConfiguration;

	}

	public String getPlayerName() {
		return inputParser.readUserInputAsString(GameStaticMessages.PLAYER_NAME_QUESTION);
	}

	public String getPlayerFighterMsg() {
		return inputParser.readUserInputAsString(GameStaticMessages.PLAYER_FIGHTING_MESSAGE_QUESTION);
	}

	public int getHealthStartingPoints() {
		return inputParser.tryReadingInputAsInt(GameStaticMessages.PLAYER_HEALTH_POINTS_QUESTION, GameRules.MAX_HEALTH_POINTS);
	}

	public int getFightingPower() {
		return inputParser.tryReadingInputAsInt(GameStaticMessages.PLAYER_FIGHTING_POWER_QUESTION, GameRules.MAX_FIGHTING_POWER);
	}
}
