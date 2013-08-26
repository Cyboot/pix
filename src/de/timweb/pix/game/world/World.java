package de.timweb.pix.game.world;

import java.awt.Color;

import de.timweb.pix.game.Game;
import de.timweb.pix.util.Graphics2D;

public class World {
	public static final int	GRIDSIZE	= 64;

	private static World	instance;

	private TileMap			tilemap		= new TileMap();

	public World() {

	}

	public void tick() {

	}

	public void render(Graphics2D g) {
		tilemap.render(g);

		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT / 4, Color.blue);
	}

	public static void init() {
		instance = new World();
	}

	public static World getInstance() {
		return instance;
	}
}
