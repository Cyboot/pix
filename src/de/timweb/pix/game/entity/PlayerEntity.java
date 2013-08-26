package de.timweb.pix.game.entity;

import java.awt.Color;
import java.awt.event.KeyEvent;

import de.timweb.pix.util.Graphics2D;
import de.timweb.pix.util.Vector2d;

public class PlayerEntity extends Entity {
	private double	speed	= 5;

	public PlayerEntity(Vector2d pos) {
		super(pos);
	}

	@Override
	public boolean tick() {
		if (input.pressed(KeyEvent.VK_LEFT))
			pos.x -= speed;
		if (input.pressed(KeyEvent.VK_RIGHT))
			pos.x += speed;
		if (input.pressed(KeyEvent.VK_UP))
			pos.y -= speed;
		if (input.pressed(KeyEvent.VK_DOWN))
			pos.y += speed;


		return isAlive();
	}

	@Override
	public void render(Graphics2D g) {
		g.onWorld().fillOvalCentered(pos.x(), pos.y(), 32, 32, Color.red);
	}

}
