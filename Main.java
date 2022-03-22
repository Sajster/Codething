import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements KeyListener {
	public static Dimension dim = new Dimension(500, 500);
	Timer gameTimer;
	int count = 0;
	Player p;
	Enemy e;
	Enemy[] enemies = new Enemy[8];
	int spawnTimer = 0;

	public Main() {

		this.setPreferredSize(dim);
		this.setBackground(Color.black);
		addKeyListener(this);
		setFocusable(true);
		e = new Enemy();
		p = new Player();
		for(int i = 0; i < enemies.length;i++) {
			enemies[i] = new Enemy();
		}

		gameTimer = new Timer(1000 / 60, e -> {

			p.movement();
			for(Enemy enemyarray : enemies) {
				enemyarray.movement();
				//enemyarray.collision();
			}

			repaint();

		});
		gameTimer.start();

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new Main());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(dim);
		f.setVisible(true);
		f.pack();
		f.setLocationRelativeTo(null);

	}

	public void paintComponent(Graphics g) {

		p.paint(g);
		for(Enemy enemyarray : enemies) {
			enemyarray.paint(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p.keyPress(2);

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p.keyPress(0);

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p.keyPress(1);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p.keyPress(3);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p.unPress(2);

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p.unPress(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p.unPress(1);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p.unPress(3);
		}
	}

}
