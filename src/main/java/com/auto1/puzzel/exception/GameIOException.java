package com.auto1.puzzel.exception;

import java.io.IOException;

public class GameIOException extends IOException {
	private static final long serialVersionUID = 1L;

	public GameIOException(String msg) {
		super(msg);
	}

	public GameIOException() {
		super();
	}

}
