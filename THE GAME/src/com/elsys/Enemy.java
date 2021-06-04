package com.elsys;

import java.util.Random;
import java.util.Set;

//The enemy has only one function and it is live - the living of the monster is to move, when is moved
//it shoots and if it is shoot Player - player life goes down with 2, he is doing that until it's health goes
//to zero, next is called death to clear the map from that creature.

public class Enemy extends Entity implements GameObject{

    Coordinates enemy;
    Coordinates our_coords;
    int length_of_shoot;
    String last_direction;
    Map the_map;

    private boolean is_it_in_hole(){
        for(int x = our_coords.getX() - 1; x < our_coords.getX() + 1; x++){
            for(int y = our_coords.getY()-1; y < our_coords.getY()+1; y++){
                Coordinates curr = new Coordinates(x, y);
                if(the_map.map.get(curr) instanceof EmptySpace){
                    return true;
                }
            }
        }
        return false;
    }

    private void getStartCoords(){

        Random rand = new Random();
        while(true) {
            Coordinates supposed_coords = new Coordinates(rand.nextInt(10) + 1, rand.nextInt(10) + 1);
            if (the_map.map.get(supposed_coords) instanceof EmptySpace) {
                if(!is_it_in_hole()) {
                    our_coords = supposed_coords;
                    break;
                }
            }
        }
    }

    private void spawn(){
        getStartCoords();
        the_map.map.replace(our_coords, this);
    }

    private void find_Empty(){
        int clock = -1;
        for (int x = our_coords.getX() - 1; x < our_coords.getX() + 1; x++) {
            for (int y = our_coords.getY() - 1; y < our_coords.getY() + 1; y++) {
                Coordinates curr = new Coordinates(x, y);
                if (the_map.map.get(curr) instanceof EmptySpace) {
                    our_coords = curr;
                    clock ++;
                    break;
                }
            }
        }
        switch (clock) {
            case 0 -> last_direction = "bottom_left";
            case 1 -> last_direction = "left";
            case 2 -> last_direction = "upper left";
            case 3 -> last_direction = "down";
            case 5 -> last_direction = "upper";
            case 6 -> last_direction = "bottom right";
            case 7 -> last_direction = "right";
            case 8 -> last_direction = "upper right";
            default -> System.out.printf("%s\n", "You are in a hole!");
        }
    }

    public Enemy(){
        this.max_health = 9;
        this.curr_health = this.max_health;
        this.damage = 2;
        this.length_of_shoot = 2;
        spawn();
    }

    private void get_the_Coordinates_of_Player() {

        Set<Coordinates> all_coords = the_map.map.keySet();
        for (Coordinates curr : all_coords) {
            if (the_map.map.get(curr) instanceof Player) {
                enemy = curr;
            }
        }
    }

    private void shoot(){

        Coordinates collusion = new Coordinates(our_coords.getX(), our_coords.getY());
        switch (last_direction) {
            case "bottom left" -> {
                collusion.setY(collusion.getY() - this.length_of_shoot);
                collusion.setX(collusion.getX() - this.length_of_shoot);
            }
            case "left" -> collusion.setX(collusion.getX() - this.length_of_shoot);
            case "upper left" -> {
                collusion.setY(collusion.getY() + this.length_of_shoot);
                collusion.setX(collusion.getX() - this.length_of_shoot);
            }
            case "down" -> collusion.setY(collusion.getY() - this.length_of_shoot);
            case "upper" -> collusion.setY(collusion.getY() + this.length_of_shoot);
            case "bottom right" -> {
                collusion.setY(collusion.getY() - this.length_of_shoot);
                collusion.setX(collusion.getX() + this.length_of_shoot);
            }
            case "right" -> collusion.setX(collusion.getX() + this.length_of_shoot);
            case "upper right" -> {
                collusion.setY(collusion.getY() + this.length_of_shoot);
                collusion.setX(collusion.getX() + this.length_of_shoot);
            }
        }
        if(the_map.map.get(collusion) instanceof Player){
            System.out.print("You were hitted by the monster!\n");
            ((Player) the_map.map.get(collusion)).curr_health = ((Player) the_map.map.get(collusion)).getCurr_health()
                    - this.damage;
        }
    }

    private void move_path_finding() {
        while(curr_health > 0){

            get_the_Coordinates_of_Player();

            if(this.our_coords.getX() < enemy.getX() && this.our_coords.getY() < enemy.getY()) {

                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setX(our_coords.getX()+1);
                our_coords.setY(our_coords.getY()+1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else{
                    last_direction = "upper right";
                }

                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() < enemy.getX() && this.our_coords.getY() == enemy.getY()) {

                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setX(our_coords.getX()+1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else {
                    last_direction = "right";
                }
                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() < enemy.getX() && this.our_coords.getY() > enemy.getY()) {

                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setX(our_coords.getX()+1);
                our_coords.setY(our_coords.getY()-1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else{
                    last_direction = "bottom right";
                }

                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() == enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setY(our_coords.getY()-1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else{
                    last_direction = "down";
                }

                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() > enemy.getX() && this.our_coords.getY() > enemy.getY()) {

                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setX(our_coords.getX()-1);
                our_coords.setY(our_coords.getY()-1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else{
                    last_direction = "bottom left";
                }

                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() > enemy.getX() && this.our_coords.getY() == enemy.getY()) {
                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setX(our_coords.getX()-1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else{
                    last_direction = "left";
                }

                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() > enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setX(our_coords.getX()-1);
                our_coords.setY(our_coords.getY()+1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                   find_Empty();
                }else{
                    last_direction = "upper left";
                }

                the_map.map.replace(our_coords, this);
                shoot();
                continue;
            }
            if(this.our_coords.getX() == enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                the_map.map.replace(our_coords, new EmptySpace());
                our_coords.setY(our_coords.getY()+1);

                if(!(the_map.map.get(our_coords) instanceof EmptySpace)){
                    find_Empty();
                }else{
                    last_direction = "upper";
                }

                the_map.map.replace(our_coords, this);
                shoot();
            }
        }
    }
    private void death(){
        the_map.map.replace(our_coords, new EmptySpace());
    }

    public void live(){
        move_path_finding();
        death();
    }
}
