package com.ditedo.kagenoshinobi.naruto.map;

import android.graphics.Canvas;

import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.entity.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Map {
	//ATTRIBUTES
	/** Sprite floor width */
	public static int SPRITE_WIDTH;
	/** Sprite floor height */
	public static int SPRITE_HEIGHT;
	/** nbSquareWidth */
	final int NB_SQUARE_WIDTH = 40;
	/** nbSquareHeight */
	final int NB_SQUARE_HEIGHT = 40;
	/** Floor */
	private Sprite floor;
	/** Squares map*/
	private int map[][];

	//CONSTRUCTOR
	public Map(Sprite sprite) {
		map = new int[NB_SQUARE_HEIGHT][];
		for (int i = 0 ; i< NB_SQUARE_HEIGHT; i++) {
			map[i] = new int[NB_SQUARE_WIDTH];
			Arrays.fill(map[i], 0);
		}

		this.SPRITE_WIDTH = sprite.getSpriteWidth();
		this.SPRITE_HEIGHT = sprite.getSpriteHeight();
		this.floor = sprite;
	}

	//METHODS
	/** Update map. Update and print all elements in map */
	public boolean draw(Canvas canvas, ArrayList<ActiveEntity> entities) {
		int startingX = canvas.getWidth() / 2;
		int startingY = 0;
		int spriteWidth = floor.getSpriteWidth();
		int spriteHeight = floor.getSpriteHeight();
		int gapWidth = spriteWidth / 2;
		int gapHeight = spriteHeight /2;

		for (int y = 0; y < NB_SQUARE_HEIGHT; y++) {
			for (int x = 0;x < NB_SQUARE_WIDTH; x++) {
				int posX = x * this.floor.getSpriteWidth();
				int posY = y * this.floor.getSpriteHeight();
				//int posX = startingX + (x -y) * gapWidth;
				//int posY = startingY + (x + y) * gapHeight;
				//if (posX >= (-2 * gapWidth) && posX <= (width + 2 * gapWidth) && posY >= (-2 * gapHeight) && posY <= (height + 2 * gapHeight))
				if (map[y][x] == 0) {
					this.floor.draw(canvas, posX, posY, 0, 0, 0);
				}
			}
		}

		return true;
	}
}