package com.ditedo.kagenoshinobi.naruto.entity.building;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

/**
 * Created by ditedo on 26/06/15.
 */
public class WoodStock extends ResourceBuilding {
    public WoodStock(Position position, Sprite sprite, Characteristic charac, Behavior behavior, int maxStock) {
        super(position, sprite, charac, behavior, maxStock);
    }
}
