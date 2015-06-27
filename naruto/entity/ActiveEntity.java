package com.ditedo.kagenoshinobi.naruto.entity;

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
    /** Type of action that the entity doing. Use to print corresponding sprite */
    public static enum ActionType {
        WAIT(0), MOVE(0), FIGHT(4);

        private int type;

        ActionType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
    /** Behavior of the entity */
    protected Behavior behavior;
    /** Entity characteristic */
    protected Characteristic charac;
    /** Sprite to draw on screen */
    protected Sprite sprite;
    /** Can act or not */
    protected boolean canAct = true;
    /** Current action entity */
    protected ActionType actionType = actionType = ActionType.WAIT;
    /** Row int sprite sheet to print sprite */
    protected int directionRows = 0;
    /** Time to built this entity */
    private long buildTime;

    //CONSTRUCTOR
    public ActiveEntity() {
        super();
    }

    /**
     * Create an Active entity
     * @see Entity#Entity(Position, CollisionBox)
     * @param sprite sprite of this
     * @param behavior behavior of this
     * @param charac lifes and damages point of this
     * @param buildTime time to build this
     */
    public ActiveEntity(Position position, Sprite sprite, Behavior behavior, Characteristic charac, long buildTime) {
        super(position, new CollisionBox(position, sprite.getWidth(), sprite.getWidth() / 2));
        this.sprite = sprite;
        this.behavior = behavior;
        this.charac = charac;
        this.buildTime = buildTime;
    }

    //METHODS
    /**
     * ***********************GET**********************
     */

    /**
     * Give time to built this entity
     * @return give time to built this entity
     */
    public long getBuildTime() {
        return buildTime;
    }

    /**
     *  Give entity's sprite
     * 	@return Sprite
     */
    public Sprite getSprite() {return this.sprite;}

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
     * 	Give sprite's position to print sprite
     * 	@return sprite's position to print sprite
     */
    public Position getPositionSprite() {
        return sprite.getPosition();
    }

    /**
     * ***********************SET**********************
     */

    /**
     * Set the current action type
     * @param type new action type
     */
    public void setActionType(ActionType type) {
        this.actionType = type;
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
    public void update(ArrayList<ActiveEntity> targets) {
        int spriteX = (int) position.getX() - box.getWidth() / 2;
        int spriteY = (int) position.getY() + box.getHeight() / 2 - sprite.getHeight();
        ++currentFrame;
        actionType = ActionType.WAIT;
        behavior.update(targets, this);
        currentFrame = sprite.update(spriteX, spriteY, currentFrame, directionRows, actionType.getType());
    }

    public void draw(Canvas canvas) {
        sprite.draw(canvas);
    }
}
