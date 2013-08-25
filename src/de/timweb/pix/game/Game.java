package de.timweb.pix.game;

import java.awt.Color;

import de.timweb.pix.util.Graphics2D;
import de.timweb.pix.util.ImageLoader;

public class Game {
	public final static int	WIDTH	= 1024;
	public final static int	HEIGHT	= 640;


	private Game() {
	}


	public void tick() {

	}

	public void render(Graphics2D g) {
		g.fillRect(0, 0, WIDTH, HEIGHT / 4, Color.blue);

		g.fillRect(0, HEIGHT / 4, WIDTH, HEIGHT, Color.green);

		g.drawImage(ImageLoader.grass, 200, 200);
	}


	private static Game	instance	= new Game();

	public static Game getInstance() {
		return instance;
	}
}
