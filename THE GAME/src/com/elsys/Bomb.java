package com.elsys;

import java.util.ArrayList;

public class Bomb extends Item implements Usable{
    int toMonsterDMG;
    int dropped_at_X;
    int dropped_at_Y;

    Bomb(String name, int toMonsterDMG) {
        super(name, true);
        this.toMonsterDMG = toMonsterDMG;
    }

    @Override
    public void use(Entity player, Map map) {
        dropped_at_X = player.player_coord.getX();
        dropped_at_Y = player.player_coord.getX();

        ArrayList<Coordinates> trying = new ArrayList<>();
        trying.add(new Coordinates(dropped_at_X - 1, dropped_at_Y - 1));
        trying.add(new Coordinates(dropped_at_X + 1, dropped_at_Y + 1));
        trying.add(new Coordinates(dropped_at_X - 1, dropped_at_Y + 1));
        trying.add(new Coordinates(dropped_at_X + 1, dropped_at_Y - 1));

        trying.add(new Coordinates(dropped_at_X - 1, dropped_at_Y));
        trying.add(new Coordinates(dropped_at_X + 1, dropped_at_Y));
        trying.add(new Coordinates(dropped_at_X, dropped_at_Y - 1));
        trying.add(new Coordinates(dropped_at_X, dropped_at_Y + 1));

        for(Coordinates cor : trying) {
            if(!((Entity) map.map.get(cor)).is_dead()) {
                ((Entity) map.map.get(cor)).take_damage(toMonsterDMG);
            } else if(((Item) map.map.get(cor)).collision) {
                map.map.replace(cor, new EmptySpace());
            }
        }
    }
}
