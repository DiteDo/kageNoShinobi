package com.ditedo.kagenoshinobi.naruto.entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;

import com.ditedo.kagenoshinobi.naruto.*;

public abstract class Entity {
	//ATTRIBUTES
	/** Type of action that the entity doing. Use to print corresponding sprite */
	public static enum ActionType {
		WAIT(0), MOVE(0), FIGHT(4);

		private int type;

		ActionType(int type) {
			this.type = type;
		}

		public int getType() {
			return type;
		}
	}

	/** Position of the entity */
	protected Position position;
	/** Sprite to draw on screen */
	protected Sprite sprite;
	/** Current frame of sprite */
	protected int currentFrame = 0;
	/** Current action entity */
	protected ActionType actionType = actionType = ActionType.WAIT;

	//CONSTRUCTOR
	public Entity() {
	}

	public Entity(Position position, Sprite sprite) {
		this.position = position;
		this.sprite = sprite;
	}

	//METHODS
	/**
	 * ***********************GET**********************
	 */

	/**
	 *  Give entity's sprite
	 * 	@return Sprite
	 */
	public Sprite getSprite() {return this.sprite;}

	/**
	 * 	Give center entity's position
	 *	@return position
	 */
	public Position getPosition() {return this.position;}

	/**
	 * 	Give sprite's position to print sprite. Center of sprite sub half width and half height to get top left coordinate
	 * 	@return sprite's position to print sprite
	 */
	public Position getPositionSprite() {
		int x = (int)this.position.getX() - this.sprite.getSpriteWidth() / 2;
		int y = (int)this.position.getY() - this.sprite.getSpriteHeight() / 2;
		return new Position(x, y);
	}

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
	 * Set the current action type
	 * @param type new action type
	 */
	public void setActionType(ActionType type) {
		this.actionType = type;
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
	public void draw(Canvas canvas) {
		currentFrame = sprite.draw(canvas, (int) getPositionSprite().getX(), (int) getPositionSprite().getY(), currentFrame, 0, actionType.getType());
	}

	/**
	 * Update entity's actions
	 */
	public void update(Canvas canvas) {
		++currentFrame;
		draw(canvas);
	}
}
