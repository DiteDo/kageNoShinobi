package com.ditedo.kagenoshinobi.naruto.skill.handToHand;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.*;
import com.ditedo.kagenoshinobi.naruto.move.*;
import com.ditedo.kagenoshinobi.naruto.collision.*;
import com.ditedo.kagenoshinobi.naruto.entity.*;
import com.ditedo.kagenoshinobi.naruto.skill.Skill;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import java.util.ArrayList;

public abstract class HandToHand extends Skill {
	//CONSTRUCTOR
	/** Create a simple instance of hand to hand */
	public HandToHand() {
		super();
	}

	/** Construct an hand to hand skill with parameter.
		Boxes collisions and reach collisions are equals because hand to hand skill doesn't have real reach
		@see Skill
	*/
		public HandToHand(Position position, Characteristic charac, CollisionBox box, CollisionsBoxes reach) {
			super(position, charac, box, reach);
			this.move = new NoMove();
		}

	}