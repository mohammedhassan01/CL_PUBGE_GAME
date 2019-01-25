package com.auto1.puzzel.context;

import java.util.HashMap;
import java.util.Map;

import com.auto1.puzzel.configration.PlayerDefaultConfigurationBuilder;
import com.auto1.puzzel.configration.PlayerConfiguration.PlayerConfigurationBuilder;
import com.auto1.puzzel.decision.CharacterCustomizationHandler;
import com.auto1.puzzel.engine.GameEngine;
import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.io.utility.OutputWriter;
import com.auto1.puzzel.menu.CLPlayingMenuHandler;
import com.auto1.puzzel.menu.CLStartMenuHandler;
import com.auto1.puzzel.menu.PlayingMenu;

public class ApplicationContext {
	public static final Map<Class, Object> context = new HashMap<>();
	static {
		applicationContextLoader();
	}

	private ApplicationContext() {
	}

	private static InputParser getInputRarser() {
		return new InputParser(getOutputWriter(), System.in);
	}

	private static OutputWriter getOutputWriter() {
		return new OutputWriter(System.out);
	}

	private static PlayingMenu getPlayingMenu() {
		return new CLPlayingMenuHandler(getInputRarser(), getOutputWriter());
	}

	private static PlayerConfigurationBuilder getPlayConfigurationBuilder() {
		return new PlayerConfigurationBuilder();
	}

	private static PlayerDefaultConfigurationBuilder getPlayerConfigurationDefaultBuilder() {
		return new PlayerDefaultConfigurationBuilder();
	}

	private static CharacterCustomizationHandler getCharacterCustomizationHandler() {
		return new CharacterCustomizationHandler();
	}

	private static CLStartMenuHandler getStartMenuHandler() {
		return new CLStartMenuHandler((InputParser) context.get(InputParser.class),
				(OutputWriter) context.get(OutputWriter.class));
	}

	private static CLPlayingMenuHandler getClPlayingMenuHandler() {
		return new CLPlayingMenuHandler((InputParser) context.get(InputParser.class),
				(OutputWriter) context.get(OutputWriter.class));
	}
	private static GameEngine getGameEngine()
	{
		return new GameEngine();
	}

	private static void applicationContextLoader() {
		context.put(getInputRarser().getClass(), getInputRarser());
		context.put(getOutputWriter().getClass(), getOutputWriter());
		context.put(getPlayingMenu().getClass(), getPlayingMenu());
		context.put(getPlayConfigurationBuilder().getClass(), getPlayConfigurationBuilder());
		context.put(getPlayerConfigurationDefaultBuilder().getClass(), getPlayerConfigurationDefaultBuilder());
		context.put(getCharacterCustomizationHandler().getClass(), getCharacterCustomizationHandler());
		context.put(getStartMenuHandler().getClass(), getStartMenuHandler());
		context.put(getClPlayingMenuHandler().getClass(), getClPlayingMenuHandler());
		context.put(getGameEngine().getClass(), getGameEngine());
	}
}
