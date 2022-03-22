import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Player {
	int x = 0;

	int y = 0;
	int xVel = 0;
	int yVel = 0;
	Enemy e = new Enemy();
	Rectangle rect = new Rectangle(x, y, 30, 30);
	// dirs: [left, up, right, down]
	boolean[] dirs = new boolean[4];

	public void paint(Graphics g) {
		g.setColor(Color.black);
		// g.fillRect(0, 0, 500, 500);
		g.setColor(Color.orange);
		g.fillRect(x, y, 30, 30);
	}

	public void keyPress(int dir) {
		dirs[dir] = true;
	}

	public void unPress(int dir) {
		dirs[dir] = false;
		if (dir % 2 == 0) {
			xVel = 0;
		} else {
			yVel = 0;
		}
	}

	public void movement() {
		y += yVel;
		x += xVel;

		xVel *= .9;
		yVel *= .9;
		if (dirs[1]) {
			yVel -= 2;
		}
		if (dirs[3]) {
			yVel += 2;
		}
		if (dirs[2]) {
			xVel += 2;
		}
		if (dirs[0]) {
			xVel -= 2;
		}

		x = Math.max(Math.min(x, 470), 0);
		y = Math.max(Math.min(y, 437), 0);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
