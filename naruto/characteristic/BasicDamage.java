package com.ditedo.kagenoshinobi.naruto.characteristic;

public class BasicDamage implements FightingCharacteristic {
	//ATTRIBUTES
	/** Damage's attack */
	protected int damages;

	//CONSTRUCTOR
	/** Create a basic damage instance 
		@param damages damage's attack
	*/
	public BasicDamage(int damages) {
		this.damages = damages;
	}

	//METHODS
	/** @see FightingCharacteristic#getDamages */
		public int getDamages() {return this.damages;}

	/** @see FightingCharacteristic#setDamages */
		public void setDamages(int damagesPoint) {this.damages = damagesPoint;}
}