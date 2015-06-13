package com.ditedo.kagenoshinobi.naruto.collision;

import com.ditedo.kagenoshinobi.naruto.Position;

public class CollisionsBoxes implements Collision {
	//ATTRIBUTES
	/** Box to test collision with other box */
	private CollisionBox box;
	/** Circle to test collision with other circle */
	private CollisionCircle circle;

	//CONSTRUCTOR
	/** Create a CollisionsBoxes object to test collision box and collision circle
		@param position entity's position equals center's boxes
		@param width dimension of the square box
	*/
	public CollisionsBoxes(Position position, int width, int height) {
		this.box = new CollisionBox(position, width, height);
		if (width <= height)
			this.circle = new CollisionCircle(position, width / 2);
		else
			this.circle = new CollisionCircle(position, height / 2);
	}

	//METHODS
	/** Give the center of boxes 
		@return center's boxes
	*/
	public Position getCenter() {
		return this.circle.getCenter();
	}

	/** Check if the currents boxes are bigger than the others boxes 
		@param boxes boxes to compare
		@return true if current is bigger else false
	*/
		public boolean isBigger(CollisionsBoxes boxes) {
			return (this.circle.getRadius() > boxes.circle.getRadius());
		}

	/** Test if box and circle is collide with another 
		@param c collisions boxes to test
	*/
		public boolean isColliding(CollisionPoint c) {
			return true;
		}

	/** @see Collision */
	public boolean isColliding(CollisionBox c) {
		return (box.isColliding(c) && circle.isColliding(c));
	}

	/** @see Collision */
	public boolean isColliding(CollisionCircle c) {
		return true;
	}

	}