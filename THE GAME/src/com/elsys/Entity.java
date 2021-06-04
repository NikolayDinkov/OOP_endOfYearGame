package com.elsys;

public class Entity implements GameObject{
    int max_health;
    int curr_health;
    int damage;
    void take_damage(int damage_to_be_taken){
        curr_health -= damage_to_be_taken;
        if (curr_health < 0){
            curr_health = 0;
        }
    }
    boolean is_dead(){return curr_health == 0;}
}
