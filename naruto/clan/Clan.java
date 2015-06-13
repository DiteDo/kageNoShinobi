package com.ditedo.kagenoshinobi.naruto.clan;

import android.graphics.Bitmap;

import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.entity.character.Unit;
import com.ditedo.kagenoshinobi.naruto.skill.Skill;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;

import java.util.HashMap;

public abstract class Clan {
	//ATTRIBUTES
	/** Clan characteristic */
	protected Characteristic charac;
	/** Clan skill*/
	protected Skill skill;
	/** Array with all clan's sprites */
	protected HashMap<Unit.Type, Bitmap> pictures;

	//CONSTRUCTOR
	public Clan() {
		pictures = new HashMap<Unit.Type, Bitmap>();
	}

	//METHODS
	/** Give clan characteristic
		@return clan clan's characteristic
	*/
		public Characteristic getCharacteristic() {return this.charac;}

	/** Give sprites corresponding to Unit's type */
	public Bitmap getBitmap(Unit.Type type) {
		return pictures.get(type);
	}

	/** Give clan skill 
		@return clan skill
	*/
		public Skill getSkill() {return this.skill;}
	}