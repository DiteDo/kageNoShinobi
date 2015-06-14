package com.ditedo.kagenoshinobi.naruto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.ditedo.kagenoshinobi.GameView;
import com.ditedo.kagenoshinobi.R;
import com.ditedo.kagenoshinobi.naruto.clan.Clan;
import com.ditedo.kagenoshinobi.naruto.clan.NoClan;
import com.ditedo.kagenoshinobi.naruto.entity.ActiveEntity;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;
import com.ditedo.kagenoshinobi.naruto.entity.Movable;
import com.ditedo.kagenoshinobi.naruto.entity.building.Building;
import com.ditedo.kagenoshinobi.naruto.entity.character.Character;
import com.ditedo.kagenoshinobi.naruto.map.Map;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ditedo on 09/06/15.
 */
public abstract class GamePhase {

    //ATTRIBUTES
    protected enum ClanName{NOCLAN, NARA, UCHIHA;}
    protected enum BuildingName{TOWER, HEADQUARTER;}

    private GameView gameView;
    private Sprite floor;
    private Map map;
    protected FrameLayout gameLayout;

    protected HashMap<BuildingName, Sprite> buildingSprites;
    protected HashMap<ClanName, Clan> clans;

    protected Entity selectedEntity;
    protected ArrayList<ActiveEntity> targets;
    protected Movable buildings[];
    protected Character characters[];

    //CONSTRUCTOR
    public GamePhase(GameView view, FrameLayout gameLayout, Context context) {
        this.gameView = view;
        this.gameLayout = gameLayout;
        this.clans = new HashMap<>();
        this.buildingSprites = new HashMap<>();
        this.buildings = new Building[2];
        this.characters = new Character[2];
        initClans(view);
        initSprite(view);
        this.map = new Map(floor);
        initEntity();
    }

    /**
     * Load sprites
     * @param view
     */
    private void initSprite(GameView view) {
        Bitmap floor = BitmapFactory.decodeResource(view.getResources(), R.drawable.sol_carre);
        Bitmap tower = BitmapFactory.decodeResource(view.getResources(), R.drawable.bat2);
        Bitmap headquarter = BitmapFactory.decodeResource(view.getResources(), R.drawable.bat);

        this.floor = new Sprite(floor, 1, 1);
        buildingSprites.put(BuildingName.TOWER, new Sprite(tower, 1, 1));
        buildingSprites.put(BuildingName.HEADQUARTER, new Sprite(headquarter, 1, 1));
    }

    /**
     * Initialize all clan
     * @param view
     */
    private void initClans(GameView view) {
        Bitmap genin = BitmapFactory.decodeResource(view.getResources(), R.drawable.sprite);

        clans.put(ClanName.NOCLAN, new NoClan(genin));
    }


    /**
     * Update all entites
     */
    public void update() {
        Object entitiesArray[] = targets.toArray();
        for (int i = 0; i < targets.size(); i++) {
            ActiveEntity entity = (ActiveEntity)entitiesArray[i];
            if (entity.isAlive())
                entity.update(targets);
        }
    }
    /**
     * Draw map
     * @param canvas
     */
    public void draw(Canvas canvas) {
        map.draw(canvas, targets);
        for (ActiveEntity entity : targets) {
            entity.draw(canvas);
        }
    }

    /**
     * Initialize entities and their behavior
     */
    protected abstract void initEntity();
}
