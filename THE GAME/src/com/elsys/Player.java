package com.elsys;

import java.util.ArrayList;
import java.util.TreeMap;

public class Player extends Entity{

    Item inventory;
    Bomb bomb;
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
        this.bomb = new Bomb("Za6to bombite trebva da ima imena edin gospod znae", 5);
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

    public void move(Coordinates new_coords, TreeMap<Coordinates,GameObject> map){
        GameObject obg = map.get(new_coords);
        boolean can_moove = true;
        if (obg instanceof Enemy){
            can_moove = false;
            take_damage(((Enemy) obg).getDamage());
        }
        else if(obg instanceof Rock && !this.isFlight()){
            can_moove = false;
        }
        else if(obg instanceof Item){
            pick_up_item((Item) obg);
        }
        else if(obg instanceof EndHole){
            //end game
            //to do;
        }
        if (can_moove){
            map.replace(player_coord, new EmptySpace());
            setPlayer_coord(new_coords);
            map.replace(player_coord, this);
        }
    }
    public void setPlayer_coord(Coordinates player_coord) {
        this.player_coord = player_coord;
    }
    public Coordinates getPlayer_coord() {
        return player_coord;
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
        if (item instanceof Key){
            keys++;
        }
    }
    public void use_bomb(Map map){
        if(this.bombs > 0){
            this.bomb.use(this,map);
            this.bombs--;
        }
    }
    public int getAmountBombs() {
        return bombs;
    }
    public int getAmountKeys() {
        return keys;
    }

    public int getPlayer_coord_X(){
        return player_coord.getX();
    }
    public int getPlayer_coord_Y(){
        return player_coord.getY();
    }
}
