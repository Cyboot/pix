package de.timweb.pix.game.world;

import java.awt.Color;
import java.awt.event.KeyEvent;

import de.timweb.pix.engine.Controls;
import de.timweb.pix.game.Game;
import de.timweb.pix.util.Graphics2D;
import de.timweb.pix.util.Vector2d;

public class World {
	public static final int	GRIDSIZE	= 64;

	private static World	instance	= new World();

	private TileMap			tilemap;
	private Vector2d		offset;

	private Controls		input		= Controls.getInstance();

	public World() {
	}

	public void tick() {
		if (input.pressed(KeyEvent.VK_A))
			offset.x -= 2;
		if (input.pressed(KeyEvent.VK_D))
			offset.x += 2;
		if (input.pressed(KeyEvent.VK_W))
			offset.y -= 2;
		if (input.pressed(KeyEvent.VK_S))
			offset.y += 2;
	}

	public void render(Graphics2D g) {
		tilemap.render(g);

		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT / 4, Color.blue);
	}

	public static void init() {
		instance.tilemap = new TileMap();
		instance.offset = new Vector2d();
	}

	public static World getInstance() {
		return instance;
	}

	public Vector2d getOffset() {
		return offset;
	}

}
