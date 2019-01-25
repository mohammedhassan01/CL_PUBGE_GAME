package com.auto1.puzzel.menu;

import java.util.Arrays;

import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.io.utility.OutputWriter;

public class CLStartMenuHandler extends CLMenuHandler<StartMenuOptions> {

	public CLStartMenuHandler(InputParser inputParser,
			OutputWriter outputWriter) {
		super(Arrays.asList(StartMenuOptions.values()), inputParser, outputWriter);
	}

}
