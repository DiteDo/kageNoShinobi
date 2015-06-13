package com.ditedo.kagenoshinobi.naruto.entity.building;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.HitEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Movable;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

/**
 * Created by ditedo on 04/06/15.
 */
public class Building extends Movable implements HitEntity {
    //CONSTRUCTOR
    public Building(Position position, Sprite sprite, Characteristic charac, Behavior behavior) {
        super(position, sprite, behavior, charac);
        this.setPosition(position.getX(), position.getY());
    }

    //METHODS
    /**
     * Do nothing. Building can't move
     */
    @Override
    public void move(ActiveEntity target) {
        this.actionType = ActionType.WAIT;
    }

    /**
     * @see com.ditedo.kagenoshinobi.naruto.entity.character.Unit#sufferDamages(int)
     */
    @Override
    public void sufferDamages(int damages) {
        this.charac.subCurrentLife(damages);
    }

    /**
     * @see com.ditedo.kagenoshinobi.naruto.entity.character.Unit#beNurse(int)
     */
    @Override
    public void beNurse(int life) {
        this.charac.addCurrentLife(life);
    }
}
