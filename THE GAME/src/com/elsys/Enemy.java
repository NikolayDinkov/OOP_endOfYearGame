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

    public Enemy(Map map){
        this.max_health = 9;
        this.curr_health = this.max_health;
        this.damage = 2;
        this.length_of_shoot = 2;
        this.the_map = map;
        //spawn();
    }

    private boolean is_it_in_hole(){
        for(int x = our_coords.getX() - 1; x < our_coords.getX() + 1; x++){
            for(int y = our_coords.getY()-1; y < our_coords.getY()+1; y++){
                Coordinates curr = new Coordinates(x, y);
                if(the_map.map.get(curr) instanceof EmptySpace){
                    return false;
                }
            }
        }
        return true;
    }

    private void find_Empty(){
        int clock = -1;
        int k = 0;
        for (int x = our_coords.getX() - 1; x < our_coords.getX() + 1; x++) {
            if (k == 1)break;
            for (int y = our_coords.getY() - 1; y < our_coords.getY() + 1; y++) {
                if (k == 1)break;
                Coordinates curr = new Coordinates(x, y);
                for(Coordinates t : the_map.map.keySet()){
                    if(t.equals(curr)){
                        if(the_map.map.get(t) instanceof EmptySpace){
                            our_coords = t;
                            clock ++;
                            k = 1;
                            break;
                        }
                    }
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

    private void get_the_Coordinates_of_Player() {
        this.enemy = this.the_map.player.getPlayer_coord();
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
        for(Coordinates curr : the_map.map.keySet()){
            if(curr.equals(collusion)){
                if(the_map.map.get(curr) instanceof Player){
                    System.out.print("You were hitted by the monster!\n");
                    ((Player) the_map.map.get(curr)).take_damage(this.damage);
                }
            }
        }

    }

    private void move_path_finding() {
        while(curr_health > 0) {
            int k = 0;

            get_the_Coordinates_of_Player();
            if (this.our_coords.getX() < enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setX(our_coords.getX() + 1);
                        our_coords.setY(our_coords.getY() + 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "upper right";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() < enemy.getX() && this.our_coords.getY() == enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setX(our_coords.getX() + 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "right";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() < enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setX(our_coords.getX() + 1);
                        our_coords.setY(our_coords.getY() - 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "bottom right";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() == enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setY(our_coords.getY() - 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "down";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() > enemy.getX() && this.our_coords.getY() > enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setX(our_coords.getX() - 1);
                        our_coords.setY(our_coords.getY() - 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "bottom left";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() > enemy.getX() && this.our_coords.getY() == enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setX(our_coords.getX() - 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "left";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() > enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setX(our_coords.getX() - 1);
                        our_coords.setY(our_coords.getY() + 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "upper left";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
            if (this.our_coords.getX() == enemy.getX() && this.our_coords.getY() < enemy.getY()) {
                for (Coordinates curr : the_map.map.keySet()) {
                    if (curr.equals(our_coords)) {
                        the_map.map.replace(curr, new EmptySpace());
                        our_coords.setY(our_coords.getY() + 1);

                        if (!(the_map.map.get(curr) instanceof EmptySpace)) {
                            find_Empty();
                        } else {
                            last_direction = "upper";
                        }

                        the_map.map.replace(curr, this);
                        shoot();
                        k = 1;
                        break;
                    }
                }
                if (k == 1) continue;
            }
        }
    }
    private void death(){
        for(Coordinates curr : the_map.map.keySet()){
            if(curr.equals(our_coords)){
                the_map.map.replace(curr, new Key("Key"));
                break;
            }
        }
    }

    public void live(){
        move_path_finding();
        death();
    }
    @Override
    public String toString(){
        return "Enemy";
    }
}