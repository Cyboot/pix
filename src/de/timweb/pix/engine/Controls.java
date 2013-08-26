package de.timweb.pix.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Controls implements KeyListener {
	private static Controls			instance		= new Controls();

	public boolean					right			= false;
	public boolean					left			= false;
	public boolean					up				= false;
	public boolean					down			= false;


	private Map<Integer, Boolean>	keymap			= new HashMap<Integer, Boolean>();
	private Set<Integer>			oncepressedSet	= new HashSet<>();

	@Override
	public void keyPressed(KeyEvent ke) {
		keymap.put(ke.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		keymap.put(ke.getKeyCode(), false);
		oncepressedSet.remove(ke.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

	public boolean pressed(int keycode) {
		return keymap.get(keycode) == null ? false : keymap.get(keycode);
	}

	public boolean pressedOnce(int keycode) {
		boolean isPressed = pressed(keycode);

		boolean wasCheckedBefore = oncepressedSet.contains(keycode);
		if (isPressed)
			oncepressedSet.add(keycode);

		return isPressed && !wasCheckedBefore;
	}

	public static Controls getInstance() {
		return instance;
	}
}
