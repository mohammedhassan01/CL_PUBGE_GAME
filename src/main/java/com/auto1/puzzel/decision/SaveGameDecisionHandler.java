package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.exception.GameIOException;
import com.auto1.puzzel.io.utility.GameResourceHandler;

public class SaveGameDecisionHandler extends UserDecisionExecutor<Game> {
	private String saveFileName ;
	public SaveGameDecisionHandler(Game game) {
		super(game);
	}

	@Override
	public boolean preProcess() {
		saveFileName = inputParser.readUserInputAsString("Please Enter Game Name To Save:");
		return true;
	}

	@Override
	public boolean process() {
		GameResourceHandler gameResourceHandlerHandler =  new GameResourceHandler(Game, saveFileName);
		try {
			gameResourceHandlerHandler.Save();
		} catch (GameIOException e) {
			outputWriter.showMessage(e.getMessage());
		}
		return true;
	}

	@Override
	public Object postProcess() {
		return playingMenuHandler;
	}

}
