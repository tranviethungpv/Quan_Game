package com.group17.application;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import com.group17.AIGame.Square;

public class BanCo {
	public static int WIDTH = 90, HEIGHT = 90, HEIGHT_QUAN = 180, X = 325, Y = 90;
	public static final int[] boundX = { 25, 50, 35, 35, 60, 30, 60, 50, 75, 25, 60, 30, 55, 65, 27, 37, 52, 33, 73, 51,
			43, 68, 44, 24, 67, 25, 70, 64, 29, 46, 35, 25, 64, 53, 71, 47, 26, 68, 35, 57, 23, 45, 67, 31, 56, 68, 71,
			23, 46, 33, 56, 78, 34, 48, 67, 52, 29, 45, 69, 51, 48, 33, 74, 39, 26, 57, 48, 58, 72, 64, 45, 56 };
	public static final int[] boundY = { 65, 35, 45, 60, 50, 29, 47, 76, 46, 56, 34, 40, 35, 33, 45, 76, 25, 34, 59, 47,
			38, 68, 52, 67, 43, 28, 36, 57, 73, 56, 39, 47, 61, 26, 47, 57, 53, 74, 29, 55, 24, 30, 60, 50, 75, 25, 60,
			30, 55, 65, 27, 37, 52, 33, 73, 51, 43, 68, 44, 24, 67, 25, 70, 64, 29, 46, 35, 25, 64, 46, 33, 56, 78, 34,
			48, 67, 52, 29 };
	private Oco[] ocos;
	private Square[] squares;

	public BanCo(Square[] squares) {
		this.squares = squares;
		createBanco();
	}

	public void createBanco() {
		ocos = new Oco[14];
		for (int i = 1; i < 6; i++) {
			ocos[i] = new Oco(i * WIDTH + X, Y * 3, WIDTH+2, HEIGHT+2, squares[i].getViTri(), squares[i].getValue(),
					squares[i].isQuan(), squares[i].hasQuan());
		}
		ocos[7] = new Oco(X + WIDTH * (5), Y * 4, WIDTH+2, HEIGHT, squares[7].getViTri(), squares[7].getValue(),
				squares[7].isQuan(), squares[7].hasQuan());
		ocos[8] = new Oco(X + WIDTH * (4), Y * 4, WIDTH+2, HEIGHT, squares[8].getViTri(), squares[8].getValue(),
				squares[8].isQuan(), squares[8].hasQuan());
		ocos[9] = new Oco(X + WIDTH * (3), Y * 4, WIDTH+2, HEIGHT, squares[9].getViTri(), squares[9].getValue(),
				squares[9].isQuan(), squares[9].hasQuan());
		ocos[10] = new Oco(X + WIDTH * (2), Y * 4, WIDTH+2, HEIGHT, squares[10].getViTri(), squares[10].getValue(),
				squares[10].isQuan(), squares[10].hasQuan());
		ocos[11] = new Oco(X + WIDTH * (1), Y * 4, WIDTH+2, HEIGHT, squares[11].getViTri(), squares[11].getValue(),
				squares[11].isQuan(), squares[11].hasQuan());
		ocos[0] = new Oco(X, Y * 3, WIDTH+2, HEIGHT_QUAN, squares[0].getViTri(), squares[0].getValue(),
				squares[0].isQuan(), squares[0].hasQuan());
		ocos[6] = new Oco(WIDTH * 6 + X, Y * 3, WIDTH, HEIGHT_QUAN, squares[6].getViTri(), squares[6].getValue(),
				squares[6].isQuan(), squares[6].hasQuan());
		ocos[12] = new Oco(WIDTH * 3 + X, Y * 2 - 20, WIDTH, HEIGHT, squares[12].getViTri(), squares[12].getValue(),
				squares[12].isQuan(), squares[12].hasQuan());
		ocos[13] = new Oco(WIDTH * 3 + X, 470, WIDTH, HEIGHT, squares[13].getViTri(), squares[13].getValue(),
				squares[13].isQuan(), squares[13].hasQuan());
	}

	public void draw(Graphics2D g2d) {
		for (int i = 0; i < ocos.length; i++) {
			ocos[i].draw(g2d);
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < ocos.length; i++) {
			ocos[i].mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < ocos.length; i++) {
			ocos[i].mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < ocos.length; i++) {
			ocos[i].mousePressed(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
		for (int i = 0; i < ocos.length; i++) {
			ocos[i].mouseReleased(e);
		}
	}

	public void mouseDragged(MouseEvent e) {
		for (int i = 0; i < ocos.length; i++) {
			ocos[i].mouseDragged(e);
		}
	}

	public void mouseMoved(MouseEvent e) {
		mouseEntered(e);
		mouseExited(e);
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
}
