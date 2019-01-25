package com.auto1.puzzel.io.utility;

import com.auto1.puzzel.domain.Game;

public class GameResourceHandler extends SerializedRroviderHandler<Game> implements GameResourcePorvider {
	private Game game;
	private String fileName;

	public GameResourceHandler(Game game, String fileName) {
		this.game = game;
		this.fileName = fileName;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	protected String getFileName() {
		return this.fileName;
	}

	@Override
	protected Game getResource() {
		return getGame();
	}

}
