import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy {
	Random r = new Random();
	int x = 0;
	int y = r.nextInt(437);

	private int xPlus = 5;
	private int yPlus = 5;

	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 30, 30);
	}

	public void movement() {

		x += xPlus;
		y += yPlus;
		if (x <= 0) {
			xPlus = 5;

		}
		if (x >= 470) {
			xPlus = -5;

		}

		if (y <= 0) {
			yPlus = 5;

		}
		if (y >= 437) {
			yPlus = -5;

		}

	}
	

}
