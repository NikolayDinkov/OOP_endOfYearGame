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
    public void use(Entity player, THE_Map map) {
        dropped_at_X = ((Player) player).getPlayer_coord().getX();
        dropped_at_Y = ((Player) player).getPlayer_coord().getY();

        ArrayList<Coordinates> trying = new ArrayList<>();
        trying.add(new Coordinates(dropped_at_X - 1, dropped_at_Y - 1));
        trying.add(new Coordinates(dropped_at_X + 1, dropped_at_Y + 1));
        trying.add(new Coordinates(dropped_at_X - 1, dropped_at_Y + 1));
        trying.add(new Coordinates(dropped_at_X + 1, dropped_at_Y - 1));

        trying.add(new Coordinates(dropped_at_X - 1, dropped_at_Y));
        trying.add(new Coordinates(dropped_at_X + 1, dropped_at_Y));
        trying.add(new Coordinates(dropped_at_X, dropped_at_Y - 1));
        trying.add(new Coordinates(dropped_at_X, dropped_at_Y + 1));

//      Динков това момисля че трябва да може да се напише така ако съм ти разбрал цикъла отдолу
//        trying.stream()
//                .peek(val -> ((Entity) map.map.get(val)).take_damage(toMonsterDMG))
//                .filter(val -> ((Entity) map.map.get(val)).is_dead() || ((Item) map.map.get(val)).collision)
//                .forEach(val -> map.map.replace(val, new EmptySpace()));

        for(Coordinates cor : trying) {
            if(!((Entity) map.map.get(cor)).is_dead()) {
                ((Entity) map.map.get(cor)).take_damage(toMonsterDMG);
            } else if(((Item) map.map.get(cor)).collision) {
                map.map.replace(cor, new EmptySpace());
            }
        }
    }
}
