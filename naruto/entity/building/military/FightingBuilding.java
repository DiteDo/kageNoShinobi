package com.ditedo.kagenoshinobi.naruto.entity.building.military;

import android.content.Context;
import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionsBoxes;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.entity.building.Building;
import com.ditedo.kagenoshinobi.naruto.entity.character.Unit;

import java.util.ArrayList;

/**
 * Created by ditedo on 04/06/15.
 */
public abstract class FightingBuilding extends Building {
    //ATTRIBUTES
    /** Unit Team */
    protected ArrayList<Unit> unitTeam;
    /** Size max of team */
    protected int sizeTeam;

    //CONSTRUCTOR
    public FightingBuilding(Position position, Sprite sprite, Characteristic charac, Behavior behavior) {
        super(position, sprite, charac, behavior);
        this.unitTeam = new ArrayList<Unit>();
        this.sizeTeam = 3;
    }

    //METHODS
    /**
     * ***********************GET**********************
     */

    /**
     * ***********************SET**********************
     */

    /**
     * Add new unit to team
     * @param unit new unit to add
     */
    public void addUnit(Unit unit) {
        if (unitTeam.size() < 3) {
            unitTeam.add(unit);
            CollisionsBoxes reach = behavior.getReachBoxes();
            if (reach == null || !reach.isBigger(unit.getReachBoxes())) {
                behavior.setReachBoxes(unit.getReachBoxes());
            } else {
                unit.getBehavior().setReachBoxes(reach);
            }
        }
    }

    /**
     * ***********************OTHERS**********************
     */

    /**
     * Fight for each unit of team
     * @param target target to hit
     */
    @Override
    public void fight(ActiveEntity target) {
        this.actionType = ActionType.WAIT;
        for (Unit unit : unitTeam) {
            //unit.update();
            /*unit.fight(target, canvas);
            unit.setActionType(ActionType.FIGHT);
            unit.draw(canvas);*/
        }
    }
}
