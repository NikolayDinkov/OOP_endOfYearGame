package com.elsys;

public class Player extends Entity{
    int curr_range;
    int max_range;
    int min_range;

    Player(){
        this.max_health = 10;
        this.curr_health = this.max_health;
        this.damage = 3;
        this.max_range = 6;
        this.curr_range = 2;
        this.min_range = 1;
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

    public int getCurr_range() {return curr_range;}
    public int getCurr_health() {return curr_health;}
    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}
}
