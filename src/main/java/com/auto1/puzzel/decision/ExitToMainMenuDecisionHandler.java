package com.auto1.puzzel.decision;

import java.util.ArrayList;
import java.util.List;

import com.auto1.puzzel.domain.Game;
import com.auto1.puzzel.domain.GameStaticMessages;

public class ExitToMainMenuDecisionHandler extends UserDecisionExecutor<Game> {

	private boolean saveBeforeExit = false;

	public ExitToMainMenuDecisionHandler(Game object) {
		super(object);
	}

	@Override
	public boolean preProcess() {
		List<String> allowed = new ArrayList<>();
		allowed.add("Y");
		allowed.add("N");
		outputWriter.showMessage(GameStaticMessages.SAVE_BEFORE_EXIT);
		String userAction = inputParser.readUserInpuAsString(allowed);
		if (userAction.equals("Y")) {
			saveBeforeExit = true;
		}
		return true;
	}

	@Override
	public boolean process() {
		if (saveBeforeExit) {
			SaveGameDecisionHandler saveGameDecisionHandler = new SaveGameDecisionHandler(Game);
			saveGameDecisionHandler.preProcess();
			saveGameDecisionHandler.process();
		}
		return true;
	}

	@Override
	public Object postProcess() {
		return startMenuHandler;
	}

}
