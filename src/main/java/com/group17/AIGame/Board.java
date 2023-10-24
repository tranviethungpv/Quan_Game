package com.group17.AIGame;

import java.util.ArrayList;

public class Board {
	private Square[] squares;
	private ArrayList<Result> results;

	public Board() {
		results = new ArrayList<>();
		squares = new Square[14];
		for (int i = 0; i < 12; i++) {
			if (i % 6 != 0) {
				squares[i] = new Square(i, 5, false);
			} else if (i == 0) {
				squares[i] = new Square(i, 10, true);
			} else {
				squares[i] = new Square(i, 10, true);
			}
		}
		squares[12] = new Square(12, 0, false);
		squares[13] = new Square(13, 0, false);
	}

	// hanh dong
	public int action(int action, int viTri) {
		if (action == 1) {
			return left(viTri);
		} else {
			return right(viTri);
		}
	}

	public int eatting(int action, int viTri) {
		if (action == 1) {
			return eatLeft(viTri);
		} else {
			return eatRight(viTri);
		}
	}
	
	public Square[] adapter(Square[] squares) {
		Square[] s = new Square[squares.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Square(i, squares[i].getValue(), squares[i].isQuan());
		}
		return s;
	}

	// trả về vị trí sau khi đi qua trái
	public int left(int viTri) {
		int giaTri = squares[viTri].getValue();
		squares[viTri].setValue(0);
		Result r = new Result(adapter(squares));
		results.add(r);
		while (giaTri != 0) {
			viTri++;
			if (viTri == 12) {
				viTri = 0;
			}
			squares[viTri].setValue(squares[viTri].getValue() + 1);
			giaTri--;
			// System.out.println("Vitri: " + viTri);
			// System.out.println("Di chuyển sang trái");
			// printBanCo();
			Result result = new Result(adapter(squares));
			results.add(result);
		}
		viTri++;
		if (viTri == 12) {
			viTri = 0;
		}
		if (squares[viTri].getValue() != 0 && viTri % 6 != 0) {
			return left(viTri);
		} else {
			return viTri--;
		}
	}

	// vi tri đó có ăn được hay ko
	public boolean isEat(int viTri) {
		if (squares[viTri].getValue() == 0 && (viTri != 0 || viTri != 6)) {
			return true;
		}
		return false;
	}

	// trả về vị trí sau khi đi qua phải
	public int right(int viTri) {
		int giaTri = squares[viTri].getValue();
		squares[viTri].setValue(0);
		Result r = new Result(adapter(squares));
		results.add(r);
		while (giaTri != 0) {
			viTri--;
			if (viTri == -1) {
				viTri = 11;
			}
			squares[viTri].setValue(squares[viTri].getValue() + 1);
			giaTri--;
			// System.out.println("Vị trí: " + viTri);
			// System.out.println("Di chuyển sang phải");
			// printBanCo();
			Result result = new Result(adapter(squares));
			results.add(result);
		}
		viTri--;
		if (viTri == -1) {
			viTri = 11;
		}
		if (squares[viTri].getValue() != 0 && viTri % 6 != 0) {
			return right(viTri);
		} else {
			return viTri--;
		}
	}

	public int eatLeft(int viTri) {
		if (squares[viTri].getValue() == 0 && viTri % 6 != 0) {
			viTri++;
			if (viTri == 12) {
				viTri = 0;
			}
			if (squares[viTri].getValue() != 0) {
				// System.out.println("[Left]Ăn tại vị trí: " + viTri);
				int score = squares[viTri].getValue();
				// System.out.println(score);
				squares[viTri].setValue(0);
				// printBanCo();
				Result result = new Result(adapter(squares));
				results.add(result);
				viTri++;
				if (viTri == 12) {
					viTri = 0;
				}
				if (squares[viTri].getValue() == 0 && viTri % 6 != 0) {
					return score + eatLeft(viTri);
				} else {
					return score;
				}
			}
		}
		return 0;
	}

	public int eatRight(int viTri) {
		if (squares[viTri].getValue() == 0 && viTri % 6 != 0) {
			viTri--;
			if (viTri == -1) {
				viTri = 11;
			}
			if (squares[viTri].getValue() != 0) {
				// System.out.println("[Right]Ăn tại vị trí: " + viTri);
				int score = squares[viTri].getValue();
				squares[viTri].setValue(0);
				// printBanCo();
				Result result = new Result(adapter(squares));
				results.add(result);
				viTri--;
				if (viTri == -1) {
					viTri = 11;
				}
				if (squares[viTri].getValue() == 0 && viTri % 6 != 0) {
					return score + eatRight(viTri);
				} else {
					return score;
				}
			}
		}
		return 0;
	}

	public boolean finish() {
		if (squares[0].getValue() == 0 && squares[6].getValue() == 0) {
			// System.out.println("Game over");
			return true;
		}
		if (squares[12].getValue() == 0) {
			if (kiemTraHetQuan(1)) {
				return true;

			}
		}
		if (squares[13].getValue() == 0) {
			if (kiemTraHetQuan(2)) {
				return true;
			}
		}
		return false;
	}

	// kiem tra ô đó có đc dùng hay ko
	public boolean kiemTra(int viTri, int player) {
		if (player == 1) {
			if (viTri != 1 && viTri != 2 && viTri != 3 && viTri != 4 && viTri != 5) {
				return false;
			}
			if (squares[viTri].getValue() == 0 || viTri % 6 == 0) {
				return false;
			}
		} else {
			if (viTri == 1 || viTri == 2 || viTri == 3 || viTri == 4 || viTri == 5) {
				return false;
			}
			if (squares[viTri].getValue() == 0 || viTri % 6 == 0) {
				return false;
			}
		}
		return true;
	}

	// cộng điểm sau khi hết game (toàn dân kéo về)
	public int addScore(int player) {
		int score = 0;
		if (player == 1) {
			for (int i = 1; i < 6; i++) {
				score += squares[i].getValue();
				squares[i].setValue(0);
			}
			setScoreComputer(score);
		} else {
			for (int i = 7; i < 12; i++) {
				score += squares[i].getValue();
				squares[i].setValue(0);
			}
			setScorePlayer(score);
		}
		return score;
	}

	public boolean kiemTraHetQuan(int player) {
		if (player == 1) {
			int score = 0;
			for (int i = 1; i < 6; i++) {
				score += squares[i].getValue();
			}
			if (score == 0) {
				return true;
			}
		} else {
			int score = 0;
			for (int i = 7; i < 12; i++) {
				score += squares[i].getValue();
			}
			if (score == 0) {
				return true;
			}
		}
		return false;
	}

	// rải quân sau khi hết quân nhưng vẫn còn quan
	public int raiQuan(int player) {
		if (player == 1) {
			int score = squares[12].getValue();
			if (score <= 5) {
				for (int i = 1; i <= score; i++) {
					squares[i].setValue(1);
				}
				squares[12].setValue(0);
				Result r = new Result(adapter(squares));
				results.add(r);
				return score;
			} else {
				for (int i = 1; i < 6; i++) {
					squares[i].setValue(1);
				}
				squares[12].setValue(score-5);
				Result r = new Result(adapter(squares));
				results.add(r);
				return 5;
			}
		} else {
			int score = squares[13].getValue();
			if (score <= 5) {
				for (int i = 7; i < 7 + score; i++) {
					squares[i].setValue(1);
				}
				squares[13].setValue(0);
				Result r = new Result(adapter(squares));
				results.add(r);
				return score;
			} else {
				for (int i = 7; i < 12; i++) {
					squares[i].setValue(1);
				}
				squares[13].setValue(score-5);
				Result r = new Result(adapter(squares));
				results.add(r);
				return 5;
			}
		}
	}

	public void setScoreComputer(int score) {
		int a = squares[12].getValue();
		squares[12].setValue(score + a);
		Result result = new Result(squares);
		results.add(result);
	}

	public void setScorePlayer(int score) {
		int a = squares[13].getValue();
		squares[13].setValue(score+a);
		Result result = new Result(squares);
		results.add(result);
	}

	public void printBanCo() {
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

	public Square[] getSquares() {
		return squares;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

}
