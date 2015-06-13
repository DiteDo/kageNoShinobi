package com.ditedo.kagenoshinobi.naruto.characteristic;

public interface LifeCharacteristic {
	//METHODS
	/** Give current life point 
		@return current life point
	*/
		public int getCurrentLife();

	/** Give max life point
		@return give max life point
	*/
		public int getMaxLife();

	/** Add point to current life point until max life 
		@param lifeToAdd life to add
	*/
		public void addCurrentLife(int lifeToAdd);

	/** Sub point to current life point until 0 
		@param lifeToSub life to add
	*/
		public void subCurrentLife(int lifeToSub);
	}