package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	
	int x;
	int y;
	Color color;
	Color startColor;
	boolean facingLeft;
	boolean isLittle;
	// Set (x,y) for destination
	int destX;
	int destY;
	int hunger;
	
	public Fish(Color c, int startX, int startY, 
			boolean isLittle, boolean facingLeft) {
		this.startColor = c;
		this.color = this.startColor;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		this.facingLeft = facingLeft;
		this.hunger = 1000;
		
	}
	
	public void newDest( ) {
		final int HIGH = 300;
		final int LOW = 0;

		Random rand = new Random();
		
		this.destX = rand.nextInt(HIGH - LOW) + LOW;
		//System.out.println(this.destX);
		this.destY = rand.nextInt(HIGH - LOW) + LOW;
		
		// Changes fish color to red if too hungry and
			// makes fish choose dest. in foodBox
		if (this.hunger < 200) {
			this.color = Color.red;
			this.destX = rand.nextInt(200) + 300;
			this.destY = rand.nextInt(200) + 300;
			//System.out.println("Fish is Hungry!");
		} else {
			this.color = this.startColor;
		}

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
		} else if (this.y > this.destY) {
			this.y -=1;
		}
		
		
		//Move fish toward destination in x direction
		if (this.x < this.destX) {
			this.facingLeft = false;
			this.x += 1;
		} else if (this.x > this.destX) {
			this.facingLeft = true;
			this.x -= 1;
		}
		// Sets new dest for fish that get close to current dest
		if ((this.x > this.destX - 10 && 
				this.x < this.destX + 10) || 
				(this.y > this.destY - 10 && 
						this.y < this.destY + 10)) {
			// Fish get new random dest
			this.newDest( );
		}
		
		// Fish loose hunger when not in foodBox
		if (this.x < 300 && this.y < 300) {
			this.hunger -= 1;
			
		// Fish gain hunger when in foodBox
		} else if (this.x > 300 && this.y > 300){
			this.hunger += 5;
			//System.out.println(this.hunger);
		}
		
		
	}
	
	public void orient() {
		if (this.x < this.destX) {
			
		}
	}
}
