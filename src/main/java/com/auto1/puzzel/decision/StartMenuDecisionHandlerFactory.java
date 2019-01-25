package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.menu.StartMenuOptions;

public class StartMenuDecisionHandlerFactory extends MenuDecisionHandlerAbstractFactory {

	public StartMenuDecisionHandlerFactory(Game game, Object object) {
		super(game, object);
	}

	@Override
	public UserDecisionExecutor<Game> getUserDecisionHandler(Object decision) {
		if (decision instanceof StartMenuOptions) {
			StartMenuOptions userDecision = (StartMenuOptions) decision;
			if (userDecision == StartMenuOptions.START) {
				return new StartGameDecisionHandler(game);
			}
			if (userDecision == StartMenuOptions.CREATE_CHARACTER) {
				return new CreateCharacterDecisonHandler(game);
			}
			if (userDecision == StartMenuOptions.LOAD) {
				return new ResumeGameDecisionHandler(game);
			}
			if (userDecision == StartMenuOptions.EXIT) {
				return null;
			}

		}
		return null;
	}

}
