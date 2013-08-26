package de.timweb.pix.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import de.timweb.pix.game.world.World;

public class Graphics2D {
	private static final Graphics2D	instance	= new Graphics2D();
	private static final World		world		= World.getInstance();
	public static final int			SCALE		= 2;

	public Graphics					g;
	private Graphics2D				graphics2DOffset;

	private boolean					offset		= false;

	public Graphics2D() {
		graphics2DOffset = new Graphics2D(true);
	}

	private Graphics2D(boolean worldoffset) {
		offset = true;
	}

	public void drawImage(Image img, int x, int y) {
		x = x(x);
		y = y(y);
		if (img != null)
			g.drawImage(img, x, y, x + img.getWidth(null) * SCALE, y + img.getHeight(null) * SCALE, 0, 0,
					img.getWidth(null), img.getHeight(null), null);
	}

	public void drawImage(Image img, Vector2d position) {
		if (img != null)
			drawImage(img, position.x(), position.y());
	}

	public void fillRect(int x, int y, int width, int height, Color color) {
		x = x(x);
		y = y(y);
		if (color != null)
			g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void drawRect(int x, int y, int width, int height, Color color) {
		x = x(x);
		y = y(y);
		if (color != null)
			g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void fillOvalCentered(int x, int y, int width, int height, Color color) {
		x = x(x);
		y = y(y);
		if (color != null)
			g.setColor(color);
		g.fillOval(x - width / 2, y - height / 2, width, height);
	}

	public void drawOvalCentered(int x, int y, int width, int height, Color color) {
		x = x(x);
		y = y(y);
		if (color != null)
			g.setColor(color);
		g.drawOval(x - width / 2, y - height / 2, width, height);
	}


	public void setGraphics(Graphics g) {
		this.g = g;
		this.graphics2DOffset.g = g;
	}

	public static Graphics2D getInstance() {
		return instance;
	}

	public Graphics2D onWorld() {
		return graphics2DOffset;
	}

	private int y(int y) {
		if (offset)
			return y + world.getOffset().y();
		return y;
	}

	private int x(int x) {
		if (offset)
			return x + world.getOffset().x();
		return x;
	}
}
