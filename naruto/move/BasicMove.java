package com.ditedo.kagenoshinobi.naruto.move;

import com.ditedo.kagenoshinobi.MainActivity;
import com.ditedo.kagenoshinobi.naruto.Distance;
import com.ditedo.kagenoshinobi.naruto.Position;

public class BasicMove implements Move {
	//ATTRIBUTS
	/** Default speed */
	public static final int DEFAULT_SPEED = 3;
	/** Speed moving */
	protected int speed;
	/** can move if true */
	protected boolean canMove;

	//CONSTRUCTOR
	/**create a BasicMove with speed define
		@param speed speed to move
	*/
		public BasicMove(int speed) {
			this.speed = speed;
			this.canMove = true;
		}

		/** Create a BasicMove with default speed */
		public BasicMove() {
			this.speed = DEFAULT_SPEED;
			canMove = true;
		}

	/** @see Move#move*/
		public double move(Position current, Position dest) {
			double px = dest.getX() - current.getX();
			double py = dest.getY() - current.getY();
			double angleRadian = Math.atan2(py, px);
			double dx = speed * Math.cos(angleRadian);
			double dy = speed * Math.sin(angleRadian);

			current.setX(current.getX() + dx);
			current.setY(current.getY() + dy);
			return angleRadian;
		}
	}