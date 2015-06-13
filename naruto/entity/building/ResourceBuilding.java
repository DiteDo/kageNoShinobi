package com.ditedo.kagenoshinobi.naruto.entity.building;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

/**
 * Created by ditedo on 06/06/15.
 */
public class ResourceBuilding extends Building {
    //ATTRIBUTES
    /** Max stock size */
    protected int maxStock;
    /** Current stock */
    protected int currentStock;

    //CONSTRUCTOR
    public ResourceBuilding(Position position, Sprite sprite, Characteristic charac, Behavior behavior, int maxStock) {
        super(position, sprite, charac, behavior);
        this.maxStock = maxStock;
        this.currentStock = 0;
    }
}
