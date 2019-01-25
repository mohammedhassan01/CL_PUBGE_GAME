package com.auto1.puzzel.exception;

public class GameBussinesException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public GameBussinesException(String message) {
        super(message);
    }
}
