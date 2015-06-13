package com.ditedo.kagenoshinobi.naruto.characteristic;


public class Characteristic implements FightingCharacteristic, LifeCharacteristic {
	//ATTRIBUTES
	/** Fighting characteristic */
	private FightingCharacteristic fighting;
	/** Life characteristic */
	private LifeCharacteristic life;

	//CONSTRUCTOR
	/** Create empty characteristic with zero life and zero damage */
	public Characteristic() {
		this.fighting = new BasicDamage(0);
		this.life = new BasicLifePoint(0);
	}

	/** Create characteristic define 
		@param fighting type of fighting characteristic
		@param life type of life characteristic
	*/
	public Characteristic(FightingCharacteristic fighting, LifeCharacteristic life) {
		this.fighting = fighting;
		this.life = life;
	}

	//METHODS
	/** @see FightingCharacteristic#getDamages */
		public int getDamages() {return this.fighting.getDamages();}

	/** @see FightingCharacteristic#setDamages */
		public void setDamages(int damagesPoint) {this.fighting.setDamages(damagesPoint);}

	/** @see LifeCharacteristic#getMaxLife */
		public int getMaxLife() {return this.life.getMaxLife();}

		/** @see LifeCharacteristic#getCurrentLife */
		public int getCurrentLife() {return this.life.getCurrentLife();}

		/** @see LifeCharacteristic#addCurrentLife */
		public void addCurrentLife(int lifeToAdd) {this.life.addCurrentLife(lifeToAdd);}

		/** @see LifeCharacteristic#subCurrentLife */
		public void subCurrentLife(int lifeToSub) {this.life.subCurrentLife(lifeToSub);}
}