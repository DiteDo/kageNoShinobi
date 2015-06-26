package com.ditedo.kagenoshinobi.naruto.entity.behavior;

import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.RandomFunction;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionsBoxes;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;

import java.util.ArrayList;

/**
 * Created by ditedo on 04/06/15.
 * Moving behavior move the entity to different random place in loop
 */
public class MovingBehavior extends Behavior {
    //ATTRIBUTES

    /**
     * Find a random place to move
     * @param targets all targets
     * @param entity entity to set target
     */
    @Override
    public void findTarget(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
        int index = RandomFunction.randInt(0, targets.size() - 1);
        target = targets.get(index);
    }

    /**
     * Move to a random target in loop
     * @param targets targets to update action
     * @param entity entity to update
     */
    @Override
    public void update(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
        if (target != null) {
            if (entity.getBox().isColliding(target.getBox())) {
                findTarget(targets, entity);
            } else {
                entity.move(target);
                entity.setActionType(ActiveEntity.ActionType.MOVE);
            }
        } else {
            findTarget(targets, entity);
        }
    }
}
