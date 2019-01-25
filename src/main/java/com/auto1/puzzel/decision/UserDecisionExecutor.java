package com.auto1.puzzel.decision;

import com.auto1.puzzel.context.ApplicationContext;
import com.auto1.puzzel.exception.GameBussinesException;
import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.io.utility.OutputWriter;
import com.auto1.puzzel.menu.CLPlayingMenuHandler;
import com.auto1.puzzel.menu.CLStartMenuHandler;

public abstract class UserDecisionExecutor<T> implements OptionClickable, Executable {
	protected T Game;
	protected CLStartMenuHandler startMenuHandler;
	protected CLPlayingMenuHandler playingMenuHandler;
	protected final OutputWriter outputWriter;
	protected final InputParser inputParser;

	public UserDecisionExecutor(T object) {
		this.Game = object;
		this.outputWriter = (OutputWriter) ApplicationContext.context.get(OutputWriter.class);
		this.inputParser = (InputParser) ApplicationContext.context.get(InputParser.class);
		this.startMenuHandler = (CLStartMenuHandler) ApplicationContext.context.get(CLStartMenuHandler.class);
		this.playingMenuHandler = (CLPlayingMenuHandler) ApplicationContext.context.get(CLPlayingMenuHandler.class);
	}

	@Override
	public boolean preProcess() {
		return true;
	}

	@Override
	public Object execute() {
		try {
		boolean valid = preProcess();
		Object object = null;
		if (valid) {
			valid = process();
		}
		if (valid) {
			object = postProcess();
		}
		return object;
		}catch(GameBussinesException e) {
			return handleException(e);
		}
	}

	protected  Object handleException(GameBussinesException e) {
		outputWriter.showMessage(e.getMessage());
		return postProcess();
	}

}
