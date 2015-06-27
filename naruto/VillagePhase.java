package com.ditedo.kagenoshinobi.naruto;

import com.ditedo.kagenoshinobi.GameView;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.MovingBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.PassiveBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.ProductionBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.building.product.ProductFoodBuilding;
import com.ditedo.kagenoshinobi.naruto.entity.building.military.Tower;
import com.ditedo.kagenoshinobi.naruto.entity.character.Genin;

import java.util.ArrayList;

/**
 * Created by ditedo on 10/06/15.
 */
public class VillagePhase extends GamePhase {

    public VillagePhase(GameView view) {
        super(view);
    }

    @Override
    protected void initEntity() {
        this.buildings[0] = new Tower(new Position(26, 26), bitmaps, new PassiveBehavior());
        this.buildings[1] = new Tower(new Position(100, 650), bitmaps, new PassiveBehavior());
        this.buildings[2] = new ProductFoodBuilding(new Position(1200, 500), bitmaps, new ProductionBehavior(), 100, 1000);
        this.characters[0] = new Genin(new Position(500, 500), clans.get(ClanName.NOCLAN), new PassiveBehavior());
        this.characters[1] = new Genin(new Position(600, 200), clans.get(ClanName.NOCLAN), new MovingBehavior());
        targets = new ArrayList<>();
        targets.add(buildings[0]);
        targets.add(buildings[1]);
        targets.add(buildings[2]);
        targets.add(characters[0]);
        targets.add(characters[1]);

      
    }

}
