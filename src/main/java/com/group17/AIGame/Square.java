package com.group17.AIGame;

public class Square {
	private int viTri; //vi trí của ô
	private int value; // gia tri tại ô đó
	private boolean isQuan; // xét xem vị trí đó có phải là quan ko
	private boolean hasQuan; // xét xem có quan hay không

	public Square(int viTri, int value, boolean isQuan, boolean hasQuan) {
		this.viTri = viTri;
		this.value = value;
		this.isQuan = isQuan;
		this.hasQuan = hasQuan;
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

	public boolean hasQuan() {
		return this.hasQuan;
	}

	public void setHasQuan(boolean hasQuan) {
		this.hasQuan = hasQuan;
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
