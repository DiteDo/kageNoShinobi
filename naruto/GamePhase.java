package com.ditedo.kagenoshinobi.naruto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.ditedo.kagenoshinobi.GameView;
import com.ditedo.kagenoshinobi.R;
import com.ditedo.kagenoshinobi.naruto.clan.Clan;
import com.ditedo.kagenoshinobi.naruto.clan.NoClan;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionPoint;
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
    public static enum BitmapName{FLOOR, TOWER, HEADQUARTER, FOOD_PRODUCT;}

    private Sprite floor;
    private Map map;

    protected HashMap<BitmapName, Bitmap> bitmaps;
    protected HashMap<ClanName, Clan> clans;

    protected Entity selectedEntity;
    protected ArrayList<ActiveEntity> targets;
    protected Movable buildings[];
    protected Character characters[];

    //CONSTRUCTOR
    public GamePhase(GameView view) {
        this.clans = new HashMap<>();
        this.bitmaps = new HashMap<>();
        this.buildings = new Building[3];
        this.characters = new Character[2];
        initClans(view);
        loadBitmap(view);
        this.map = new Map(floor);
        initEntity();
    }

    /**
     * Load sprites
     * @param view
     */
    private void loadBitmap(GameView view) {
        bitmaps.put(BitmapName.FLOOR, BitmapFactory.decodeResource(view.getResources(), R.drawable.sol_carre));
        bitmaps.put(BitmapName.HEADQUARTER, BitmapFactory.decodeResource(view.getResources(), R.drawable.bat2));
        bitmaps.put(BitmapName.TOWER, BitmapFactory.decodeResource(view.getResources(), R.drawable.bat));
        bitmaps.put(BitmapName.FOOD_PRODUCT, BitmapFactory.decodeResource(view.getResources(), R.drawable.bat2));


        this.floor = new Sprite(new Position(0, 0), bitmaps.get(BitmapName.FLOOR), 1, 1);
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
        for (ActiveEntity entity : targets) {
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

    public void onTouch(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {

        }
    }
    /**
     * Initialize entities and their behavior
     */
    protected abstract void initEntity();
}
