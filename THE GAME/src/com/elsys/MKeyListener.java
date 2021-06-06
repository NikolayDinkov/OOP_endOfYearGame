package com.elsys;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MKeyListener extends KeyAdapter {
    THE_Map map;
    MKeyListener(THE_Map m){
        this.map = m;
    }
    @Override
    public void keyPressed(KeyEvent event) {

        int code = event.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP -> map.shot_up();
            case KeyEvent.VK_DOWN -> map.shot_down();
            case KeyEvent.VK_LEFT -> map.shot_left();
            case KeyEvent.VK_RIGHT -> map.shot_right();
            case KeyEvent.VK_A -> map.move_left();
            case KeyEvent.VK_S -> map.move_down();
            case KeyEvent.VK_W -> map.move_up();
            case KeyEvent.VK_D -> map.move_right();
            case KeyEvent.VK_E -> map.player.use_bomb(map);
        }
    }
}