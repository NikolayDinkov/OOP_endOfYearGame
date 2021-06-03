package com.elsys;

import java.util.TreeMap;

public class Map {
    TreeMap<Coordinates,GameObject> map;
    final int max_X = 99;
    final int min_X = 0;
    final int max_Y = 99;
    final int min_Y = 0;
    Coordinates player_coord;
    Player player;
    Map(){
        this.player_coord = new Coordinates( 1, 1); //to-do
        this.player = new Player();
    }

    void move_up(){
        if (player_coord.getY() < max_Y){
            map.replace(player_coord, new EmptySpace());
            int Y = player_coord.getY();
            player_coord.setY(++Y);
            map.replace(player_coord, player);
        }
    }
    void move_down(){
        if (player_coord.getY() > min_Y){
            map.replace(player_coord, new EmptySpace());
            int Y = player_coord.getY();
            player_coord.setY(--Y);
            map.replace(player_coord, player);
        }
    }
    void move_left(){
        if (player_coord.getX() > min_X){
            map.replace(player_coord, new EmptySpace());
            int X = player_coord.getX();
            player_coord.setX(--X);
            map.replace(player_coord, player);
        }
    }
    void move_right(){
        if (player_coord.getY() < max_X){
            map.replace(player_coord, new EmptySpace());
            int X = player_coord.getX();
            player_coord.setX(++X);
            map.replace(player_coord, player);
        }
    }

}
