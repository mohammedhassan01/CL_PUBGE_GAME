package com.auto1.puzzel;


import com.auto1.puzzel.decision.UserDecisionHandlerFactoryProducer;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.GameStaticMessages;
import com.auto1.puzzel.engine.GameEngine;
import com.auto1.puzzel.exception.UserInputException;
import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.io.utility.OutputWriter;
import com.auto1.puzzel.menu.CLPlayingMenuHandler;
import com.auto1.puzzel.menu.CLStartMenuHandler;
import com.auto1.puzzel.menu.StartMenuOptions;

public class GameLuncher {
	public static void main(String[] args) {
		OutputWriter output = new OutputWriter(System.out);
		InputParser input = new InputParser(output, System.in);

		output.showMessage(GameStaticMessages.GAME_INTRO);
		CLStartMenuHandler startMenuHandler = new CLStartMenuHandler(input, output);
		startMenuHandler.printAllOptions();
		try {
			
			Object option = startMenuHandler.selectOption();

			GameEngine gameEngine = new GameEngine();
			Game game = new Game(gameEngine.getPlayeZone(), gameEngine.getPlayer());

			while (option != StartMenuOptions.EXIT) {

				Object object = UserDecisionHandlerFactoryProducer.getUserDecisionHandlerFactory(game, option)
						.getUserDecisionHandler(option).execute();
				if (object instanceof CLStartMenuHandler) {
					startMenuHandler = (CLStartMenuHandler) object;
					option = startMenuHandler.showMenuToSelect();
				} else if (object instanceof CLPlayingMenuHandler) {
					CLPlayingMenuHandler playingMenuHandler = (CLPlayingMenuHandler) object;
					option = playingMenuHandler.showMenuToSelect();
				}
			}

		} catch (UserInputException e) {
			output.showMessage(GameStaticMessages.NO_VALID_INPUT_GOOD_BYE);
		}
	}
}
