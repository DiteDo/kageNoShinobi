package com.ditedo.kagenoshinobi.naruto.entity.building;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.entity.character.Unit;

import java.util.ArrayList;

/**
 * Train unit for war
 * Created by ditedo on 26/06/15.
 */
public class SchoolingBuilding extends MilitaryBuilding implements Product{
    //ATTRIBUTES
    /** end time to train unit in queue */
    private long endTime;

    //CONSTRUCTOR
    public SchoolingBuilding(Position position, Sprite sprite, Characteristic charac, Behavior behavior, int maxStock) {
        super(position, sprite, charac, behavior, maxStock);
    }

    //METHODS

    /**
     * Give end time to product unit
     * @return give end time to product unit
     */
    public long getEndTime() {
        return endTime;
    }

    /** Add a unit to train */
    public void addToQueue(Unit unit) {
        if (units.size() < maxStock) {
            endTime = System.currentTimeMillis() + unit.getTrainingTime();
            units.add(unit);
        }
    }

    /**
     * Create new unit if time to product is elapsed
     */
    public void product() {
        if (System.currentTimeMillis() >= endTime) {
            try {
                Unit unit = units.get(0);
                units.remove(unit);
                unit.getBehavior().setTarget(null);
            } catch (IndexOutOfBoundsException e) {

            }
        }
    }
}
