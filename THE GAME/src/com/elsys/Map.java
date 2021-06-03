package com.elsys;

import java.util.TreeMap;

public class Map {
    TreeMap<Coordinates,GameObject> map = new TreeMap<>();
    Coordinates player_coord;
    Player player;
    Map(){
        this.player_coord = new Coordinates( 1, 1); //to-do
        this.player = new Player();
    }
    void move_up(){
        //to-do
    }
    void move_down(){
        //to-do
    }
    void move_left(){
        //to-do
    }
    void move_write(){
        //to-do
    }
}
