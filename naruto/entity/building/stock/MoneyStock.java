package com.ditedo.kagenoshinobi.naruto.entity.building.stock;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;
import com.ditedo.kagenoshinobi.naruto.entity.building.ResourceBuilding;

/**
 * Created by ditedo on 26/06/15.
 */
public class MoneyStock extends ResourceBuilding {
    public MoneyStock(Position position, Sprite sprite, Characteristic charac, Behavior behavior, int maxStock) {
        super(position, sprite, charac, behavior, maxStock);
    }
}
