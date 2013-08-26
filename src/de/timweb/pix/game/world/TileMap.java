package de.timweb.pix.game.world;

import java.util.HashMap;
import java.util.Map.Entry;

import de.timweb.pix.util.Graphics2D;

class TileMap {
	private HashMap<Long, Tile>	tiles	= new HashMap<>();

	public TileMap() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 10; y++) {
				putTile(Tile.GRASS_1, x, y);
			}
		}


	}

	public void render(Graphics2D g) {
		for (Entry<Long, Tile> entry : tiles.entrySet()) {
			long key = entry.getKey();
			Tile tile = entry.getValue();

			int x = (int) (key >> 32) * World.GRIDSIZE;
			int y = (int) key * World.GRIDSIZE;

			g.onWorld().drawImage(tile.getImage(), x, y);
		}
	}

	private void putTile(Tile tile, int x, int y) {
		tiles.put((long) x << 32 | y, tile);
	}

}
