package com.elsys;

public class Entity implements GameObject{
    protected int max_health;
    protected int curr_health;
    protected int damage;
    protected int curr_range;
    protected int max_range;
    protected int min_range;
    protected boolean flight = false;

    void take_damage(int damage_to_be_taken){
        curr_health -= damage_to_be_taken;
        if (curr_health < 0){
            curr_health = 0;
        }
    }
    boolean is_dead(){
        return curr_health == 0;
    }
    public int getCurr_health() {return curr_health;}
    public int getMax_health() {return max_health;}
    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}
    public void setCurr_health(int regen) {this.curr_health = regen;}
    public void setMax_health(int max_health) {this.max_health = max_health;}
    public int getRange() {
        return curr_range;
    }
}
