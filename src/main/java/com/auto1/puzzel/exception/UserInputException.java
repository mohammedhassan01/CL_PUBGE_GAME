package com.auto1.puzzel.exception;

import com.auto1.puzzel.domain.GameStaticMessages;

public class UserInputException extends GameBussinesException {


	
	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MSG = GameStaticMessages.NO_VALID_INPUT_GOOD_BYE;

    public UserInputException(String message) {
        super(message);
    }

    public UserInputException() {
        super(DEFAULT_MSG);
    }

   
}
