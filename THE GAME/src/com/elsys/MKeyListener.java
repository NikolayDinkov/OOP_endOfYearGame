package com.elsys;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MKeyListener extends KeyAdapter {
    Map map;
    MKeyListener(Map m){
        this.map = m;
    }
    @Override
    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();
        System.out.println("Code: " + code);
        if(code == 37){
            map.move_left();
        }
        else if(code == 38){
            map.move_up();
        }
        else if(code == 39){
            map.move_right();
        }
        else if(code == 40){
            map.move_down();
        }
        //to-do
    }
}