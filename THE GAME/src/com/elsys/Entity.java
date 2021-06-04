package com.elsys;

public class Entity implements GameObject{
    int max_health;
    int curr_health;
    int damage;
    void take_damage(){
        if (curr_health != 0) {
            curr_health--;
        }
    }
    boolean is_dead(){return curr_health == 0;}
}
