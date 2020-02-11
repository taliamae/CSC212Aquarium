package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class Bubble {
	
	int x;
	int y;
	int radius;
	
	public Bubble( int x, int y) {		
		this.x = 0;
		this.y = 0;
		
				
	}
	
	//public Bubble(Graphics2D g) {
		// TODO Auto-generated constructor stub
	//}

	public void draw(Graphics2D g) {
		
		Bubble[] bubbles; 
		// Create 20 bubbles, iterated through i
		for(int i=0; i<20; i++) {
			final int HIGH = 10;
			final int LOW = 2;

			Random rand = new Random();
			this.radius = rand.nextInt(HIGH - LOW) + LOW;
			
			this.x = i * 25;
			//System.out.println(i * 25);
			Shape bubble = new Ellipse2D.Double(i * 25, 475, this.radius, this.radius);
			
			// Draw bubbles
			g.setColor(Color.white);
			g.fill(bubble);
			g.draw(bubble);
			
			
		}
		// Move bubbles.
		move();
	}
		
	public void move() {
		this.y -= 5;
		if (this.y < -30) {
			this.y = 520;
		}
		
		
		
		
		
		
	}

}
