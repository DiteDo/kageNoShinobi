package com.ditedo.kagenoshinobi.naruto.collision;

import com.ditedo.kagenoshinobi.naruto.Position;

public class CollisionPoint implements Collision {
	//ATTRIBUTES
	protected Position position;

	//CONSTRUCTOR
	/** Create a point to test collision */
	public CollisionPoint(Position position) {
		this.position = position;
	}

	/** Create a point to test collision */
	public CollisionPoint(int x, int y) {
		this.position = new Position(x, y);
	}

	//METHODS
	/** @see Collision#isColliding(CollisionPoint) */
	public boolean isColliding(CollisionPoint c) {
		return this.position.equals(c.position);
	}
	
	/** @see Collision#isColliding(CollisionBox) */
	public boolean isColliding(CollisionBox c) {
		return c.isColliding(this);
	}

	/** @see Collision#isColliding(CollisionCircle) */
	public boolean isColliding(CollisionCircle c) {
		return c.isColliding(this);
	}

}