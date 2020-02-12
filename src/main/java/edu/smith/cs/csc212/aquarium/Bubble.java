package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Bubble {
	
	int x;
	int y;
	int radius;
	int drift;
	int delay;
	Random rand = new Random();
	
	public Bubble( ) {		
		this.x = rand.nextInt(500);
		this.y = rand.nextInt(500);
		this.drift = 0;
		this.delay = 0;
		this.radius = rand.nextInt(10);
				
	}

	public void draw(Graphics2D g) {
		// Construct bubble as ellipse object
		Shape bubble = new Ellipse2D.Double(this.x + this.drift, this.y, 
					this.radius + 2, this.radius + 2);
		
		// Draw bubbles
		g.setColor(Color.white);
		g.fill(bubble);
		g.draw(bubble);
		
		// Construct treasure chest for bubbles to come out of
		Shape treasureChest = new Rectangle2D.Double(225, 470, 50, 30);
		
		// Draw treasure chest
		g.setColor(Color.red);
		g.fill(treasureChest);
		g.draw(treasureChest);
		
		// Move bubbles.
		move();
	}
		
	public void move() {
		// Move bubbles up
		this.y -= 3;
		if (this.y < -30) {
			this.y = 520;
		}
		
		// Give bubbles a new x place when off top of screen
		if (this.y < -10) {
			this.x = rand.nextInt(500);
		}
		
		// Make bubbles sway from side to side
		this.drift = (int) (30.0 * Math.sin(this.y / 100.0));
		
		
		
		
	}

}
