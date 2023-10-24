package com.group17.AIGame;

import java.awt.Graphics2D;
import java.util.Random;

public class Result {
	private Square[] squares;
	public  int[] boundX, boundY;

	public Result(Square[] squares) {
		this.squares = squares;
		boundX = new int[50];
		boundY = new int[50];
		Random r = new Random();
		for (int i = 0; i < boundX.length; i++) {
			boundX[i] = r.nextInt(30)+10;
		}
		for (int i = 0; i < boundY.length; i++) {
			boundY[i] = r.nextInt(30)+10;
		}
	}

	public Square[] getSquares() {
		return squares;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
	
	public void print() {
		System.out.print("  |");
		for (int i = 1; i < 6; i++) {
			System.out.print(squares[i].getValue() + "|");
		}
		System.out.println();
		System.out.print(squares[0].getValue() + "|-|-|-|-|-|");
		System.out.print(squares[6].getValue());
		System.out.println();
		System.out.print("  |");
		for (int i = 12 - 1; i >= 7; i--) {
			System.out.print(squares[i].getValue() + "|");
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < squares.length; i++) {
			if (i % 6 != 0 && i < 6) {
				g2d.drawRect(i * 50, 100, 50, 50);
				for (int j = 0; j < squares[i].getValue(); j++) {
					g2d.drawOval(i* 50 + boundX[j], 100 + boundY[j], 7, 5);
				}
			} else if (i % 6 != 0 && i > 6 && i < 12) {
				g2d.drawRect((i-6)*50, 150, 50, 50);
				for (int j = 0; j < squares[i].getValue(); j++) {
					g2d.drawOval((i-6)* 50 + boundX[j], 150 + boundY[j], 7, 5);
				}
			} else if (i == 0) {
				g2d.drawRect(0, 100, 50, 100);
				for (int j = 0; j < squares[i].getValue(); j++) {
					g2d.drawOval(0 + boundX[j], 100 + boundY[j] + 25, 7, 5);
				}
			} else if (i == 6) {
				g2d.drawRect(300, 100, 50,100 );
				for (int j = 0; j < squares[i].getValue(); j++) {
					g2d.drawOval(300 + boundX[j], 100 + boundY[j] + 25, 7, 5);
				}
			} else if (i == 12) {
				g2d.drawRect(150, 30, 50, 50);
				for (int j = 0; j < squares[i].getValue(); j++) {
					g2d.drawOval(150 + boundX[j], 30 + boundY[j], 7, 5);
				}
			} else if (i == 13) {
				g2d.drawRect(150, 220, 50, 50);
				for (int j = 0; j < squares[i].getValue(); j++) {
					g2d.drawOval(150 + boundX[j], 220 + boundY[j], 7, 5);
				}
			}
		}
	}
}
