package com.ditedo.kagenoshinobi.naruto.skill.distance;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.*;
import com.ditedo.kagenoshinobi.naruto.skill.Skill;
import com.ditedo.kagenoshinobi.naruto.entity.*;
import com.ditedo.kagenoshinobi.naruto.characteristic.*;
import com.ditedo.kagenoshinobi.naruto.collision.*;
import com.ditedo.kagenoshinobi.naruto.*;
import com.ditedo.kagenoshinobi.naruto.move.BasicMove;

public class ShadowManipulation extends DistanceFight {
	//CONSTRUCTOR
	/** Create an instance of Shadow Manipulation */
	public ShadowManipulation() {
		super();
	}

	/** Create a Shadow Manipulation skill 
		@see DistanceFight
	*/
	public ShadowManipulation(Position position) {
		super(position, new Characteristic(new BasicDamage(0), new BasicLifePoint(0)) ,
			new CollisionBox(position, 10, 10), new CollisionsBoxes(position, 10, 10), new BasicMove());
	}

	//METHODS
	/** @see Skill#create */
	public Skill create(Position position, CollisionBox box) {
		return new ShadowManipulation(position);
	}
	
	/** Block ennemy movement */
	public void fight(ActiveEntity target) {
		target.setCanAct(false);
	}
}