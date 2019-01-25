package com.auto1.puzzel.io.utility;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.auto1.puzzel.exception.UserInputException;

public class InputParser {
	private static final int MAX_RETRY = 3;

	private final OutputWriter outputWriter;
	private final Scanner scanner;

	public InputParser(OutputWriter outputWriter, InputStream source) {
		this.outputWriter = outputWriter;
		this.scanner = new Scanner(source);
	}

	public String readUserInputAsString(String message) {
		outputWriter.showMessage(message);
		return readUserInputAsString();
	}

	public String readUserInputAsString() {
		return scanner.nextLine();
	}

	public String readUserInpuAsString(List<String> allowed) {
		for (int i = 1; i <= MAX_RETRY; i++) {
			try {
				return readStringMatchList(allowed);
			} catch (Exception e) {
				if (MAX_RETRY == i) {
					throw e;
				} else {
					outputWriter.showMessage(e.getMessage());
				}
			}
		}
		return null;
	}

	private String readStringMatchList(List<String> allowed) throws UserInputException {
		String userInput = readUserInputAsString();
		allowed.replaceAll(String::toUpperCase);
		if (allowed.contains(userInput.toUpperCase())) {
			return userInput;
		} else {
			throw new UserInputException("unvalid User Input, please enter valid input");
		}
	}

	public int tryReadingMenuChoice(String message, int optionsSize) {
		outputWriter.showMessage(message);
		return tryReadingMenuChoice(optionsSize);
	}

	public int tryReadingMenuChoice(int optionsSize) {
		return tryReadingInputAsInt(optionsSize);
	}

	public int tryReadingInputAsInt(String message) {
		outputWriter.showMessage(message);
		return tryReadingInputAsInt();
	}

	public int tryReadingInputAsInt() {
		return tryReadingInputAsInt(Integer.MAX_VALUE);
	}

	public int tryReadingInputAsInt(String message, int optionsSize) {
		outputWriter.showMessage(message);
		return tryReadingInputAsInt(optionsSize);
	}

	public int tryReadingInputAsInt(int optionsSize) {
		for (int i = 1; i <= MAX_RETRY; i++) {
			try {
				return readInt(optionsSize);
			} catch (Exception e) {
				if (MAX_RETRY == i) {
					throw e;
				} else {
					outputWriter.showMessage(e.getMessage());
				}
			}
		}

		return -1;
	}

	int readInt(int optionsSize) {
		try {
			int result = Integer.parseInt(scanner.nextLine());
			if (NumbersUtilis.isNotWithinZeroAndMaxExclusive(result, optionsSize)) {
				throw new UserInputException(
						"not valid input. Value must be between  0 and " + String.valueOf(optionsSize - 1));
			} else {
				return result;
			}
		} catch (NumberFormatException | InputMismatchException e) {
			throw new UserInputException("your input not number. Please try again.");
		}
	}

}
