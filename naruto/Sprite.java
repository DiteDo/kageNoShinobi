package com.ditedo.kagenoshinobi.naruto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;

/**
 * Created by ditedo on 01/06/15.
 */
public class Sprite {
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

    public static int[] DIRECTION_TO_ANIMATION_MAP = { 2, 3, 1, 0 };

    //CONSTRUCTOR
    public Sprite(Bitmap bmp, int rows, int columns) {
       // super(context);
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
    public int getSpriteWidth() {return  this.width;}

    /** Give height for one sprite
     * @return height for one sprite
     */
    public int getSpriteHeight() {return  this.height;}

    /**
     * Draw sprite on screen
     * @param c canvas to screen
     * @param x x position
     * @param y y position
     * @return next current frame
     */
    public int draw(Canvas c, int x, int y, int currentFrame, int directionRows, int type) {
        currentFrame = currentFrame % this.bmp_columns;
        int srcX = currentFrame * this.width;
        int srcY = directionRows * height + (type * height);
        Rect src = new Rect(srcX, srcY, srcX + this.width, srcY + this.height);
        Rect dest = new Rect(x, y, x + this.width, y + this.height);

        c.drawBitmap(this.tileset, src, dest, null);

        return currentFrame;
    }
}
