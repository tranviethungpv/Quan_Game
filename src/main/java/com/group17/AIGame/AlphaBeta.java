package com.group17.AIGame;

import java.util.ArrayList;

public class AlphaBeta {
	public int[] alphaBeta(Board board, int depth, int player, int alpha, int beta) {
		if (player == 1) {
			if (board.kiemTraHetQuan(player)) {
				board.raiQuan(player);
			}
		} else {
			if (board.kiemTraHetQuan(player)) {
				board.raiQuan(player);
			}
		}
		Square[] squares = board.getSquares();
		int[] valueRoot = new int[14];
		for (int i = 0; i < 14; i++) {
			valueRoot[i] = squares[i].getValue();
		}
		ArrayList<Integer> moves = generateMoves(board, player);
		// nguoi choi 1 la max, 2 la min
		int score = 0;
		int bestLocation = -1;
		int action = 0;
		// tra ve ham danh gia
		if (depth == 0 || board.finish()) {
			if (board.finish()) {
				board.addScore(1);
				board.addScore(2);
			} 
			score = squares[12].getValue() - squares[13].getValue();
			return new int[] { score, bestLocation, action };
		} else {
			for (int i = 0; i < moves.size(); i++) {
				// thuc hien ham left or right
				for (int k = 1; k < 3; k++) {
					int location = board.action(k, moves.get(i));
					if (board.isEat(location)) {
						int scoreSave = board.eatting(k, location);
						if (player == 1) {
							board.setScoreComputer(scoreSave);
						} else {
							board.setScorePlayer(scoreSave);
						}
					}

					if (player == 1) { // max player
						score = alphaBeta(board, depth - 1, 2, alpha, beta)[0];
						if (score > alpha) {
							alpha = score;
							bestLocation = moves.get(i);
							action = k;
						}
					} else { // min player
						score = alphaBeta(board, depth - 1, 1, alpha, beta)[0];
						if (score < beta) {
							beta = score;
							bestLocation = moves.get(i);
							action = k;
						}
					}

					// khoi phuc trang thai ban co cu
					for (int j = 0; j < 14; j++) {
						if (j == 0 || j == 6) {
							squares[j] = new Square(j, valueRoot[j], true, true);
						} else {
							squares[j] = new Square(j, valueRoot[j], false, false);
						}
					}
				}
				if (alpha >= beta) {
					break;
				}
			}
		}
		return new int[] { (player == 1) ? alpha : beta, bestLocation, action };
	}

	// so buoc tiep theo co the co
	public ArrayList<Integer> generateMoves(Board board, int player) {
		Square[] squares = board.getSquares();
		ArrayList<Integer> result = new ArrayList<>();
		if (board.finish()) {
			return result;
		}
		if (player == 1) {
			for (int i = 1; i < 6; i++) {
				if (squares[i].getValue() != 0) {
					result.add(squares[i].getViTri());
				}
			}
		} else {
			for (int i = 7; i < 12; i++) {
				if (squares[i].getValue() != 0) {
					result.add(squares[i].getViTri());
				}
			}
		}
		return result;
	}
}
