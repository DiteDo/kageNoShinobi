package com.ditedo.kagenoshinobi.naruto.collision;

import com.ditedo.kagenoshinobi.naruto.Position;

public class CollisionBox implements Collision {
	//ATTRIBUTES
	/** Starting point of the box*/
	private Position center;
	/**width of the box*/
	private int width;
	/**height of the box*/
	private int height;
	
	//CONSTRUCTOR
	/**	Construct a collision box
		@param center Entity's position, center of the box
		@param width box width
		@param height box height
	*/
	public CollisionBox(Position center, int width, int height) {
		this.center = center;
		this.width = width;
		this.height = height;
	}

	//METHODS
	/** Give the x starting point of the box */
	public double getX() {return this.center.getX() - width / 2;}

	/** Give the y starting point of the box */
	public double getY() {return this.center.getY() - height / 2;}

	/** Give width of the box */
	public int getWidth() {return this.width;}

	/** Give width of the box */
	public int getHeight() {return this.height;}

	/**
	 * Set a new center
	 * @param position new center
	 */
	public void setCenter(Position position) {
		this.center =  position;
	}

	/** @see Collision#isColliding(CollisionPoint)
	*/
	public boolean isColliding(CollisionPoint p) {
		if (p.position.getX() < this.getX() || p.position.getX() > this.getX() + this.width || p.position.getY() < this.getY() || p.position.getY() > this.getY() + this.height)
			return false;
		return true;

	}
	
	/**	@see Collision
	*/
		public boolean isColliding(CollisionBox box) {
			if (this.getX() + this.width < box.getX() || this.getX() > box.getX() + box.width || 
				this.getY() + this.height < box.getY() || this.getY() > box.getY() + box.height) {
				return false;
		}
		return true;
	}

	/** @see Collision */
	public boolean isColliding(CollisionCircle c) {
		return c.isColliding(this);
	}
}