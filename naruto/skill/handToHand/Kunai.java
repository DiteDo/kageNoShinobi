package com.ditedo.kagenoshinobi.naruto.skill.handToHand;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.collision.*;
import com.ditedo.kagenoshinobi.naruto.skill.Skill;
import com.ditedo.kagenoshinobi.naruto.entity.*;
import com.ditedo.kagenoshinobi.naruto.characteristic.*;
import com.ditedo.kagenoshinobi.naruto.*;

public class Kunai extends HandToHand {
	//CONSTRUCTOR

	/** Create an instance of Kunai*/
	public Kunai() {
		super();
	}

	/** Create a kunai skill 
		@see HandToHand
	*/
	public Kunai(CollisionBox box, Position  position) {
		super(position, new Characteristic(new BasicDamage(0), new BasicLifePoint(0)) , box, new CollisionsBoxes(position, box.getWidth(), box.getHeight()));
	}

	//METHODS
	/** @see Skill#create */
	public Skill create(Position position, CollisionBox box) {
		return new Kunai(box, position);
	}

}