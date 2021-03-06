package de.timweb.pix;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.timweb.pix.engine.GameEngine;


public class Main {
	public static void main(String[] args) {
		GameEngine engine = new GameEngine();
		JFrame frame = new JFrame("Pix");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(engine);
		frame.setContentPane(panel);
		frame.pack();
		frame.setResizable(false);
		// frame.setLocationRelativeTo(null);
		frame.setLocation(2000, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		engine.start();
	}
}
