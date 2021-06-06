package com.elsys;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class THE_Map {
    TreeMap<Coordinates,GameObject> map = new TreeMap<>();
    final int max_X = 99;
    final int min_X = 0;
    final int max_Y = 99;
    final int min_Y = 0;
    Player player;
    char[][] vision;
    //boolean GameEnded = false;
    THE_Map() {
        this.player = new Player(new Coordinates(50, 50));
        vision = new char[21][21];
//        map.put(player.getPlayer_coord(), player);
//        map.put(new Coordinates(1, 2), new Enemy());
//        System.out.println("Enemy1: " + ((Enemy) map.get(new Coordinates(1, 2))).getCurr_health());
//        player.brimstone.setACTIVE(true);
//        player.brimstone.change_dir(Brimstone.Direction.UP);
//        player.brimstone.shoot(player.getPlayer_coord(), map);
//        player.brimstone.setACTIVE(false);
//        System.out.println("Enemy2: " + ((Enemy) map.get(new Coordinates(1, 2))).getCurr_health());
    }
    private Coordinates randomSpawnLocation(int x, int y){
        //to-do
        SecureRandom rand = new SecureRandom();
        int rx, ry;
        do {
            rx = rand.nextInt(100);
        }while(rx > x-15 && rx < x+15);
        do {
            ry = rand.nextInt(100);
        }while(ry > y-15 && ry < y+15);
        return new Coordinates(rx, ry);
    }
    void generate(){
        map.put(player.getPlayer_coord(), player);
        Coordinates[] enemy_cords = new Coordinates[3];
        for(int i = 0; i < 3; i++){
            Coordinates c = randomSpawnLocation(50, 50);
            int k = 0;
            for(Coordinates curr : map.keySet()){
                if(curr.equals(c)){
                    i--;
                    break;
                }
            }
            if(k == 0){
                enemy_cords[i] = c;
                map.put(enemy_cords[i], new Enemy(this));
            }
        }
        this.player.setPlayer_coord(new Coordinates(50, 50));
        map.put(player.getPlayer_coord(), player);
        for(int i = min_X+1;i <= max_X-1;i++){
            for(int j = min_Y+2; j <= max_Y-2;j++){
                Coordinates c = new Coordinates(i, j);
                for(int t = 0;t < 3;t++){
                    if(c.equals(enemy_cords[t])){
                        break;
                    }
                }
                if(c.equals(player.getPlayer_coord())){
                    continue;
                }
                this.map.put(c, new EmptySpace());
            }
        }
        for(int i = min_X;i <= max_X;i++){
            map.put(new Coordinates(i, min_Y), new Rock_Wall());
            map.put(new Coordinates(i, max_Y), new Rock_Wall());
        }
        for(int i = min_Y+1;i <= max_Y-1;i++){
            map.put(new Coordinates(min_X, i), new Rock_Wall());
            map.put(new Coordinates(min_X, i), new Rock_Wall());
        }/*
        Coordinates[] pills_coords = new Coordinates[3];
        for(int i = 0; i < 3; i++){
            Coordinates c = randomSpawnLocation(115, 85);
            int k = 0;
            for(Coordinates curr : map.keySet()){
                if(curr.equals(c)){
                    i--;
                    k=1;
                    break;
                }
            }
            if(k == 0){
                pills_coords[i] = c;
                map.put(pills_coords[i], new Enemy(this));
            }
        }*/
    }

    TreeMap<Coordinates, GameObject> getVisibleMap(){
        TreeMap<Coordinates, GameObject> visibleMap = new TreeMap<Coordinates, GameObject>();
        int min_x = 0, min_y = 0, max_x = 99, max_y = 99;
        if(player.getPlayer_coord().getX() < 10){
            min_x = 0;
            max_x = 21;
        }
        else if(player.getPlayer_coord().getX() > 78){
            min_x = 78;
            max_x = 99;
        }
        else {
            min_x = player.getPlayer_coord().getX() - 10;
            max_x = player.getPlayer_coord().getX() + 10;
        }

        if(player.getPlayer_coord().getY() < 10){
            min_y = 0;
            max_y = 21;
        }
        else if(player.getPlayer_coord().getY() > 78){
            min_y = 78;
            max_y = 99;
        }
        else {
            min_y = player.getPlayer_coord().getY() - 10;
            max_y = player.getPlayer_coord().getY() + 10;
        }
        for(int i = min_x;i <= max_x;i++){
            for(int j = min_y;j <= max_y;j++){
                Coordinates c = new Coordinates(i, j);
                for(Map.Entry<Coordinates, GameObject> entry: map.entrySet()){
                    if(entry.getKey().equals(c)) {
                        //System.out.println(entry.getKey() + " " + entry.getValue());
                        visibleMap.put(entry.getKey(), entry.getValue());
                        break;
                    }
                }
            }
        }
        return visibleMap;
    }

    void convert() {
        TreeMap<Coordinates, GameObject> map_vision = this.getVisibleMap();
        int i = 0, j = 0;
        for(Map.Entry<Coordinates, GameObject> entry : map_vision.entrySet()){
////            System.out.printf("x: %d, y: %d\n", entry.getKey().getX(), entry.getKey().getY());
//            System.out.println(entry.getKey().getX() + " " + entry.getKey().getY());
//            while(i < 21){
//                while(j < 21){
            if(j == 21){
                j = 0;
                i++;
            }
//            System.out.println(entry.getValue());
            if(entry.getValue() instanceof Rock) {
                this.vision[i][j] = '∎';
            } else if (entry.getValue() instanceof Player) {
                this.vision[i][j] = 'p';
            } else if (entry.getValue() instanceof Boss) {
                this.vision[i][j] = 'b';
            } else if(entry.getValue() instanceof Enemy) {
                this.vision[i][j] = 'e';
            } else if(entry.getValue() instanceof Key) {
                this.vision[i][j] = 'k';
            } else if(entry.getValue() instanceof EndHole) {
                this.vision[i][j] = '⊙';
            } else if(entry.getValue() instanceof Rock_Wall) {
                this.vision[i][j] = '⌂';
            } else if(entry.getValue() instanceof EmptySpace) {
                this.vision[i][j] = '.';
            } else if(entry.getValue() instanceof Pills) {
                this.vision[i][j] = '*';
            }
            j++;
//                    j++;
//                }
//                i++;
//                j = 0;
//            }
        }
    }

    void printVision() {

//        System.out.print("Characters:\n - e = enemy\n - B = boss\n - p = player\n - k = key\n - ∎ = rock\n - ⊙ = end hole\n");
        for(int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++){
                System.out.printf("%c ", this.vision[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    void move_right() {
        if (player.getPlayer_coord_Y() < max_Y){
            player.setPlayer_coord(new Coordinates(player.getPlayer_coord_X(),player.getPlayer_coord_Y() + 1));
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X(),player.getPlayer_coord_Y());
            this.map = player.move(new_coords, map);
        }
        convert();
        printVision();
    }
    void move_left(){
        if (player.getPlayer_coord_Y() > min_Y){
            player.setPlayer_coord(new Coordinates(player.getPlayer_coord_X(),player.getPlayer_coord_Y() - 1));
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X(),player.getPlayer_coord_Y());
            this.map = player.move(new_coords, map);
        }
        convert();
        printVision();
    }
    void move_up(){
        if (player.getPlayer_coord_X() > min_X){
            player.setPlayer_coord(new Coordinates(player.getPlayer_coord_X() - 1,player.getPlayer_coord_Y()));
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X() - 1,player.getPlayer_coord().getY());
            this.map = player.move(new_coords, map);
        }
        convert();
        printVision();
    }
    void move_down(){
        if (player.getPlayer_coord_Y() < max_X){
            player.setPlayer_coord(new Coordinates(player.getPlayer_coord_X() + 1,player.getPlayer_coord_Y()));
            Coordinates new_coords = new Coordinates(player.getPlayer_coord_X() + 1,player.getPlayer_coord().getY());
            this.map = player.move(new_coords, map);
        }
        convert();
        printVision();
    }
    void shot_up(){
        player.brimstone.change_dir(Brimstone.Direction.UP);
        player.brimstone.shoot(player.getPlayer_coord(), map);
    }
    void shot_down(){
        player.brimstone.change_dir(Brimstone.Direction.DOWN);
        player.brimstone.shoot(player.getPlayer_coord(), map);
    }
    void shot_left(){
        player.brimstone.change_dir(Brimstone.Direction.LEFT);
        player.brimstone.shoot(player.getPlayer_coord(), map);
    }
    void shot_right(){
        player.brimstone.change_dir(Brimstone.Direction.RIGHT);
        player.brimstone.shoot(player.getPlayer_coord(), map);
    }
}
