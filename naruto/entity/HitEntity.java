package com.ditedo.kagenoshinobi.naruto.entity;

/**
 * Created by ditedo on 04/06/15.
 * Interface for entities with health variation
 */
public interface HitEntity {
    /**
     * Sub life points to current life
     * @param damages life to sub
     */
    public void sufferDamages(int damages);

    /**
     * Add life points to current life
     * @param life life to add
     */
    public void beNurse(int life);
}
