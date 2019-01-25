package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.GameStaticMessages;
import com.auto1.puzzel.domain.NonPlayerCharacter;
import com.auto1.puzzel.engine.FightingEngine;
import com.auto1.puzzel.exception.FightingBussinesException;

public class FightEnemyDecisionHandler extends UserDecisionExecutor<Game> {

	public NonPlayerCharacter getEnemy() {
		return enemy;
	}

	private NonPlayerCharacter enemy;

	public FightEnemyDecisionHandler(Game object) {
		super(object);
	}

	@Override
	public boolean preProcess() {
		Coordinates playerCoordinates = Game.getPlayer().getCoordinates();
		enemy = Game.getPlayeZone().getCell(playerCoordinates).getFighter();
		if (enemy != null && enemy.isLive()) {
			outputWriter.showMessage(GameStaticMessages.FIGHTING_INTRO_MSG);
			outputWriter.showMessage(enemy.getCharacterInfo());
		} else {
			if (enemy != null && !enemy.isLive()) {
				throw new FightingBussinesException(GameStaticMessages.ENEMY_IS_DIED_TO_FIGH);
			} else {
				throw new FightingBussinesException(GameStaticMessages.NO_ENEMY_TO_FIGHT_MSG);
			}
		}

		return true;
	}

	@Override
	public boolean process() {
		new FightingEngine(enemy, Game).fight();
		return true;
	}

	@Override
	public Object postProcess() {
		return playingMenuHandler;
	}


}
