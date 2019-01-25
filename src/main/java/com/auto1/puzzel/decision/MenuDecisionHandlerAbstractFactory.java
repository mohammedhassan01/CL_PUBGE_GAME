package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Game;

public abstract class MenuDecisionHandlerAbstractFactory {
	protected Game game;
	protected Object decision;
	
	public MenuDecisionHandlerAbstractFactory(Game game, Object object)
	{
		this.decision = object;
		this.game = game;
	}
	public abstract UserDecisionExecutor<Game> getUserDecisionHandler(Object decision);
}
