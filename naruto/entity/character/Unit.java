package com.ditedo.kagenoshinobi.naruto.entity.character;

import android.content.Context;
import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.collision.*;
import com.ditedo.kagenoshinobi.naruto.entity.*;
import com.ditedo.kagenoshinobi.naruto.clan.Clan;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.skill.Skill;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.move.Move;

public abstract class Unit extends Character implements HitEntity {
	//ATTRIBUTES
	/** Enum type of unit */
	public static enum Type {
		GENIN, CHUUNIN, JUUNIN, ANBU;
		/** number of different unit's type */
		public static int SIZE = 4;

		/** Give number of unit's type */
		public int size() {return SIZE;}
	};

	/** Current skill to attack */
	protected Skill skill;
	/** Unit clan */
	protected Clan clan;
	/** */

	//CONSTRUCTOR
	public Unit(Clan clan, Sprite sprite, Position position, Move move, Characteristic charac, Behavior behavior) {
		super(position, sprite, charac, move, behavior);
		this.clan = clan;
		this.skill = clan.getSkill().create(position, box);
		this.behavior.setReachBoxes(this.skill.getReachBoxes());
	}

	//METHODS
	/**
	 * ***********************GET**********************
	 */
	/**
	 * Give behavior reach boxes
	 * @return behavior reach boxes
	 */
	public CollisionsBoxes getReachBoxes() {
		return behavior.getReachBoxes();
	}

	/**
	 * ***********************SET**********************
	 */

	/**
	 * Nurse life
	 * @param life life to add
	 */
	@Override
	public void beNurse(int life) {
		this.charac.addCurrentLife(life);
	}

	/**
	 * Suffer damages
	 * @param damages damages to suffer
	 */
	@Override
	public void sufferDamages(int damages) {
		this.charac.subCurrentLife(damages);
	}

	/**
	 * ***********************OTHERS**********************
	 */
	/** Attack the target with skill */
	@Override
	public void fight(ActiveEntity target) {
		int clanDamages = clan.getCharacteristic().getDamages();
		int unitDamages = charac.getDamages();
		int skillDamages = ((ActiveEntity)skill).getCharacteristic().getDamages();

		this.skill.update(target, clanDamages + unitDamages + skillDamages);
	}

}