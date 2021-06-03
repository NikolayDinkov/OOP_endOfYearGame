package com.elsys;

public class Bomb extends Item implements Usable{
    int toMonsterDMG;

    Bomb(String name, int toMonsterDMG) {
        super(name, true);
        this.toMonsterDMG = toMonsterDMG;
    }

    @Override
    public void use(Player player) {

    }
}
