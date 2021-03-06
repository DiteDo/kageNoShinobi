package com.ditedo.kagenoshinobi.naruto;

import android.content.Context;
import android.widget.FrameLayout;

import com.ditedo.kagenoshinobi.GameView;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.FighterBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.PassiveBehavior;
import com.ditedo.kagenoshinobi.naruto.entity.building.military.Tower;
import com.ditedo.kagenoshinobi.naruto.entity.character.Genin;

import java.util.ArrayList;

/**
 * Created by ditedo on 09/06/15.
 */
public class FightPhase extends GamePhase {
    public FightPhase(GameView view, FrameLayout layout, Context context) {
        super(view);
    }

    @Override
    protected void initEntity() {
        this.buildings[0] = new Tower(new Position(26, 26), bitmaps, new PassiveBehavior());
        this.buildings[1] = new Tower(new Position(100, 650), bitmaps, new FighterBehavior());
        this.characters[0] = new Genin(new Position(500, 500), clans.get(ClanName.NOCLAN), new FighterBehavior());
        this.characters[1] = new Genin(new Position(600, 200), clans.get(ClanName.NOCLAN), new FighterBehavior());
        targets = new ArrayList<>();
        targets.add(buildings[0]);
        targets.add(buildings[1]);
        targets.add(characters[0]);
        targets.add(characters[1]);
    }

}
