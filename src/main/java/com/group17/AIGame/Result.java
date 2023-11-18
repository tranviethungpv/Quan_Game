package com.group17.AIGame;

public class Result {
	private Square[] squares;
	public  int[] boundX, boundY;

	public Result(Square[] squares) {
		this.squares = squares;
	}

	public Square[] getSquares() {
		return squares;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
}
