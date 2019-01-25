package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.engine.GameEngine;
import com.auto1.puzzel.menu.BaseOneOptionMenu;
import com.auto1.puzzel.menu.PlayingMenuOptions;
import com.auto1.puzzel.viwer.CLGameViewBuilder;

public class StartGameDecisionHandler extends UserDecisionExecutor<Game> {

	private CLGameViewBuilder clGameViewBuilder; 
	public StartGameDecisionHandler(Game game) {
		super(game);
		
	}
	
	@Override
	public boolean preProcess() {
		GameEngine gameEngine = new GameEngine();
		Game.setPlayeZone(gameEngine.getPlayeZone());
		return true;
	}

	@Override
	public boolean process() {
		clGameViewBuilder = new CLGameViewBuilder(Game.getPlayeZone(), Game.getPlayer());
		outputWriter.showMessage(clGameViewBuilder.viewMap());
		return true ;
	}

	@Override
	public BaseOneOptionMenu<PlayingMenuOptions> postProcess() {
		return playingMenuHandler;

	}

}
