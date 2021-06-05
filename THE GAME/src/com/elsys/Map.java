package com.elsys;

import java.util.TreeMap;

public class Map {
    TreeMap<Coordinates,GameObject> map = new TreeMap<>();
    final int max_X = 99;
    final int min_X = 0;
    final int max_Y = 99;
    final int min_Y = 0;
    Player player;
    Brimstone brimstone;
    //boolean GameEnded = false;

    Map() {
        this.player = new Player(new Coordinates(1, 1));
        brimstone = new Brimstone(player.getPlayer_coord(), player.getDamage(), player.getRange());
//        map.put(player.getPlayer_coord(), player);
//        map.put(new Coordinates(1, 2), new Enemy());
//        System.out.println("Enemy1: " + ((Enemy) map.get(new Coordinates(1, 2))).getCurr_health());
//        brimstone.setACTIVE(true);
//        brimstone.change_dir(Brimstone.Direction.UP);
//        brimstone.shoot(player.getPlayer_coord(), map);
//        brimstone.setACTIVE(false);
//        System.out.println("Enemy2: " + ((Enemy) map.get(new Coordinates(1, 2))).getCurr_health());
    }

    void move_up() {
        if (player.getPlayer_coord_Y() < max_Y){
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X(),player.getPlayer_coord_Y() + 1);
            player.move(new_coords, map);
        }
    }
    void move_down(){
        if (player.getPlayer_coord_Y() > min_Y){
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X(),player.getPlayer_coord_Y() - 1);
            player.move(new_coords, map);
        }
    }
    void move_left(){
        if (player.getPlayer_coord_X() > min_X){
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X() - 1,player.getPlayer_coord().getY());
            player.move(new_coords, map);
        }
    }
    void move_right(){
        if (player.getPlayer_coord_Y() < max_X){
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X() + 1,player.getPlayer_coord().getY());
            player.move(new_coords, map);
        }
    }
    void shot_up(){
        brimstone.change_dir(Brimstone.Direction.UP);
        brimstone.shoot(player.getPlayer_coord(), map);
    }
    void shot_down(){
        brimstone.change_dir(Brimstone.Direction.DOWN);
        brimstone.shoot(player.getPlayer_coord(), map);
    }
    void shot_left(){
        brimstone.change_dir(Brimstone.Direction.LEFT);
        brimstone.shoot(player.getPlayer_coord(), map);
    }
    void shot_right(){
        brimstone.change_dir(Brimstone.Direction.RIGHT);
        brimstone.shoot(player.getPlayer_coord(), map);
    }
//    Entity getFromMapBy_XY() {
//        return map.
//    }
}
