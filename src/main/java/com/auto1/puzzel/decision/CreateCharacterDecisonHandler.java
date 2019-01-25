package com.auto1.puzzel.decision;

import com.auto1.puzzel.configration.PlayerConfiguration;
import com.auto1.puzzel.context.ApplicationContext;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.GameStaticMessages;
import com.auto1.puzzel.domain.Player;
import com.auto1.puzzel.rules.GameRulesValidator;

public class CreateCharacterDecisonHandler extends UserDecisionExecutor<Game> {

	private CharacterCustomizationHandler characterCustomizationHandler;
	private boolean validPlayerConfig = false;
	private PlayerConfiguration playerConfiguration;

	public CreateCharacterDecisonHandler(Game game) {
		super(game);
		characterCustomizationHandler = (CharacterCustomizationHandler) ApplicationContext.context
				.get(CharacterCustomizationHandler.class);
	}

	public CharacterCustomizationHandler getCharacterCustomizationHandler() {
		return characterCustomizationHandler;
	}

	public void setCharacterCustomizationHandler(CharacterCustomizationHandler characterCustomizationHandler) {
		this.characterCustomizationHandler = characterCustomizationHandler;
	}

	public boolean isValidPlayerConfig() {
		return validPlayerConfig;
	}

	public void setValidPlayerConfig(boolean validPlayerConfig) {
		this.validPlayerConfig = validPlayerConfig;
	}

	public PlayerConfiguration getPlayerConfiguration() {
		return playerConfiguration;
	}

	public void setPlayerConfiguration(PlayerConfiguration playerConfiguration) {
		this.playerConfiguration = playerConfiguration;
	}

	@Override
	public boolean preProcess() {
		outputWriter.showMessage("CUSTOMIZE YOUR PLAYER,");
		playerConfiguration = characterCustomizationHandler.getCutomizePlayerConfig();
		return true;
	}

	@Override
	public boolean process() {
		validPlayerConfig = GameRulesValidator.isValidPlayerConfiguration(playerConfiguration);
		if (validPlayerConfig) {
			Player customizePlayer = new Player(playerConfiguration, Game.getPlayer().getCoordinates());
			Game.setPlayer(customizePlayer);
		}
		return true;
	}

	@Override
	public Object postProcess() {
		if (validPlayerConfig) {
			startMenuHandler.showMessage(GameStaticMessages.CHARACTER_CUSTOMIZED_SUCCESSFULY_MSG);
		} else {
			startMenuHandler.showMessage(GameStaticMessages.CHARACTER_CUSTOMIZATION_FAILD);
		}
		return startMenuHandler;

	}

}
