package com.ditedo.kagenoshinobi.naruto.entity;

import android.content.Context;
import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

import java.util.ArrayList;

/**
 * Created by ditedo on 07/06/15.
 */
public abstract class ActiveEntity extends Entity {
    //ATTRIBUTES
    /** Behavior of the entity */
    protected Behavior behavior;
    /** Collision box on the floor */
    protected CollisionBox box;
    /** Entity characteristic */
    protected Characteristic charac;
    /** Can act or not */
    protected boolean canAct = true;

    //CONSTRUCTOR
    public ActiveEntity() {
        super();
    }

    public ActiveEntity(Position position, Sprite sprite, Behavior behavior, Characteristic charac) {
        super(position, sprite);
        this.box = new CollisionBox(position, sprite.getSpriteWidth(), sprite.getSpriteWidth() / 2);
        this.behavior = behavior;
        this.charac = charac;
    }

    //METHODS
    /**
     * ***********************GET**********************
     */


    /** Give collision box */
    public CollisionBox getBox() {
        return this.box;
    }

    /**
     * 	Give characteristic entity
     @return characteristic entity
     */
    public Characteristic getCharacteristic() {return this.charac;}

    /**
     * Check if the entity can act or not
     * @return true if can else false
     */
    public boolean canAct() {return canAct;}

    /** Check if is alive
     @return true if current life > 0 else false
     */
    public boolean isAlive() {
        return (this.charac.getCurrentLife() > 0);
    }

    /**
     * Give entity's behavior
     * @return entity's behavior
     */
    public Behavior getBehavior() {
        return this.behavior;
    }

    /**
     * ***********************SET**********************
     */

    /**
     * 	Give sprite's position to print sprite
     * 	@return sprite's position to print sprite
     */
    @Override
    public Position getPositionSprite() {
        int x = (int)this.position.getX() - this.box.getWidth() / 2;
        int y = (int)this.position.getY() + this.box.getHeight() / 2 - this.sprite.getSpriteHeight();
        return new Position(x, y);
    }

    /**
     * Set if the entity can act or not
     * @param canAct true to act else false
     */
    public void setCanAct(boolean canAct) {this.canAct = canAct;}

    /**
     * ***********************OTHERS**********************
     */

    /**
     * Kill an entity
     */
    public void delete() {
        this.charac.subCurrentLife(this.charac.getMaxLife());
    }

    /**
     * Move if possible
     * @param target move to target position
     */
    public abstract void move(ActiveEntity target);

    /**
     * Fight if is possible
     * @param target target to hit
     */
    public void fight(ActiveEntity target) {}

    /** Update actions
     *	@param targets targets to fight
     *
     *	@return false if there are no any targets
     */
    public boolean update(ArrayList<ActiveEntity> targets) {
        actionType = ActionType.WAIT;
        behavior.update(targets, this);
        super.update();
        return true;
    }
}
