package de.timweb.pix.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Graphics2D {
	private static final Graphics2D	instance	= new Graphics2D();

	public static final int			SCALE		= 2;

	public Graphics					g;

	public void drawImage(Image img, int x, int y) {
		g.drawImage(img, x, y, x + img.getWidth(null) * SCALE, y + img.getHeight(null) * SCALE, 0, 0,
				img.getWidth(null), img.getHeight(null), null);
	}

	public void drawImage(Image img, Vector2d position) {
		drawImage(img, position.x(), position.y());
	}

	public void fillRect(int x, int y, int width, int height, Color color) {
		if (color != null)
			g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void drawRect(int x, int y, int width, int height, Color color) {
		if (color != null)
			g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void fillOvalCentered(int x, int y, int width, int height) {
		g.fillOval(x - width / 2, y - height / 2, width, height);
	}

	public void drawOvalCentered(int x, int y, int width, int height) {
		g.drawOval(x - width / 2, y - height / 2, width, height);
	}


	public void setGraphics(Graphics g) {
		this.g = g;
	}

	public static Graphics2D getInstance() {
		return instance;
	}
}
