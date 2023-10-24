package com.group17.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuGame extends JPanel implements Runnable, MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400, HEIGHT = 100;
	private ButtonRectangle easy, normal, hard;
	private Thread thread;

	public MenuGame() {
		easy = new ButtonRectangle(440, 300, WIDTH, HEIGHT, "easyDefault.png", "easyEntered.png", "easyPressed.png", 1);
		normal = new ButtonRectangle(440, 400, WIDTH, HEIGHT, "normalDefault.png", "normalEntered.png", "normalPressed.png", 2);
		hard = new ButtonRectangle(440, 500, WIDTH, HEIGHT, "hardDefault.png", "hardEntered.png", "hardPressed.png", 3);

		addMouseListener(this);
		addMouseMotionListener(this);
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(loadImage("bg_test.jpg"), 0, 0, 1280, 720, null);
		easy.draw(g2d);
		normal.draw(g2d);
		hard.draw(g2d);
		g2d.drawImage(loadImage("tieude_1.png"), 455, 60, 370, 180, null);
		g2d.setColor(Color.decode("#832411"));
		g2d.setFont(new Font("Brush Script MT", Font.CENTER_BASELINE, 20));
		g2d.drawString("Group 17", 600, 250);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		easy.mouseMoved(e);
		normal.mouseMoved(e);
		hard.mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		easy.mouseEntered(e);
		normal.mouseEntered(e);
		hard.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		easy.mouseExited(e);
		normal.mouseExited(e);
		hard.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		easy.mousePressed(e);
		normal.mousePressed(e);
		hard.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		easy.mouseReleased(e);
		normal.mouseReleased(e);
		hard.mouseReleased(e);
	}

	public Image loadImage(String fileName) {
		return new ImageIcon(getClass().getResource("/images/" + fileName)).getImage();
	}

}
