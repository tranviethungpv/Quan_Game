package com.group17.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Oco {
	private int x, y, width, height;
	private int viTri, value;
	private boolean isQuan;
	private Image imageCurrent, imageDefault, imageEntered, imagePressed;
	private boolean entered;

	public Oco(int x, int y, int width, int height, int viTri, int value, boolean isQuan) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.viTri = viTri;
		this.value = value;
		this.isQuan = isQuan;
		imageDefault = loadImage("default.png");
		imageEntered = loadImage("entered.png");
		imagePressed = loadImage("pressed.png");
		imageCurrent = imageDefault;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.decode("#015ea6"));
		g2d.setFont(new Font("Tomaha", Font.CENTER_BASELINE, 25));
		if (!isQuan && viTri != 12 && viTri != 13) {
			g2d.drawImage(imageCurrent, x, y, width, height, null);
			g2d.drawString(value + "", x + 40, y + 25);
		} else if (isQuan) {
			if (viTri == 0) {
				g2d.drawImage(loadImage("quanTrai.png"), x, y, width, height, null);
				g2d.drawString(value + "", x + BanCo.WIDTH - 30, y + BanCo.HEIGHT_QUAN - 15);
			} else {
				g2d.drawImage(loadImage("quanPhai.png"), x, y, width, height, null);
				g2d.drawString(value + "", x + 5, y + 30);
			}
		} else {
			g2d.drawImage(loadImage("score.png"), x - 30, y, width + 65, height, null);
			if (viTri == 12) {
				g2d.drawString(value + "", 575, 215);
				g2d.setColor(Color.decode("#48423f"));
				g2d.drawString("Máy", x + 25, y - 10);
			} else {
				g2d.drawString(value + "", 575, 525);
				g2d.setColor(Color.decode("#48423f"));
				g2d.drawString("Bạn", x + 25, y + 110);
			}
		}
		g2d.setColor(Color.decode("#48423f"));
		if (isQuan) {
			for (int i = 0; i < value; i++) {
				g2d.fillOval(x + BanCo.boundX[i], y + BanCo.boundY[i] + 35, 13, 10);
			}
		} else {
			for (int i = 0; i < value; i++) {
				g2d.fillOval(x + BanCo.boundX[i], y + BanCo.boundY[i], 13, 10);
			}
		}
		if (entered) {
			g2d.drawImage(loadImage("trai.png"), x+2, y, 30, 22, null);
			g2d.drawImage(loadImage("phai.png"), x+61, y, 30, 22, null);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (!isQuan && viTri != 12 && viTri != 13 && viTri > 6 && value > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
				imageCurrent = imageEntered;
				entered = true;
			}
		}
	}

	public void mouseExited(MouseEvent e) {
		if (!isQuan && viTri != 12 && viTri != 13 && viTri > 6 && value > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px <= x || px >= x + width) || (py <= y || py >= y + height)) {
				imageCurrent = imageDefault;
				entered = false;
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		if (!isQuan && viTri != 12 && viTri != 13 && viTri > 6 && value > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
				imageCurrent = imagePressed;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (!isQuan && viTri != 12 && viTri != 13 && viTri > 6 && value > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
				imageCurrent = imageEntered;
			} else {
				imageCurrent = imageDefault;
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		if (!isQuan && viTri != 12 && viTri != 13 && viTri > 6 && value > 0) {
			mouseEntered(e);
			mouseExited(e);
		}
	}

	public Image loadImage(String fileName) {
		return new ImageIcon(getClass().getResource("/images/" + fileName)).getImage();
	}
}
