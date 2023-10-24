package com.group17.application;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class ButtonRectangle {
	private int x, y, width, height;
	private Image imageCurrent, imageDefault, imageEntered, imagePressed;
	private boolean entered;
	private int type;

	public ButtonRectangle(int x, int y, int width, int height, String imgDefault, String imgEntered, String imgPressed,
			int type) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imageDefault = loadImage(imgDefault);
		this.imageEntered = loadImage(imgEntered);
		this.imagePressed = loadImage(imgPressed);
		this.imageCurrent = imageDefault;
		this.type = type;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(imageCurrent, x, y, width, height, null);
	}

	public Image loadImage(String fileName) {
		return new ImageIcon(getClass().getResource("/images/" + fileName)).getImage();
	}

	public void mouseDragged(MouseEvent e) {
		mouseEntered(e);
		mouseExited(e);
	}

	public void mouseMoved(MouseEvent e) {
		mouseEntered(e);
		mouseExited(e);
	}

	public void mouseEntered(MouseEvent e) {
		Point p = e.getPoint();
		int px = (int) p.getX();
		int py = (int) p.getY();
		if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
			imageCurrent = imageEntered;
			entered = true;
		}
	}

	public void mouseExited(MouseEvent e) {
		Point p = e.getPoint();
		int px = (int) p.getX();
		int py = (int) p.getY();
		if ((px <= x || px >= x + width) || (py <= y || py >= y + height)) {
			imageCurrent = imageDefault;
			entered = false;
		}
	}

	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		int px = (int) p.getX();
		int py = (int) p.getY();
		if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
			imageCurrent = imagePressed;
			if (type == 1) {
				MainFrame.startActivity(new GamePanel(1));
				System.out.println(1);
			} else if (type == 2) {
				MainFrame.startActivity(new GamePanel(3));
				System.out.println(2);
			} else if (type == 3) {
				System.out.println(3);
				MainFrame.startActivity(new GamePanel(7));
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (entered) {
			imageCurrent = imageEntered;
		} else {
			imageCurrent = imageDefault;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
