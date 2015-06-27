package com.ditedo.kagenoshinobi.naruto.entity.building.product;

import android.graphics.Bitmap;

import com.ditedo.kagenoshinobi.naruto.GamePhase;
import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.BasicDamage;
import com.ditedo.kagenoshinobi.naruto.characteristic.BasicLifePoint;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

import java.util.HashMap;

/**
 * Created by ditedo on 26/06/15.
 */
public class ProductFoodBuilding extends ProductionBuilding {
    //CONSTRUCTOR
    public ProductFoodBuilding(Position position, HashMap<GamePhase.BitmapName, Bitmap> bitmaps, Behavior behavior, int maxStock, long timeToProduct) {
        super(position, new Sprite(new Position(0, 0), bitmaps.get(GamePhase.BitmapName.FOOD_PRODUCT), 1, 1), new Characteristic(new BasicDamage(0), new BasicLifePoint(100)), behavior, maxStock, timeToProduct);
    }
}
