package com.auto1.puzzel.menu;

import java.util.ArrayList;
import java.util.List;

public enum PlayingMenuOptions {
	EXPLORE_UP("W", "Go North"), EXPLORE_DOWN("S", "Go South"), EXPLORE_LEFT("A", "Go West"),
	EXPLORE_RIGHT("D", "Go East"), ATTACK("T", "Attack Enemy"), SHOW_MY_INFO("I", "Show my health points and info"),
	SAVE("1", "Save the game"), EXIT("0", "Exit to main menu");

	private final String keyBinding;
	private final String description;

	PlayingMenuOptions(String keyBinding, String description) {
		this.keyBinding = keyBinding;
		this.description = description;
	}

	public String getKeyBinding() {
		return keyBinding;
	}

	public String getDescription() {
		return description;
	}

	public static PlayingMenuOptions fromString(String input) {
		if (input == null) {
			return null;
		}

		for (PlayingMenuOptions item : PlayingMenuOptions.values()) {
			if (item.keyBinding.equalsIgnoreCase(input)) {
				return item;
			}
		}

		return null;
	}
	
	public static List<String> allowedKeyBinding()
	{
		List<String> keyList= new ArrayList<>();
		keyList.add("W");
		keyList.add("S");
		keyList.add("A");
		keyList.add("D");
		keyList.add("T");
		keyList.add("I");
		keyList.add("1");
		keyList.add("0");
		return keyList;
	}

	
}
