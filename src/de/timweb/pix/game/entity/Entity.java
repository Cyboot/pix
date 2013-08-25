package de.timweb.pix.game.entity;

import de.timweb.pix.util.Graphics2D;
import de.timweb.pix.util.Vector2d;

public abstract class Entity {
	protected Vector2d	pos;
	private boolean		isAlive	= true;

	public Entity() {
		this(new Vector2d());
	}

	public Entity(Vector2d pos) {
		this.pos = pos;
	}

	public void kill() {
		if (isAlive)
			onKilled();

		isAlive = false;
	}

	protected void onKilled() {
	}

	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @return false if Entity is dead
	 */
	public abstract boolean tick();

	public abstract void render(Graphics2D g);
}
