package com.ditedo.kagenoshinobi.naruto.entity.behavior;

import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.collision.CollisionsBoxes;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;

import java.util.ArrayList;

/**
 * Created by ditedo on 04/06/15.
 * Set the current frame to 0 and nothing else.
 */
public class PassiveBehavior implements Behavior {

    @Override
    public void setReachBoxes(CollisionsBoxes reach) {

    }

    @Override
    public CollisionsBoxes getReachBoxes() {
        return null;
    }

    @Override
    public void findTarget(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
    }

    @Override
    public void update(ArrayList<ActiveEntity> targets, ActiveEntity entity, Canvas canvas) {
        entity.setActionType(Entity.ActionType.WAIT);
        entity.setCurrentFrame(0);
    }
}
