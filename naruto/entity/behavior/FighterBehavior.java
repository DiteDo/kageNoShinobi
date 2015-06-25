package com.ditedo.kagenoshinobi.naruto.entity.behavior;

import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Distance;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionsBoxes;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;

import java.util.ArrayList;

/**
 * Created by ditedo on 04/06/15.
 */
public class FighterBehavior implements Behavior {
    //ATTRIBUTES
    /** Reach boxes to fight */
    private CollisionsBoxes reachBoxes;
    /** Target to fight */
    private ActiveEntity target;

    //METHODS
    public CollisionsBoxes getReachBoxes() {
        return this.reachBoxes;
    }

    public void setReachBoxes(CollisionsBoxes boxes) {
        this.reachBoxes = boxes;
    }

    @Override
    public void findTarget(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
        double distance = 10000000;
        double targetDistance;

        for (ActiveEntity target : targets) {
            if (target != entity && target.isAlive()) {
                targetDistance = Distance.calc(entity.getPosition(), target.getPosition());
                if (targetDistance < distance) {
                    this.target = target;
                    distance = targetDistance;
                }
            }
        }
    }

    @Override
    public void update(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
        if (entity.canAct()) {
            if (target != null && target.isAlive()) {
                CollisionBox targetBox = target.getBox();
                if (reachBoxes != null && reachBoxes.isColliding(targetBox)) {
                    entity.setActionType(ActiveEntity.ActionType.FIGHT);
                    entity.fight(target);
                } else {
                    entity.setActionType(ActiveEntity.ActionType.MOVE);
                    entity.move(target);
                }
            } else {
                findTarget(targets, entity);
                entity.setActionType(ActiveEntity.ActionType.WAIT);
                entity.setCurrentFrame(0);
            }
        } else
            entity.setActionType(ActiveEntity.ActionType.WAIT);
    }
}
