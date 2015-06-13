package com.ditedo.kagenoshinobi.naruto.move;

import com.ditedo.kagenoshinobi.naruto.Position;

public class NoMove implements Move {

	//CONSTRUCTOR
	/**Create a NoMove instance wich do nothing */
		public NoMove() {}

	/** No move so do nothing
		@see Move#move
	*/
		public double move(Position current, Position dest) {
			return 0;
		}
}