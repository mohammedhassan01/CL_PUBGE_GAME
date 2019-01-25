package com.auto1.puzzel.menu;

import java.util.Arrays;
import java.util.List;

import com.auto1.puzzel.domain.NonPlayerCharacter;
import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.io.utility.OutputWriter;

public class CLPlayingMenuHandler extends CLMenuHandler<PlayingMenuOptions> implements PlayingMenu {

	public CLPlayingMenuHandler(InputParser inputParser, OutputWriter outputWriter) {
		super(Arrays.asList(PlayingMenuOptions.values()), inputParser, outputWriter);
	}

	@Override
	public void printAllOptions() {
		outputWriter.showMessage(MENU_HEADER_TAIL);
		outputWriter.showMessage("choose action:");
		List<PlayingMenuOptions> optionsList = Arrays.asList(PlayingMenuOptions.values());
		for (int i = 0; i < optionsList.size(); i++) {
			outputWriter.showMessage(
					TAB + optionsList.get(i).getKeyBinding() + DELLIMETER + optionsList.get(i).getDescription());
		}
		outputWriter.showMessage(MENU_HEADER_TAIL);

	}

	@Override
	public PlayingMenuOptions selectOption() {
		return PlayingMenuOptions.fromString(inputParser.readUserInpuAsString(PlayingMenuOptions.allowedKeyBinding()));
	}

	@Override
	public void showEnemyInfo(NonPlayerCharacter enemy) {
		outputWriter.showMessage(MENU_HEADER_TAIL);
		outputWriter.showMessage(enemy.getName());
		outputWriter.showMessage(String.valueOf(enemy.getFightingPower()));
		outputWriter.showMessage(String.valueOf(enemy.getReward()));
		// TODO Complete this method
	}
}
