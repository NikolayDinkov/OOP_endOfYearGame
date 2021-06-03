package com.elsys;

public class Player implements GameObject{
    int max_health;
    int curr_health;
    int damage;
    Player(){
        this.max_health = 10;
        this.curr_health = this.max_health;
        this.damage = 3;
    }

    int take_damage(){
        curr_health--;
        if (curr_health == 0){
            return -1;
        }
        return 0;
    }
    int regen(int toBeRegenerated){
        if(curr_health == max_health){
            return -1;
        }
        curr_health += toBeRegenerated;
        if(curr_health > max_health){
            curr_health = max_health;
        }
        return 0;
    }
    public int getCurr_health() {return curr_health;}
    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}
}
