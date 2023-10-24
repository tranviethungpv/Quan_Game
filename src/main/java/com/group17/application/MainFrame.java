package com.group17.application;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame = new MainFrame();

	public static void startActivity(JPanel panel) {
		// //use JLayer to play music in other thread while running the game
		// Thread musicThread = new Thread(new Runnable() {
		// 	@Override
		// 	public void run() {
		// 		try {
		// 			URL url = MainFrame.class.getResource("/sounds/default.mp3");
		// 			Player player = new Player(url.openStream());
		// 			player.play();
		// 		} catch (Exception e) {
		// 			e.printStackTrace();
		// 		}
		// 	}
		// });
		// musicThread.start();
		
		mainFrame.getContentPane().removeAll();
		mainFrame.add(panel);
		mainFrame.setSize(1280, 720);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		startActivity(new MenuGame());
	}
}