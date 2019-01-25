package com.auto1.puzzel.menu;

public enum StartMenuOptions {
	START("0", "Start the game"), CREATE_CHARACTER("1", "Cutomize your Character"), LOAD("2", "Load a saved gamed"),
	EXIT("3", "Leave the game");

	private final String keyBinding;
	private final String description;


	 StartMenuOptions(String keyBinding, String description) {
		this.keyBinding = keyBinding;
		this.description = description;
	}

	@Override
	public String toString() {
		return  description;
	}
	
}
