package com.elsys;

import java.util.*;

public class Brimstone {
    enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN,
        NONE
    }
    int damage;
    int range;
    boolean ACTIVE;
    Direction dir;

    Brimstone(Coordinates player_cord, int damage,int range){
        this.ACTIVE = false;
        this.damage = damage;
        this.range = range;
        this.dir = Direction.NONE;
    }
    void change_dir(Direction new_dir){
        this.dir = new_dir;
    }
    void shoot(Coordinates player_cord, TreeMap<Coordinates,GameObject> map){
        if(ACTIVE){
            if (dir == Direction.UP){
                for (int i = 1; i <= this.range; i++){
                    int y = player_cord.getY();
                    player_cord.setY(y+=i);
                    if (map.get(player_cord) instanceof Enemy){
                        ((Enemy) map.get(player_cord)).take_damage();
                        if(((Enemy) map.get(player_cord)).is_dead()){
                            map.remove(player_cord);
                        }
                    }
                }
            }
            else if (dir == Direction.DOWN){
                for (int i = 1; i <= this.range; i++){
                    int y = player_cord.getY();
                    player_cord.setY(y-=i);
                    if (map.get(player_cord) instanceof Enemy){
                        ((Enemy) map.get(player_cord)).take_damage();
                        if(((Enemy) map.get(player_cord)).is_dead()){
                            map.remove(player_cord);
                        }
                    }
                }
            }
            else if (dir == Direction.LEFT){
                for (int i = 1; i <= this.range; i++){
                    int x = player_cord.getX();
                    player_cord.setX(x-=i);
                    if (map.get(player_cord) instanceof Enemy){
                        ((Enemy) map.get(player_cord)).take_damage();
                        if(((Enemy) map.get(player_cord)).is_dead()){
                            map.remove(player_cord);
                        }
                    }
                }
            }
            else if (dir == Direction.RIGHT){
                for (int i = 1; i <= this.range; i++){
                    int x = player_cord.getX();
                    player_cord.setX(x+=i);
                    if (map.get(player_cord) instanceof Enemy){
                        ((Enemy) map.get(player_cord)).take_damage();
                        if(((Enemy) map.get(player_cord)).is_dead()){
                            map.remove(player_cord);
                        }
                    }
                }
            }
        }
    }

    public boolean isACTIVE() {return ACTIVE;}
    public void setACTIVE(boolean ACTIVE) {this.ACTIVE = ACTIVE;}
}
