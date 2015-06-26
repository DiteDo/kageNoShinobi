package com.ditedo.kagenoshinobi.naruto.entity.behavior;

import com.ditedo.kagenoshinobi.naruto.collision.CollisionsBoxes;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.building.Product;

import java.util.ArrayList;

/**
 * Created by ditedo on 26/06/15.
 */
public class ProductionBehavior extends Behavior {

    @Override
    public void update(ArrayList<ActiveEntity> targets, ActiveEntity entity) {
       ((Product)entity).product();
    }
}
