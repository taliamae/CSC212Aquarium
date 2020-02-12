package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class HungryFish {
	
	int hunger;
	int x1;
	int y1;
	int foodX;
	int foodY;
	Random rand = new Random();
	
	public HungryFish( ) {
		this.hunger = 10;
		this.x1 = 300;
		this.y1 = 300;
		this.foodX = rand.nextInt(200) + 300;
		this.foodY = rand.nextInt(200) + 300;
	}
	
	public void draw(Graphics2D g) {
		
		Shape food = new Ellipse2D.Double(this.foodX, this.foodY, 10, 10);
		g.setColor(Color.green);
		g.fill(food);
		g.draw(food);
		
		move();
	}
	
	public void move() {
		
		this.foodY += 1;
		if (this.foodY > 505) {
			this.foodY = 290;
		}
		
	}
	
	

}
