package de.timweb.pix.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.timweb.pix.engine.GameEngine;

public class ImageLoader {
	public static BufferedImage	grass;

	public static void init() {
		grass = loadImage("grass.png");
	}

	private static BufferedImage loadImage(String img) {
		try {
			return ImageIO.read(GameEngine.class.getResource("/" + img));
		} catch (IOException e) {
			throw new IllegalArgumentException("The Image you tried to load was not found!", e);
		}
	}

	public static BufferedImage getSubImage(BufferedImage img, int x, int y, int width) {
		return img.getSubimage(x * width, y * width, width, width);
	}

	public static BufferedImage getCutImage(BufferedImage img, int width) {
		return img.getSubimage(0, 0, width, img.getHeight());
	}
}
