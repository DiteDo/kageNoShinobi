package com.ditedo.kagenoshinobi.naruto.entity.building;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.Behavior;

/**
 * Created by ditedo on 26/06/15.
 */
public class ProductionBuilding extends ResourceBuilding implements Product {
    //ATTRIBUTES
    /** start time for a new production */
    protected long startTimeProduct;
    /** End time to add production to stock */
    protected long endTimeProduct;
    /** Production time */
    protected long timeToProduct;
    /** Quantity's production */
    protected int production;

    //CONSTRUCTOR
    public ProductionBuilding(Position position, Sprite sprite, Characteristic charac, Behavior behavior, int maxStock, long timeToProduct) {
        super(position, sprite, charac, behavior, maxStock);
        this.timeToProduct = timeToProduct;
        startTimeProduct = System.currentTimeMillis();
        endTimeProduct = startTimeProduct + timeToProduct;
    }

    //METHODS
    /**
     * Product and add production to stock
     */
    @Override
    public void product() {
        if (System.currentTimeMillis() >= endTimeProduct) {
            startTimeProduct = System.currentTimeMillis();
            endTimeProduct = startTimeProduct + timeToProduct;
            currentStock = (currentStock + production >= maxStock) ? maxStock : currentStock + production;
        }
    }
}
