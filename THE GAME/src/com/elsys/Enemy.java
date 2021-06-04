package com.elsys;

import java.util.Random;
import java.util.Set;

public class Enemy extends Entity{

    Coordinates enemy;
    Coordinates our_coords;
    int length_of_shoot;
    int timer_of_shoot;

    public Enemy(){
        Random rand = new Random();
        our_coords = new Coordinates(rand.nextInt(10) + 1, rand.nextInt(10) + 1);
        this.max_health = 9;
        this.curr_health = this.max_health;
        this.damage = 2;
        this.length_of_shoot = 3;
        this.timer_of_shoot = 0;
    }

    private void get_the_Coordinates_of_Player(Map our_map){

        Set<Coordinates> all_coords = our_map.map.keySet();
        for(Coordinates curr : all_coords){
            if(our_map.map.get(curr) instanceof Player){
                enemy = curr;
            }
        }


    }

    public void move_path_finding(Map our_map){
        while(curr_health != 0){

            get_the_Coordinates_of_Player(our_map);

            if(this.our_coords.getX() < enemy.getX() && this.our_coords.getY() < enemy.getY()) {

                our_coords.X++;
                our_coords.Y++;

                continue;
            }
            if(this.our_coords.getX() < enemy.getX() && this.our_coords.getY() == enemy.getY()) {
                this.our_coords.X++;
                continue;
            }
            if(this.our_coords.getX() < enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                this.our_coords.X++;
                this.our_coords.Y--;
                continue;
            }
            if(this.our_coords.getX() == enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                this.our_coords.Y--;
                continue;
            }
            if(this.our_coords.getX() > enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                this.our_coords.X--;
                this.our_coords.Y--;
                continue;
            }
            if(this.our_coords.getX() > enemy.getX() && this.our_coords.getY() == enemy.getY()) {
                this.our_coords.X--;
                continue;
            }
            if(this.our_coords.getX() > enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                this.our_coords.X--;
                this.our_coords.Y++;
                continue;
            }
            if(this.our_coords.getX() == enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                this.our_coords.Y++;
            }
        }
    }

    public int getCurr_health() {return curr_health;}
}
