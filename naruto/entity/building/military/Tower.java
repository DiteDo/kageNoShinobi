package com.ditedo.kagenoshinobi.naruto.entity.building.military;

import android.graphics.Bitmap;

import com.ditedo.kagenoshinobi.naruto.GamePhase;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.*;
import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

import java.util.HashMap;

public class Tower extends FightingBuilding {
	public Tower(Position position, HashMap<GamePhase.BitmapName, Bitmap> bitmaps, Behavior behavior) {
		super(position, new Sprite(new Position(0, 0), bitmaps.get(GamePhase.BitmapName.TOWER), 1, 1), new Characteristic(new BasicDamage(0), new BasicLifePoint(100)), behavior);
	}
}