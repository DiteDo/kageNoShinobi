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
public class PassiveBehavior extends Behavior {
    /**
     * Do nothing. Wait
     * @param targets targets to update action
     * @param entity entity to update
     */
    @Override
    public void update(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
        entity.setActionType(ActiveEntity.ActionType.WAIT);
        entity.setCurrentFrame(0);
    }
}
