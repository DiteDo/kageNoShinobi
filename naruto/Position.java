package com.ditedo.kagenoshinobi.naruto;

public class Position {
	//ATTRIBUTES
	private double x;
	private double y;

	//CONSTRUCTOR
	/**	create a new position
		@param x x position
		@param y y position
	*/
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

	/**	create a new posiotion by copy
		@param position position to copy
	*/
		public Position(Position position) {
			this.x = position.x;
			this.y = position.y;
		}

	//METHODS
	/** Test if this position will be print before second position. Test on the y axe and next x axe
	 * @param position position to test
	 * @return true if this is closest than zero
	 */
	public boolean isBefore(Position position) {
		if (this.y < position.y)
			return true;
		else if (this.y > position.y)
			return false;
		else {
			if (this.x <= position.x)
				return true;
		}
		return false;
	}

	/** get x position */
	public double getX() {return this.x;}

	/** get y position */
	public double getY() {return this.y;}

	/**set x position
		@param x new x position
	*/
		public void setX(double x) {this.x = x;}

	/**set y position
		@param y new y position
	*/
		public void setY(double y) {this.y = y;}

		/** Test if they have the same x and y */
		public boolean equals(Object o) {
			if (o instanceof Position) {
				return (this.x == ((Position)o).x && this.y == ((Position)o).y);
			}
			return false;
		}
	}