package com.auto1.puzzel.menu;

import java.util.List;

import com.auto1.puzzel.io.utility.InputParser;
import com.auto1.puzzel.io.utility.OutputWriter;

public class CLMenuHandler<OptionType> implements BaseOneOptionMenu<OptionType> {
	protected static final String TAB = "\t";
	protected static final String DELLIMETER = ".";
	protected static final String MENU_HEADER_TAIL = "+++++++++++++++++++++++++++++++++++++++++++++++";
	protected final InputParser inputParser;
	protected final OutputWriter outputWriter;
	protected List<OptionType> options;
	
	public  CLMenuHandler(List<OptionType> optionsList, InputParser inputParser, OutputWriter outputWriter) {
		this.options = optionsList;
		this.inputParser = inputParser;
		this.outputWriter = outputWriter;
	}
	
	@Override
	public void showMessage(String message) {
		outputWriter.showMessage(message);
	}

	@Override
	public void printAllOptionsWithHeader(String message) {
		outputWriter.showMessage(MENU_HEADER_TAIL);
		printAllOptions();
	}

	@Override
	public void printAllOptions() {
		outputWriter.showMessage(MENU_HEADER_TAIL);
		outputWriter.showMessage("choose action:");
		for(int i = 0 ; i < options.size() ; i++)
		{
			outputWriter.showMessage(TAB + String.valueOf(i) + DELLIMETER + options.get(i).toString());
		}
		outputWriter.showMessage(MENU_HEADER_TAIL);
	}

	@Override
	public OptionType selectOption() {
		return options.get(inputParser.tryReadingMenuChoice(options.size()));
	}

	@Override
	public OptionType showMenuToSelect() {
		
		printAllOptions();
		return selectOption();
		
	}

}
