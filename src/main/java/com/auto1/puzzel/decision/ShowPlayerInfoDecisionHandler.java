package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.menu.BaseOneOptionMenu;
import com.auto1.puzzel.menu.PlayingMenuOptions;
import com.auto1.puzzel.viwer.CLGameViewBuilder;

public class ShowPlayerInfoDecisionHandler extends UserDecisionExecutor<Game> {

	private CLGameViewBuilder clGameViewBuilder; 
	public ShowPlayerInfoDecisionHandler(Game game) {
		super(game);
		clGameViewBuilder = new CLGameViewBuilder(game.getPlayeZone(), game.getPlayer());
	}

	@Override
	public boolean process() {
		outputWriter.showMessage(Game.getPlayer().getCharacterInfo());
		return true ;
	}

	@Override
	public BaseOneOptionMenu<PlayingMenuOptions> postProcess() {
		outputWriter.showMessage(clGameViewBuilder.viewMap());
		return playingMenuHandler;

	}

}
