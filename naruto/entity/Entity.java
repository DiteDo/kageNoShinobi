package com.ditedo.kagenoshinobi.naruto.entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;

import com.ditedo.kagenoshinobi.naruto.*;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;

public abstract class Entity {
	//ATTRIBUTES
	/** Position of the entity */
	protected Position position;
	/** Collision box */
	protected CollisionBox box;
	/** Current frame of sprite */
	protected int currentFrame = 0;

	//CONSTRUCTOR
	public Entity() {
	}

	public Entity(Position position, CollisionBox box) {
		this.position = position;
		this.box = box;
	}

	//METHODS
	/**
	 * ***********************GET**********************
	 */

	/** Give collision box */
	public CollisionBox getBox() {
		return this.box;
	}

	/**
	 * 	Give center entity's position
	 *	@return position
	 */
	public Position getPosition() {return this.position;}

	/**
	 * Give the current frame
	 * @return current frame
	 */
	public int getCurrentFrame() {return this.currentFrame;}


	/**
	 * ***********************SET**********************
	 */

	/** Set new entity position
	 @param x set x position
	 @param y set y position
	 */
	public void setPosition(double x, double y) {
		this.position.setY(y);
		this.position.setX(x);
	}

	/**
	 * Set the current frame
	 * @param currentFrame new current frame
	 */
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	/**
	 * ***********************OTHERS**********************
	 */

	/**
	 * Draw sprite on canvas
	 */
	public abstract void draw(Canvas canvas);
}
