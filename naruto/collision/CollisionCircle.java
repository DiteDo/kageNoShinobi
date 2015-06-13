package com.ditedo.kagenoshinobi.naruto.collision;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Distance;

public class CollisionCircle implements Collision {
	//ATTRIBUTES
	/** Circle center*/
	Position center;
	/**radius circle*/
	private double radius;
	
	//CONSTRUCTOR
	/**	Construct a collision circle
		@param center circle center
		@param radius the radius circle
	*/
		public CollisionCircle(Position center, double radius) {
			this.center = center;
			this.radius = radius;
		}

	//METHODS
		/** Give the x center of the circle */
		public double getX() {return this.center.getX();}

		/** Give the y center of the circle */
		public double getY() {return this.center.getY();}

	/** Give center of circle.
		@return center of circle 
	*/
		public Position getCenter() {return this.center;}

	/**	Give radius circle
		@return radius circle
	*/
		public double getRadius() {return this.radius;}

	/** @see Collision#isColliding(CollisionPoint) */
		public boolean isColliding(CollisionPoint p) {
			double distance = Distance.calc(this.getCenter(), p.position);

			if (distance > this.radius * this.radius)
				return false;
			return true;
		}

		private boolean ProjectionOnSegment(int Cx,int Cy,int Ax,int Ay,int Bx,int By) {
			int ACx = Cx-Ax;
			int ACy = Cy-Ay; 
			int ABx = Bx-Ax;
			int ABy = By-Ay; 
			int BCx = Cx-Bx;
			int BCy = Cy-By; 
			int s1 = (ACx*ABx) + (ACy*ABy);
			int s2 = (BCx*ABx) + (BCy*ABy); 
			if (s1*s2>0)
				return false;
			return true;
		}

	/**	@see Collision#isColliding(CollisionBox) */
		public boolean isColliding(CollisionBox box) {
			if (isColliding(new CollisionPoint((int)box.getX(), (int)box.getY())) ||
				isColliding(new CollisionPoint((int)box.getX() + box.getWidth() , (int)box.getY())) ||
				isColliding(new CollisionPoint((int)box.getX(), (int)box.getY() + box.getHeight())) || 
				isColliding(new CollisionPoint((int)box.getX() + box.getWidth(), (int)box.getY() + box.getHeight())))
				return true;

			if (box.isColliding(new CollisionPoint(this.center)))
				return true;

			int cX = (int)this.center.getX();
			int cY = (int)this.center.getY();
			int bX = (int)box.getX();
			int bY = (int)box.getY();
			int bWidth = bX + box.getWidth();
			int bHeight = bY + box.getHeight();
			boolean PV = ProjectionOnSegment(cX, cY, bX, bY, bX, bHeight);
			boolean PH = ProjectionOnSegment(cX, cY, bX, bY, bWidth, bY); 
			if (PV || PH)
				return true; 
			return false; 
		}

	/**	@see Collision#isColliding(CollisionCircle) */
		public boolean isColliding(CollisionCircle c) {
			double distance = Distance.calc(this.getCenter(), c.getCenter());

			if (distance > (this.radius + c.getRadius()) * (this.radius + c.getRadius()))
				return false;
			return true;
		}
	}