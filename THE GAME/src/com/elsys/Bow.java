package com.elsys;

public class Bow extends Item implements Usable, Weapon{
    int bowDMG;


    Bow(String name, int bowDMG) {
        super(name, false);
        this.bowDMG = bowDMG;
    }

    @Override
    public void use(Player player) {

    }
}
