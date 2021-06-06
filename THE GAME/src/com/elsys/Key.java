package com.elsys;

public class Key extends Item implements Equippable, GameObject{

    Key(String name) {
        super(name, false);
    }

    @Override
    public void equip(Player player) {

    }
}
