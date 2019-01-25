package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.exception.GameIOException;
import com.auto1.puzzel.io.utility.GameResourceHandler;

public class ResumeGameDecisionHandler extends UserDecisionExecutor<Game> {
	public ResumeGameDecisionHandler(Game object) {
		super(object);
	}

	private String loadFileName;
	private Game loadedGame;
	private boolean gameLoaded = false;
	private StartGameDecisionHandler startGameDecisionHandler;

	@Override
	public boolean preProcess() {
		loadFileName = inputParser.readUserInputAsString("Please Enter Game Name To Load:");
		return true;

	}

	@Override
	public boolean process() {
		GameResourceHandler gameResourceHandlerHandler = new GameResourceHandler(Game, loadFileName);
		try {
			loadedGame = gameResourceHandlerHandler.Load();
			Game.setPlayeZone(loadedGame.getPlayeZone());
			Game.setPlayer(loadedGame.getPlayer());
			startGameDecisionHandler = new StartGameDecisionHandler(Game);
			startGameDecisionHandler.process();
			gameLoaded = true;
		} catch (GameIOException e) {
			gameLoaded = false;
			outputWriter.showMessage(e.getMessage());
		}
		return true;
	}

	@Override
	public Object postProcess() {
		if (gameLoaded) {
			return startGameDecisionHandler.postProcess();
		}else {
			return startMenuHandler;
		}
	}

}
