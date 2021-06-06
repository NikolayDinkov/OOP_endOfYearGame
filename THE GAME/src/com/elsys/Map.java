package com.elsys;

import java.security.SecureRandom;
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
    private Coordinates randomSpawnLocation(int x, int y){
        //to-do
        SecureRandom rand = new SecureRandom();
        int rx, ry;
        do {
            rx = rand.nextInt(100);
        }while(rx > x-15 && rx < x+15);
        do {
            ry = rand.nextInt(100);
        }while(ry > y-15 && ry < y+15);
        return new Coordinates(rx, ry);
    }
    void add(Coordinates c, GameObject g){
        this.map.put(c, g);
    }
    void generate(int level){
        for(int i = min_X+1;i <= max_X-1;i++){
            for(int j = min_Y+1; j <= max_Y-1;j++){
                this.map.put(new Coordinates(i, j), new EmptySpace());
            }
        }
        /*
        // Trqbva mi stena
        for(int i = min_X;i <= max_X;i++){
            map.put(new Coordinates(i, 0), new Rock("rock"));
            map.put(new Coordinates(i, max_Y), new Rock("rock"));
        }
        for(int i = min_Y+1;i < max_Y;i++){
            map.put(new Coordinates(0, i), new Rock("rock"));
            map.put(new Coordinates(max_X, i), new Rock("rock"));
        }
        //to-do
         */
        player.setPlayer_coord(new Coordinates(50, 50));
        for(int i = 0;i < level*3;i++){
            Coordinates c = randomSpawnLocation(50, 50);
            for(Coordinates d : map.keySet()){
                if(d.equals(c)){
                    if(!(map.get(d) instanceof Enemy)){
                        System.out.println(map.containsKey(d));
                        System.out.println(map.remove(d));
                        System.out.println(map.containsKey(d));
                        add(c, new Enemy());
                        System.out.println(d);
                        continue;
                    }
                    else i--;
                }
            }
        }/*
        int k = 0;
        do{
            Coordinates c = randomSpawnLocation(50, 50);
            for(Coordinates d : map.keySet()){
                if(d.equals(c)){
                    if(map.get(d) instanceof Enemy);
                    else {
                        k = 1;
                        map.replace(d, new Boss());
                    }
                }
            }
        }while(k < 1);
        */
    }

    TreeMap<Coordinates, GameObject> getVisibleMap(){
        TreeMap<Coordinates, GameObject> visibleMap = new TreeMap<>();
        int min_x = 0, min_y = 0, max_x = 99, max_y = 99;
        if(player.getPlayer_coord_X() < 0){min_x = 0; max_x = 21;}
        else if(player.getPlayer_coord_X() > 78){min_x = 78; max_x = 99;}
        else {min_x = player.getPlayer_coord_X() - 10; max_x = player.getPlayer_coord_X() + 10;}

        if(player.getPlayer_coord_Y() < 0){min_y = 0; max_y = 21;}
        else if(player.getPlayer_coord_Y() > 78){min_y = 78; max_y = 99;}
        else {min_y = player.getPlayer_coord_Y() - 10; max_y = player.getPlayer_coord_Y() + 10;}
        for(int i = min_x;i <= max_x;i++){
            for(int j = min_y;j <= max_y;j++){
                if(i == player.getPlayer_coord_X() && j == player.getPlayer_coord_Y()){}
                visibleMap.put(new Coordinates(i, j), map.get(new Coordinates(i, j)));
            }
        }
        return visibleMap;
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
