package com.auto1.puzzel.decision;

import com.auto1.puzzel.domain.Coordinates;
import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.GameStaticMessages;
import com.auto1.puzzel.domain.RealmCell;
import com.auto1.puzzel.domain.RealmCellType;
import com.auto1.puzzel.exception.GameOutOfZoneException;
import com.auto1.puzzel.io.utility.NumbersUtilis;
import com.auto1.puzzel.viwer.CLGameViewBuilder;

public class ExplorDecisionHandler extends UserDecisionExecutor<Game> {

	protected Coordinates newPlayCoordinates;
	protected boolean isValidCoordinates = false;
	private CLGameViewBuilder clGameViewBuilder;
	private RealmCell newPlayerCell;

	public ExplorDecisionHandler(Game game, Coordinates newCoordinates) {
		super(game);
		clGameViewBuilder = new CLGameViewBuilder(game.getPlayeZone(), game.getPlayer());
		this.newPlayCoordinates = newCoordinates;
		newPlayerCell = Game.getPlayeZone().getCell(newPlayCoordinates);
	}

	// TODO make this type as strategy interface
	private void consumeEnergyIfExist() {

		if (newPlayerCell.isHasEnergy()) {
			Game.getPlayer().getExperience().addStars(1);
			newPlayerCell.setHasEnergy(false);
			newPlayerCell.setType(RealmCellType.EMPTY);
		}
	}

	public RealmCell getNewPlayerCell() {
		return newPlayerCell;
	}

	public void setPlayerNewCell(RealmCell newPlayerCell) {
		this.newPlayerCell = newPlayerCell;
	}

	public Coordinates getNewPlayCoordinates() {
		return newPlayCoordinates;
	}

	public void setNewPlayCoordinates(Coordinates newPlayCoordinates) {
		this.newPlayCoordinates = newPlayCoordinates;
	}

	boolean isValidCoordinates() {

		int maxX = Game.getPlayeZone().getYardMapX();
		int maxY = Game.getPlayeZone().getYardMapY();
		boolean validXaxise = NumbersUtilis.isWithinRangeExclusive(newPlayCoordinates.getX(), 0, maxX);
		boolean validYaxise = NumbersUtilis.isWithinRangeExclusive(newPlayCoordinates.getY(), 0, maxY);

		return validXaxise && validYaxise;

	}

	@Override
	public boolean preProcess() {
		if (!isValidCoordinates()) {
			isValidCoordinates = false;
			throw new GameOutOfZoneException(GameStaticMessages.CANT_MOVE_OUT_OF_ZONE);
		}
		isValidCoordinates = true;
		return true;

	}

	@Override
	public boolean process() {
		if (isValidCoordinates) {
			consumeEnergyIfExist();
			Game.getPlayer().setCoordinates(newPlayCoordinates);
		}
		return true;
	}

	@Override
	public Object postProcess() {
		outputWriter.showMessage(clGameViewBuilder.viewMap());
		return playingMenuHandler;
	}

}
