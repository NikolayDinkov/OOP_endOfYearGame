package com.elsys;

import javax.swing.*;

public class Player extends Entity{

    private Coordinates player_coord;
    private int bombs = 1;
    private int keys = 0;
    Player(Coordinates player_coord){
        this.max_health = 10;
        this.curr_health = this.max_health;
        this.damage = 3;
        this.max_range = 6;
        this.curr_range = 2;
        this.min_range = 1;
        this.player_coord = player_coord;
    }

    int regen(int toBeRegenerated){//regen serten amount of health
        if(curr_health == max_health){
            return -1;
        }
        curr_health += toBeRegenerated;
        if(curr_health > max_health){
            curr_health = max_health;
        }
        return 0;
    }

    int rangeUp(){//increase range of brimstone
        if(curr_range == max_range){
            return -1;
        }
        this.curr_range++;
        return 0;
    }
    int rangeDown(){//decrease range of brimstone
        if(curr_range == min_range){
            return -1;
        }
        this.curr_range--;
        return 0;
    }

    public Coordinates getPlayer_coord() {
        return player_coord;
    }
    public void setPlayer_coord(Coordinates player_coord) {
        this.player_coord = player_coord;
    }

    public boolean isFlight() {
        return flight;
    }
    public void activateFlight() {
        this.flight = true;
    }
    public void deactivateFlight() {
        this.flight = false;
    }
    public void pick_up_item(Item item){
        if(item instanceof Bomb){
            bombs++;
        }
        if (item instanceof KEYS){
            keys++;
        }
    }
    public int getBombs() {
        return bombs;
    }
    public int getKeys() {
        return keys;
    }
}
