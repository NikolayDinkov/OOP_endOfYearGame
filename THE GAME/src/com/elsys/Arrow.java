package com.elsys;

public class Arrow extends Item implements Usable {
    int dmg;

    Arrow(String name, int dmg) {
        super(name, false);
        this.dmg = dmg;
    }

    @Override
    public void use(Player player) {

    }
}
