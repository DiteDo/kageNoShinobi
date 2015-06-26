package com.ditedo.kagenoshinobi.naruto.entity.behavior;

import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.collision.Collision;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionsBoxes;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;
import com.ditedo.kagenoshinobi.naruto.move.Move;

import java.util.ArrayList;

/**
 * Created by ditedo on 04/06/15.
 */
public abstract class Behavior {
    /** Target to act */
    public ActiveEntity target;

    public void setTarget(ActiveEntity entity) {
        target = entity;
    }
    /**
     * Set reachBoxes if possible else do nothing
     * @param reach new reach boxes
     */
    public void setReachBoxes(CollisionsBoxes reach) {
    }

    /**
     * Give reach boxes if there is
     * @return reach boxes
     */
    public CollisionsBoxes getReachBoxes() {
        return null;
    }

    /**
     * Find target to move to and fight
     * @param targets all targets
     * @param entity entity to set target
     */
    public void findTarget(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
    }

    /**
     * Update the entity
     * @param targets targets to update action
     * @param entity entity to update
     * @return type of action to draw sprite
     */
    public abstract void update(ArrayList<ActiveEntity> targets, ActiveEntity entity);
}
