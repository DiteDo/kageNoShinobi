package com.ditedo.kagenoshinobi.naruto.entity.character;

import android.content.Context;
import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.move.Move;

import java.util.ArrayList;

/**
 * Created by ditedo on 04/06/15.
 */
public abstract class Character extends ActiveEntity {
    //ATTRIBUTES
    /** Row int sprite sheet to print sprite */
    private int directionRows = 0;
    /** Angle of the direction */
    private double angle;
    /** Moving object to move */
    protected Move move;

    //CONSTRUCTOR
    public Character() {
        super();
    }

    public Character(Position position, Sprite sprite, Characteristic charac, Move move, Behavior behavior) {
        super(position, sprite, behavior, charac);
        this.move = move;
    }

    //METHODS
    /**
     * ***********************GET**********************
     */

    /**
    * ***********************SET**********************
    */

    /**
     * Set new type of move
     * @param move new type of move
     */
    public void setMove(Move move) {this.move = move;}

    /**
     * ***********************OTHERS**********************
     */

    /**
     * Calculate entity's direction to print corresponding sprite
     */
    private void calcDirection() {
        double dirDouble = angle / (Math.PI / 2) + 2;
        int direction = (int) dirDouble % 4;
        directionRows = Sprite.DIRECTION_TO_ANIMATION_MAP[direction];
    }

    /**
     * Calculate corresponding direction and update
     * @see Entity#update()
     */
    @Override
    public boolean update(ArrayList<ActiveEntity> targets) {
        calcDirection();
        ++currentFrame;
        actionType = ActionType.WAIT;
        behavior.update(targets, this);
        currentFrame = sprite.update((int) getPositionSprite().getX(), (int) getPositionSprite().getY(), currentFrame, directionRows, actionType.getType());
        return true;
    }

    /**
     * Move character and set angle direction
     * @param target move to target position
     */
    @Override
    public void move(ActiveEntity target) {
        Position positionTest = new Position(this.position);
        double angleTmp = move.move(positionTest, target.getPosition());
        CollisionBox boxTest = new CollisionBox(positionTest, box.getWidth(), box.getHeight());
        /*

			Zone zone = map.getZone(positionTest.getX(), positionTest.getY());
			if (zone != null) {
					Entity entity = zone.getEntity();
					if (entity.isColliding(boxTest))
						angleTmp = moveOtherWay();
					else {
						current.setX(positionTest.getX());
						current.setY(positionTest.getY());
			} else {
				current.setX(positionTest.getX());
				current.setY(positionTest.getY());
			}
			 */
        setPosition(positionTest.getX(), positionTest.getY());
        angle = angleTmp;
    }
}
