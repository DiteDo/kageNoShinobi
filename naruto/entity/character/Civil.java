package com.ditedo.kagenoshinobi.naruto.entity.character;

import android.content.Context;

import com.ditedo.kagenoshinobi.naruto.Position;
import com.ditedo.kagenoshinobi.naruto.Sprite;
import com.ditedo.kagenoshinobi.naruto.characteristic.Characteristic;
import com.ditedo.kagenoshinobi.naruto.collision.CollisionBox;
import com.ditedo.kagenoshinobi.naruto.entity.behavior.MovingBehavior;
import com.ditedo.kagenoshinobi.naruto.move.BasicMove;
import com.ditedo.kagenoshinobi.naruto.move.Move;

/**
 * Created by ditedo on 04/06/15.
 */
public final class Civil extends Character{
    //CONSTRUCTOR
    public Civil(Position position, Sprite sprite) {
        super(position, sprite, new Characteristic(), new BasicMove(), new MovingBehavior());
    }
}
