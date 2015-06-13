package com.ditedo.kagenoshinobi.naruto.skill;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.collision.*;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.entity.*;
import com.ditedo.kagenoshinobi.naruto.entity.character.Character;

public abstract class Skill extends Character {
	//ATTRIBUTES
	/** Reach of the skill */
	protected CollisionsBoxes reachBoxes;

	//CONSTRUCTOR
	/** Create skill without parameter */
	public Skill() {
		super();
	}

	/** Create an instance of skill with parameters
		@param position starting position of skills equals unit's position
		@param charac characteristics of skills
		@param box collisions boxes of skills
		@param reach reach of skills
	*/
	public Skill(Position position, Characteristic charac, CollisionBox box, CollisionsBoxes reach) {
		super();
		this.position = position;
		this.charac = charac;
		this.box = box;
		this.reachBoxes = reach;
	}
	
	//METHODS

	/**
	 * Give reach of the skill
	 * @return reach of the skill
	 */
	public CollisionsBoxes getReachBoxes() {
		return reachBoxes;
	}

	/** Execute the proper behavior of the skill */
	public void fight(HitEntity target, int damages) {
		target.sufferDamages(damages);
	}
	
	/** @see Entity#update */
	public boolean update(ActiveEntity target, int damages) {
		if (this.box.isColliding(target.getBox()))
			this.fight((HitEntity)target, damages);
		else {
			this.move(target);
		}
		return true;
	}

	/** Give a new instance of current skill 
		@param box reach of the skill
		@return new instance of current skill
	*/
		public abstract Skill create(Position position, CollisionBox box);
	}