package de.timweb.pix.game.world;

import java.awt.Image;

import de.timweb.pix.util.ImageLoader;

public class Tile {
	public static final Tile	GRASS_1	= new Tile(ImageLoader.grass, false);
	public static final Tile	WATER_1	= new Tile(ImageLoader.water, true);

	private boolean				solid;
	private Image				img;

	public Tile(Image img, boolean solid) {
		this.img = img;
		this.solid = solid;
	}

	public boolean isSolid() {
		return solid;
	}

	public Image getImage() {
		return img;
	}
}
