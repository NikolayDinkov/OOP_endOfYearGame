package com.elsys;

import java.util.*;

public class Brimstone {

    //Brimstone is the main weapon of the player
    //It deal damage to all enemies in a particular direction

    enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN,
        NONE
    }
    private int damage;
    private int range;
    private Direction dir;

    Brimstone(Coordinates player_cord, int damage,int range){
        this.damage = damage;
        this.range = range;
        this.dir = Direction.NONE;
    }

    //Changes direction of the weapon
    void change_dir(Direction new_dir){
        this.dir = new_dir;
    }

    //Shoot the Brimstone
    //The function should be called after the function "change_dir"
    void shoot(Coordinates player_cord, TreeMap<Coordinates,GameObject> map){
            ArrayList<Coordinates> coord = new ArrayList<>();
            switch (dir){
                case LEFT:
                    for(int i = 1; i <= this.range; i++){
                        coord.add(new Coordinates(player_cord.getX() - i, player_cord.getY()));
                    } break;
                case RIGHT:
                    for(int i = 1; i <= this.range; i++){
                        coord.add(new Coordinates(player_cord.getX() + i, player_cord.getY()));
                    } break;
                case UP:
                    for(int i = 1; i <= this.range; i++){
                        coord.add(new Coordinates(player_cord.getX(),player_cord.getY() + i));
                    } break;
                case DOWN:
                    for(int i = 1; i <= this.range; i++){
                        coord.add(new Coordinates(player_cord.getX(), player_cord.getY() - i));
                    } break;
            }
            coord.stream()
                    .filter(val -> map.get(val) instanceof Enemy)
                    .peek(val -> ((Enemy) map.get(val)).take_damage(this.damage))
                    .filter(val -> ((Enemy) map.get(val)).is_dead())
                    .forEach(val -> map.replace(val, new EmptySpace()));
    }

}
