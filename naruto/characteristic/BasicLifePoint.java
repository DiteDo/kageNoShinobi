package com.ditedo.kagenoshinobi.naruto.characteristic;

public class BasicLifePoint implements LifeCharacteristic {
	//ATTRIBUTES
	/** Max life point */
	protected int maxLife;
	/** Current life point */
	protected int currentLife;

	//CONSTRUCTOR
	/** Create a basic life point characteristic 
		@param maxLife total life
	*/
		public BasicLifePoint(int maxLife) {
			this.maxLife = maxLife;
			this.currentLife = maxLife;
		}

	//METHODS
		/** @see LifeCharacteristic#getMaxLife */
		public int getMaxLife() {return this.maxLife;}

		/** @see LifeCharacteristic#getCurrentLife */
		public int getCurrentLife() {return this.currentLife;}

		/** @see LifeCharacteristic#addCurrentLife */
		public void addCurrentLife(int lifeToAdd) {
			int newCurrentLife = this.currentLife + lifeToAdd;
			this.currentLife = (newCurrentLife >= maxLife) ? maxLife : newCurrentLife;
		}

		/** @see LifeCharacteristic#subCurrentLife */
		public void subCurrentLife(int lifeToSub) {
			int newCurrentLife = this.currentLife - lifeToSub;
			this.currentLife = (newCurrentLife <= 0) ? 0 : newCurrentLife;
		}
	}