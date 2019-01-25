package com.auto1.puzzel.domain;

public enum RealmCellType {
	EMPTY("Empty", " "),
	ENEMY("Fighter", "E"),
	PLAYER("Player","Y"),
	FIGHTING("Fighter died","#"),
	NPC_DEAD("Fighter died","D"), ENERGY("ENERGY CELL", "*");
	
	
	private final String description;
	private final String letter;

	RealmCellType(String description, String letter) {
	        this.description = description;
	        this.letter = letter;
	    }

	public String getDescription() {
		return description;
	}

	public String getGridLetter() {
		return letter;
	}
	
}
