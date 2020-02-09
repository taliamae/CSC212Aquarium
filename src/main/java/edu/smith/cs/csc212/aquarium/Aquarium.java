package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
	}

	int fish1X = getWidth() + 100;
	int fish2X = getWidth() + 300;
	int fish3X = - 100;
	
	// Initiate instances of fish
	Fish nemo = new Fish(Color.magenta, 250, 400, true, true);
	Fish dewy = new Fish(Color.cyan, 350, 100, false, false);
	Fish phillip = new Fish(Color.green, 50, 30, false, true);
	Fish marvin = new Fish(Color.yellow, 175, 70, false, true);
	Fish amy = new Fish(Color.pink, 222, 300, true, false);
	
	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Draw the fish
		nemo.draw(g);
		dewy.draw(g);
		phillip.draw(g);
		marvin.draw(g);
		amy.draw(g);
		
		// Move the fish!
		nemo.move(4);
		dewy.move(5);
		phillip.move(3);
		marvin.move(7);
		amy.move(6);

		// Draw our snail!
		algorithm.draw(g);


		
		if (fish3X > getWidth() + 100) {
			fish3X = -100;
		}
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
