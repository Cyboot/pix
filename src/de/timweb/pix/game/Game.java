package de.timweb.pix.game;

import de.timweb.pix.engine.Controls;
import de.timweb.pix.game.entity.PlayerEntity;
import de.timweb.pix.game.world.World;
import de.timweb.pix.util.Graphics2D;
import de.timweb.pix.util.Vector2d;

public class Game {
	public final static int	WIDTH	= 1024;
	public final static int	HEIGHT	= 640;

	private World			world	= World.getInstance();
	private Controls		input	= Controls.getInstance();

	private PlayerEntity	player	= new PlayerEntity(new Vector2d(WIDTH / 2, HEIGHT / 2));

	private Game(World world) {
		this.world = world;
	}


	public void tick() {
		world.tick();

		player.tick();
	}

	public void render(Graphics2D g) {
		world.render(g);

		player.render(g);
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
