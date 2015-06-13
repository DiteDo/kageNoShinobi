package com.ditedo.kagenoshinobi.naruto.clan;


import android.content.Context;
import android.graphics.Bitmap;

import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.character.Unit;
import com.ditedo.kagenoshinobi.naruto.skill.handToHand.Kunai;

public class NoClan extends Clan {
	//CONSTRUCTOR
	public NoClan (Bitmap bmp) {
		super();
		this.charac = new Characteristic();
		this.skill = new Kunai();
		this.pictures.put(Unit.Type.GENIN, bmp);
	}
}