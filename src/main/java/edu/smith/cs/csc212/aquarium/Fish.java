package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
	
	int x;
	int y;
	Color color;
	boolean facingLeft;
	boolean isLittle;
	// Set (x,y) for destination
	int destX;
	int destY;
	
	public Fish(Color c, int startX, int startY, 
			boolean isLittle, boolean facingLeft) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		this.facingLeft = facingLeft;
		
		this.destX = 450;
		this.destY = 450;
				
	}
	
	public void draw(Graphics2D g) {
		//this.move();
		// Four types of fish
		if (this.facingLeft && this.isLittle) {
			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
		} else if (!this.facingLeft && !this.isLittle) {
			DrawFish.facingRight(g, this.color, this.x, this.y);
		} else if (this.facingLeft && !this.isLittle) {
			DrawFish.facingLeft(g, this.color, this.x, this.y);
		} else if (!this.facingLeft && this.isLittle) {
			DrawFish.smallFacingRight(g, this.color, this.x, this.y);
		}
	
	}
	
	public void move(int incX) {
		//Move fish toward destination in y direction
		if (this.y < this.destY) {
			this.y += 1;
			//will eventually set new destination at random
		} else if (this.y > this.destY) {
			this.y -=1;
		}
		
		//Move fish toward destination in x direction
		if (this.x < this.destX) {
			this.x += 1;
		} else if (this.x > this.destX) {
			this.x -= 1;
		}
		
		if (this.facingLeft) {
			this.x -= incX;
		} else {
			this.x += incX;
		}
	}
}
