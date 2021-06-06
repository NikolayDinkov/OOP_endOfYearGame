package com.elsys;

public class PowerPill extends Pills {
    int more_damage;

    PowerPill(int power, int bad_effect) {
        super("PowerPill", power, bad_effect);
        more_damage = 3 * power - bad_effect;
    }


    @Override
    public void consume(Player player) {
//        player.brimstone.setDamage(player.brimstone.getDamage() + more_damage);
    }
}
