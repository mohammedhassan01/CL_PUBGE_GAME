package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.menu.PlayingMenuOptions;

public class PlayingMenuDecisionHandlerFactory extends MenuDecisionHandlerAbstractFactory {
	

	public PlayingMenuDecisionHandlerFactory(Game game, Object obj) {
		super(game, obj);
	}

	@Override
	public UserDecisionExecutor<Game> getUserDecisionHandler(Object decision) {

		Coordinates currentPlayerCoordinates = game.getPlayer().getCoordinates();
		Coordinates newPlayerCoordinates = null;

		if (decision == PlayingMenuOptions.EXPLORE_UP) {
			newPlayerCoordinates = currentPlayerCoordinates.up();
			return new ExplorDecisionHandler(game, newPlayerCoordinates);
		}
		if (decision == PlayingMenuOptions.EXPLORE_DOWN) {
			newPlayerCoordinates = currentPlayerCoordinates.down();
			return new ExplorDecisionHandler(game, newPlayerCoordinates);
		}
		if (decision == PlayingMenuOptions.EXPLORE_RIGHT) {
			newPlayerCoordinates = currentPlayerCoordinates.right();
			return new ExplorDecisionHandler(game, newPlayerCoordinates);
		}
		if (decision == PlayingMenuOptions.EXPLORE_LEFT) {
			newPlayerCoordinates = currentPlayerCoordinates.left();
			return new ExplorDecisionHandler(game, newPlayerCoordinates);
		}
		if (decision == PlayingMenuOptions.ATTACK) {
			return new FightEnemyDecisionHandler(game);
		}
		if (decision == PlayingMenuOptions.SHOW_MY_INFO) {
			return new ShowPlayerInfoDecisionHandler(game);
		}
		if (decision == PlayingMenuOptions.SAVE) {
			return new SaveGameDecisionHandler(game);
		}
		if (decision == PlayingMenuOptions.EXIT) {
			return new ExitToMainMenuDecisionHandler(game);
		}

		return null;
	}

}
