package com.ditedo.kagenoshinobi.naruto.entity.character;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.*;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.move.*;
import com.ditedo.kagenoshinobi.naruto.clan.*;

public class Genin extends Unit {
	//CONSTRUCTOR

	/**
	 * Create a new firs
	 * @param position
	 * @param clan
	 * @param behavior
	 */
	public Genin(Position position, Clan clan, Behavior behavior) {
		super(clan, new Sprite(new Position(0, 0),
				clan.getBitmap(Type.GENIN), 8, 6),
				position, new BasicMove(),
				new Characteristic(new BasicDamage(20), new BasicLifePoint(100)),
				behavior,
				1500);
	}
}