package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.menu.PlayingMenuOptions;
import com.auto1.puzzel.menu.StartMenuOptions;

public class UserDecisionHandlerFactoryProducer {
	public static MenuDecisionHandlerAbstractFactory getUserDecisionHandlerFactory (Game  game, Object userDecision) {
		if(userDecision instanceof StartMenuOptions)
		{
			return new StartMenuDecisionHandlerFactory(game, userDecision);
		}
		if(userDecision instanceof PlayingMenuOptions)
		{
			return new PlayingMenuDecisionHandlerFactory(game, userDecision);
		}
		return null;
		
		
	}
}
