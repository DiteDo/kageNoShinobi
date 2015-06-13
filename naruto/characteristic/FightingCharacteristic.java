package com.ditedo.kagenoshinobi.naruto.characteristic;

public interface FightingCharacteristic {
	//METHODS
	/** Give damage point
		@return damages attack
	*/
		public int getDamages();

	/** Set new damage point
		@param damagesPoint new damage point
	*/
		public void setDamages(int damagesPoint);
}