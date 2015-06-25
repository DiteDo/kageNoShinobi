package com.ditedo.kagenoshinobi.naruto;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.entity.Entity;

/**
 * Created by ditedo on 01/06/15.
 */
public class Sprite extends Entity {
    //ATTRIBUTES
    /** Picture rows */
    private int bmp_rows;
    /** Picture columns */
    private int bmp_columns;
    /** Sprite sheet with all sprite */
    private Bitmap tileset;
    /** Width for one sprite */
    private int width;
    /** Height for one sprite */
    private int height;
    /** Rect to print on canvas */
    private Rect dest;
    /** Rect to pick up on tileset */
    private Rect src;

    public static int[] DIRECTION_TO_ANIMATION_MAP = { 2, 3, 1, 0 };

    //CONSTRUCTOR
    public Sprite(Position position, Bitmap bmp, int rows, int columns) {
        super(position, new CollisionBox(position, bmp.getWidth() / columns, bmp.getHeight() / rows));
        this.tileset = bmp;
        this.bmp_rows = rows;
        this.bmp_columns = columns;
        this.width = bmp.getWidth() / columns;
        this.height = bmp.getHeight() / rows;
    }

    //METHODS
    /** Give bitmap */
    public Bitmap getBitmap() {
        return this.tileset;
    }
    /** Give width for one sprite
     * @return width for one sprite
     */
    public int getWidth() {return  this.width;}

    /** Give height for one sprite
     * @return height for one sprite
     */
    public int getHeight() {return  this.height;}

    /**
     * Draw sprite on screen
     * @param c canvas to screen
     * @param x x position
     * @param y y position
     * @return next current frame
     */
    public int update(int x, int y, int currentFrame, int directionRows, int type) {
        position.setX(x + width / 2);
        position.setY(y + height / 2);
        currentFrame = currentFrame % this.bmp_columns;
        int srcX = currentFrame * this.width;
        int srcY = directionRows * height + (type * height);
        src = new Rect(srcX, srcY, srcX + this.width, srcY + this.height);
        dest = new Rect(x, y, x + this.width, y + this.height);

        return currentFrame;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.tileset, src, dest, null);
    }
}
