package com.elsys;

public class Entity implements GameObject{
    int max_health;
    int curr_health;
    int damage;
    int damage_of_opponent;
    int take_damage(){
        curr_health -= damage_of_opponent;
        if (curr_health <= 0){
            return -1;
        }
        return 0;
    }
}
