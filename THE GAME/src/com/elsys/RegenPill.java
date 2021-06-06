package com.elsys;

public class RegenPill extends Pills {
    int regen;

    RegenPill(int power, int bad_effect) {
        super("RegenPill", power, bad_effect);
        regen = power - bad_effect;
    }

    @Override
    public void consume(Player player) {
        if(player.getCurr_health() + regen > player.getMax_health()){
            player.setCurr_health(player.getMax_health());
            return;
        }
        player.setCurr_health(player.getCurr_health() + regen);
    }
}
