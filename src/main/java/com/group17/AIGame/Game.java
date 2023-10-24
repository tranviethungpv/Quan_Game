package com.group17.AIGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Board board = new Board();
	private Scanner scanner;
	private Minimax minimax;
	private Square[] squares;
	private ArrayList<Result> results;

	public Game() {
		results = new ArrayList<>();
		scanner = new Scanner(System.in);
		minimax = new Minimax();
		squares = board.getSquares();
	}

	public void play() {
		int player = 2;
		while (!board.finish()) {
			if (player == 1) {
				if (board.kiemTraHetQuan(player)) {
					System.out.println("Computer rải quân");
					board.raiQuan(player);
				}
			} else {
				if (board.kiemTraHetQuan(player)) {
					System.out.println("Người chơi rải quân");
					board.raiQuan(player);
				}
			}

			board.setResults(new ArrayList<>());
			System.out.println("Điểm computer: " + squares[12].getValue());
			System.out.println("Điểm người chơi: " + squares[13].getValue());
			board.printBanCo();
			int viTri = 0;
			if (player == 2) {
				System.out.print("Người chơi 2 chọn [Vị trí] = ");
				String s = scanner.nextLine();
				try {
					viTri = Integer.parseInt(s.substring(1, s.length()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
					continue;
				}
				if (!board.kiemTra(viTri, player)) {
					System.err.println("Người chơi 2 không được chọn ô này");
					continue;
				}
				if (s.substring(0, 1).equals("l")) {
					int score = board.eatLeft(board.left(viTri));
					board.setScorePlayer(score);
				} else if (s.substring(0, 1).equals("r")) {
					int score = board.eatRight(board.right(viTri));
					board.setScorePlayer(score);
				} else {
					continue;
				}
			} else {
				int[] a = new int[3];
				int bestLocation = 0;
				int bestScore = Integer.MIN_VALUE;
				int huong = 0;
				a = minimax.minimax(adapter(board), 5, 1);
				if (a[0] > bestScore) {
					bestScore = a[0];
					bestLocation = a[1];
					huong = a[2];
				}
				System.out.println("Vi tri " + bestLocation + ", Huong " + huong);
				int score = 0;
				if (a[2] == 1) {
					score = board.eatLeft(board.left(a[1]));
				} else {
					score = board.eatRight(board.right(a[1]));
				}
				board.setScoreComputer(score);
			}

			results = board.getResults();
			printResult(results);

			if (player == 1) {
				player = 2;
			} else {
				player = 1;
			}
		}
		board.printBanCo();
		board.addScore(1);
		board.addScore(2);
		System.out.println("Điểm computer: " + squares[12].getValue());
		System.out.println("Điểm người chơi: " + squares[13].getValue());
		if (squares[12].getValue() > squares[13].getValue()) {
			System.out.println("Computer thắng");
		} else if (squares[12].getValue() < squares[13].getValue()) {
			System.out.println("Người chơi thắng");
		} else {
			System.out.println("Game hòa");
		}
		board.printBanCo();
	}

	public void printResult(ArrayList<Result> results) {
		for (Result result : results) {
			result.print();
		}
	}
	
	public Board adapter(Board board) {
		Square[] squares = board.getSquares();
		Square[] s = new Square[squares.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Square(i, squares[i].getValue(), squares[i].isQuan());
		}
		Board b = new Board();
		b.setSquares(s);
		return b;
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
