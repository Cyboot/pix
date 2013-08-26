package de.timweb.pix.game;

import de.timweb.pix.game.world.World;
import de.timweb.pix.util.Graphics2D;

public class Game {
	public final static int	WIDTH	= 1024;
	public final static int	HEIGHT	= 640;

	private World			world	= World.getInstance();

	private Game(World world) {
		this.world = world;
	}


	public void tick() {
		world.tick();

	}

	public void render(Graphics2D g) {
		world.render(g);
	}


	private static Game	instance;

	public static void init() {
		World.init();
		instance = new Game(World.getInstance());
	}

	public static Game getInstance() {
		return instance;
	}
}
