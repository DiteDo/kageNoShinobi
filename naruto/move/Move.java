package com.ditedo.kagenoshinobi.naruto.move;

import com.ditedo.kagenoshinobi.naruto.Position;

public interface Move {
	//METHODS
	/** Moving entity to destination
		@param current current position
		@param dest destination position
	 	@return radian angle to calculate the direction of sprite to use
	*/
		public double move(Position current, Position dest);
}