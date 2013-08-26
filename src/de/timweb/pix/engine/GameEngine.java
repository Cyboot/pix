package de.timweb.pix.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import de.timweb.pix.game.Game;
import de.timweb.pix.util.CountdownTimer;
import de.timweb.pix.util.Graphics2D;
import de.timweb.pix.util.ImageLoader;
import de.timweb.pix.util.StringFormatter;

public class GameEngine extends Canvas {
	public static final int	DELTA_TARGET			= 15;

	private float			cpuWorkload;
	private String			cpuWorkloadText			= "";
	private CountdownTimer	timerCPUWorkloadText	= new CountdownTimer(1000);

	private Game			game;
	private Graphics2D		graphics2d				= Graphics2D.getInstance();

	public GameEngine() {
		Dimension dim = new Dimension(Game.WIDTH - 10, Game.HEIGHT - 10);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);

		addKeyListener(Controls.getInstance());
		setBackground(Color.magenta);
	}

	public void start() {
		ImageLoader.init();
		Game.init();
		game = Game.getInstance();

		final int DELTA_TARGET_NANOS = DELTA_TARGET * 1000 * 1000;

		while (true) {
			long timeStart = System.nanoTime();

			BufferStrategy bs = getBufferStrategy();
			if (bs == null) {
				createBufferStrategy(3);
				continue;
			}

			tick();

			graphics2d.setGraphics(bs.getDrawGraphics());
			render();

			if (bs != null)
				bs.show();

			long timePassed = System.nanoTime() - timeStart;
			if (timePassed < DELTA_TARGET_NANOS) {
				long sleepTime = DELTA_TARGET_NANOS - timePassed;

				long millis = sleepTime / (1000 * 1000);
				int nano = (int) (sleepTime % (1000 * 1000));
				// System.out.println(millis + " : " + nano);

				try {
					Thread.sleep(millis, nano);
				} catch (InterruptedException e) {
				}
			}

			cpuWorkload = (float) timePassed / DELTA_TARGET_NANOS;
		}
	}

	private void tick() {
		// try {
		// Thread.sleep((long) (Math.random() * 2));
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		if (timerCPUWorkloadText.isTimeleft())
			cpuWorkloadText = getCPUWorkload();

		game.tick();
	}

	private void render() {
		graphics2d.g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);


		game.render(graphics2d);

		graphics2d.g.setColor(Color.yellow);
		graphics2d.g.setFont(getFont());
		graphics2d.g.drawString(cpuWorkloadText, Game.WIDTH - 30, 15);

		graphics2d.g.dispose();
		Toolkit.getDefaultToolkit().sync();
	}


	private String getCPUWorkload() {
		return StringFormatter.format(cpuWorkload);
	}
}
