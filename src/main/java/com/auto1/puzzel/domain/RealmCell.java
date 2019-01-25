package com.auto1.puzzel.domain;

import java.io.Serializable;

public class RealmCell implements Serializable{

	private static final long serialVersionUID = 1L;
	private RealmCellType type;
	private final Coordinates coordinates;
	private NonPlayerCharacter fighter;
	private boolean hasEnergy;

	public boolean isHasEnergy() {
		return hasEnergy;
	}

	public void setHasEnergy(boolean hasEnergy) {
		this.hasEnergy = hasEnergy;
	}

	public RealmCell(Coordinates coordinates) {
		this.type = RealmCellType.EMPTY;
		this.coordinates = coordinates;
	}
	public RealmCell(Coordinates coordinates, boolean hasEnergy) {
		this.type = RealmCellType.ENERGY;
		this.hasEnergy = hasEnergy;
		this.coordinates = coordinates;
	}

	public RealmCell(Coordinates coordinates, NonPlayerCharacter fighter) {
		this(coordinates);
		this.fighter = fighter;
		this.type = fighter.getlocationType();

	}

	public RealmCellType getType() {
		if (fighter != null && !fighter.isLive()) {
			this.type = RealmCellType.NPC_DEAD;
		}
		return this.type;
	}

	public void setType(RealmCellType type) {
		this.type = type;
	}

	public NonPlayerCharacter getFighter() {
		return fighter;
	}

	public void setFighter(NonPlayerCharacter fighter) {
		this.fighter = fighter;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
	@Override
	public String toString() {
		return type.getGridLetter();
	}

}
