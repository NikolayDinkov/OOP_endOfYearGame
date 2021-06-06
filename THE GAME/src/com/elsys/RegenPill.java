package com.elsys;

public class RegenPill extends Pills {
    int regen;

    RegenPill(int power, int bad_effect) {
        super("RegenPill", power, bad_effect);
        regen = power - bad_effect;
    }

    @Override
    public void consume(Player player) {

    }
}
