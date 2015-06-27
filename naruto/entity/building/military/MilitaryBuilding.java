package com.ditedo.kagenoshinobi.naruto.entity.building.military;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.entity.building.ResourceBuilding;
import com.ditedo.kagenoshinobi.naruto.entity.character.Unit;

import java.util.ArrayList;

/**
 * Created by ditedo on 26/06/15.
 */
public abstract class MilitaryBuilding extends ResourceBuilding {
    //ATTRIBUTES
    /** Units inside building */
    ArrayList<Unit> units;

    public MilitaryBuilding(Position position, Sprite sprite, Characteristic charac, Behavior behavior, int maxStock) {
        super(position, sprite, charac, behavior, maxStock);
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        if (units.size() < maxStock) {
            units.add(unit);
        }

    }

    @Override
    public void update(ArrayList<ActiveEntity> targets) {
        super.update(targets);
    }
}
