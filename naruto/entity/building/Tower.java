package com.ditedo.kagenoshinobi.naruto.entity.building;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.*;
import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

public class Tower extends FightingBuilding {
	public Tower(Position position, Sprite sprite, Behavior behavior) {
		super(position, sprite, new Characteristic(new BasicDamage(0), new BasicLifePoint(100)), behavior);
	}
}