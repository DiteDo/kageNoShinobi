package com.ditedo.kagenoshinobi.naruto.entity;

import android.content.Context;
import android.view.MotionEvent;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.map.Map;

/**
 * Created by ditedo on 04/06/15.
 */
public abstract class Movable extends ActiveEntity {
    //ATTRIBUTES

    //CONSTRUCTOR
    public Movable(Position position, Sprite sprite, Behavior behavior, Characteristic charac) {
        super(position, sprite, behavior, charac);
    }

    //METHODS

    /**
     * Align position to map cells
     * @param x set x position
     * @param y set y position
     */
    @Override
    public void setPosition(double x, double y) {
        int floorWidth = Map.SPRITE_WIDTH;
        int floorHeight = Map.SPRITE_HEIGHT;
        x = (int)x / floorWidth * floorWidth;
        y = (int)y / floorHeight * floorHeight;
        int posX = (int) x + box.getWidth() / 2;
        int posY = (int) y + box.getHeight() / 2;
        posX += (posX % (floorWidth / 2) != 0) ?  floorWidth / 2 : 0;
        posY += (posY % (floorHeight / 2) != 0) ?  floorHeight / 2 : 0;
        super.setPosition(posX, posY);
    }
}
