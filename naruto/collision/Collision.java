package com.ditedo.kagenoshinobi.naruto.collision;

public interface Collision {
	/** Test if there is a collide with a collision point object 
		@param c collision object to test
		@return true if is colliding else false
	*/
	public boolean isColliding(CollisionPoint c);

	/** Test if there is a collide with a collision box object 
		@param c collision object to test
		@return true if is colliding else false
	*/
	public boolean isColliding(CollisionBox c);

	/** Test if there is a collide with a collision circle object 
		@param c collision object to test
		@return true if is colliding else false
	*/
	public boolean isColliding(CollisionCircle c);
}