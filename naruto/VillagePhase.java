package com.ditedo.kagenoshinobi.naruto;

import android.content.Context;
import android.widget.RelativeLayout;

import com.ditedo.kagenoshinobi.GameView;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.MovingBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.PassiveBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.building.Tower;
import com.ditedo.kagenoshinobi.naruto.entity.character.Genin;

import java.util.ArrayList;

/**
 * Created by ditedo on 10/06/15.
 */
public class VillagePhase extends GamePhase {

    public VillagePhase(GameView view, RelativeLayout layout, Context context) {
        super(view, layout, context);
    }

    @Override
    protected void initEntity() {
        this.buildings[0] = new Tower(new Position(26, 26), buildingSprites.get(BuildingName.HEADQUARTER), new PassiveBehavior());
        this.buildings[1] = new Tower(new Position(100, 650), buildingSprites.get(BuildingName.TOWER), new PassiveBehavior());
        this.characters[0] = new Genin(new Position(500, 500), clans.get(ClanName.NOCLAN), new PassiveBehavior());
        this.characters[1] = new Genin(new Position(600, 200), clans.get(ClanName.NOCLAN), new MovingBehavior());
        targets = new ArrayList<>();
        targets.add(buildings[0]);
        targets.add(buildings[1]);
        targets.add(characters[0]);
        targets.add(characters[1]);

      
    }

}
