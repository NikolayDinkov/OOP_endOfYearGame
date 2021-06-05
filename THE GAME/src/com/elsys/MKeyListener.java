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
        switch (code){
            case KeyEvent.VK_UP: map.shot_up();break;
            case KeyEvent.VK_DOWN: map.shot_down();break;
            case KeyEvent.VK_LEFT: map.shot_left();break;
            case KeyEvent.VK_RIGHT: map.shot_right();break;
            case KeyEvent.VK_A: map.move_left();break;
            case KeyEvent.VK_S: map.move_down();break;
            case KeyEvent.VK_W: map.move_up();break;
            case KeyEvent.VK_D: map.move_right();break;
            case KeyEvent.VK_E: map.player.use_bomb(map);
        }
    }
}