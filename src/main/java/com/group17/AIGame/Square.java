package com.group17.AIGame;

public class Square {
	private int viTri; //vi trí của ô
	private int value; // gia tri tại ô đó
	private boolean isQuan; // xét xem vị trí đó có phải là quan ko

	public Square(int viTri, int value, boolean isQuan) {
		this.viTri = viTri;
		this.value = value;
		this.isQuan = isQuan;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isQuan() {
		return isQuan;
	}

	public void setQuan(boolean isQuan) {
		this.isQuan = isQuan;
	}

	public int getViTri() {
		return viTri;
	}

	public void setViTri(int viTri) {
		this.viTri = viTri;
	}

	public String toString() {
		String quan = "";
		if (isQuan) {
			quan = " là dân";
		} else {
			quan = " là quan";
		}
		return "Vị trí: "+viTri+quan;
	}
}
