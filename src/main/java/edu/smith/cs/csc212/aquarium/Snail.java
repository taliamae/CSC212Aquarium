package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Snail {
	/**
	 * How tall is the snail? Needed to put it upside-down.
	 */
	public static int HEIGHT = 50;
	/**
	 * The positioning of the snail. Use setSide(s) to change this.
	 */
	private String direction;
	/**
	 * The position of the Snail; x-coordinate.
	 */
	public int x;
	/**
	 * The position of the Snail; y-coordinate.
	 */
	public int y;
	
	public boolean isSleep;
	
	//Shape eyeWhiteR;
	//Shape eyeWhiteL;

	/**
	 * Create a snail at (sx, sy) with position s.
	 * 
	 * @param sx - x coordinate
	 * @param sy - y coordinate
	 * @param s  - the "positioning" of the Snail
	 */
	public Snail(int sx, int sy, String s) {
		this.setSide(s);
		this.x = sx;
		this.y = sy;
		this.isSleep = true;
		
		//this.eyeWhiteR = new Ellipse2D.Double(35 - 4, -28, 12, 12);
		//this.eyeWhiteL = new Ellipse2D.Double(-4, -28, 12, 12);
	}
	

	/**
	 * Change which side of the the snail thinks its on.
	 * 
	 * @param s - one of "top", "bottom", "left" or "right".
	 */
	public void setSide(String s) {
		//if (this.x < 50 && this.y < 200) {
		this.direction = s.toLowerCase();
		System.out.println("Starting");
		//}

	}
	
	public void sleep() {
		// Need to put snail to sleep and stop it from moving
		System.out.print("let me sleep!");
		this.isSleep = true;
		
	}
	
	public void wake() {
		this.isSleep = false;
		this.move();
	}
	/**
	 * TODO: move the snail about.
	 */
	public void move() {
		//System.out.println(this.direction);
		
		if (!this.isSleep) {
			if("top".equals(this.direction)) {
				this.x += 1;
				if (this.x > 450 && this.y < 200) {
					this.setSide("right");
					System.out.println("rotate me right");
				}
				
			} else if("right".equals(this.direction)) {
				this.y += 1;
				if (this.x > 450 && this.y > 450) {
					this.setSide("bottom");
					System.out.println("rotate me bottom");
					
			} else if ("bottom".equals(this.direction)) {
				System.out.println("I'm a bottom now");
				this.x -= 1;
				if (this.x < 50 && this.y < 200) {
					this.setSide("left");
					System.out.println("rotate me left");
				}
				
			} else if("left".equals(this.direction)) {
				this.y -= 1;
				if (this.x < 50 && this.y > 450) {
					this.setSide("top");
					System.out.println("rotate me top");
					}
				}
			}
		}

	}

	/**
	 * Draw the snail at the current setup.
	 * 
	 * @param g - the window to draw to.
	 */
	public void draw(Graphics2D g) {
		// By calling move here, if we want to move our snail, we can do so.
		// Move gets called by draw, so whenever draw gets called.
		//this.move();

		// By making a new Graphics2D object, we can move everything that gets drawn to
		// it.
		// This is kind of tricky to wrap your head around, so I gave it to you.
		Graphics2D position = (Graphics2D) g.create();
		position.translate(x, y);

		// Note that I need to compare strings with ".equals" this is a Java weirdness.
		if ("bottom".equals(this.direction)) {
			drawSnail(position, Color.red, Color.white, Color.black);
		} else if ("top".equals(this.direction)) {
			position.scale(-1, -1);
			drawSnail(position, Color.red, Color.white, Color.black);
		} else if ("left".equals(this.direction)) {
			// Oh no, radians.
			position.rotate(Math.PI / 2);
			drawSnail(position, Color.red, Color.white, Color.black);
		} else { // we don't have to say "right" here.
			// Oh no, radians.
			position.rotate(-Math.PI / 2);
			drawSnail(position, Color.red, Color.white, Color.black);
		}

		// It's OK if you forget this, Java will eventually notice, but better to have
		// it!
		position.dispose();
	}

	/**
	 * Kudos to Group 7, (Fall 2018).
	 * 
	 * @param g          The graphics object to draw with.
	 * @param bodyColor  The color of the snail body.
	 * @param shellColor The color of the snail shell.
	 * @param eyeColor   The color of the snail eye.
	 */
	public void drawSnail(Graphics2D g, Color bodyColor, Color shellColor, Color eyeColor) {
		Shape body = new Rectangle2D.Double(0, 0, 40, 50);
		Shape tentacleL = new Rectangle2D.Double(0, -20, 5, 20);
		Shape eyeWhiteL = new Ellipse2D.Double(-4, -28, 12, 12);
		Shape eyePupilL = new Ellipse2D.Double(-2, -26, 4, 4);

		g.setColor(bodyColor);
		g.fill(body);
		g.fill(tentacleL);
		if (this.isSleep) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.white);
		}
		g.fill(eyeWhiteL);
		g.setColor(eyeColor);
		g.fill(eyePupilL);

		Shape tentacleR = new Rectangle2D.Double(35, -20, 5, 20);
		Shape eyeWhiteR = new Ellipse2D.Double(35 - 4, -28, 12, 12);
		Shape eyePupilR = new Ellipse2D.Double(35 + 2, -26 + 4, 4, 4);

		g.setColor(bodyColor);
		g.fill(tentacleR);
		if (this.isSleep) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.white);
		}
		g.fill(eyeWhiteR);
		g.setColor(eyeColor);
		g.fill(eyePupilR);

		Shape shell3 = new Ellipse2D.Double(45, 20, 10, 10);
		Shape shell2 = new Ellipse2D.Double(35, 10, 30, 30);
		Shape shell1 = new Ellipse2D.Double(25, 0, 50, 50);

		g.setColor(shellColor);
		g.fill(shell1);
		g.setColor(Color.black);
		g.draw(shell1);
		g.setColor(shellColor);
		g.fill(shell2);
		g.setColor(Color.black);
		g.draw(shell2);
		g.setColor(shellColor);
		g.fill(shell3);
		g.setColor(Color.black);
		g.draw(shell3);
	}
}
