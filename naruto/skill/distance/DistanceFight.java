package com.ditedo.kagenoshinobi.naruto.skill.distance;

import android.content.Context;
import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.move.*;
import com.ditedo.kagenoshinobi.naruto.*;
import com.ditedo.kagenoshinobi.naruto.collision.*;
import com.ditedo.kagenoshinobi.naruto.entity.*;
import com.ditedo.kagenoshinobi.naruto.skill.Skill;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import java.util.ArrayList;

public abstract class DistanceFight extends Skill {
	//CONSTRUCTOR
	/** Construct a simple instance of distance skill */
	public DistanceFight() {
		super();
	}
	
	/** Construct a distance skill 
		@see Skill
	*/
		public DistanceFight(Position position, Characteristic charac, CollisionBox box, CollisionsBoxes reach, Move move) {
			super(position, charac, box, reach);
			this.move = move;
		}
	}