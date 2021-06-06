package com.elsys;

import java.util.TreeMap;

public class Main {

    public static void main(String[] argv){

        try {
            Map map = new Map();
            /*
            Coordinates c1 = new Coordinates(10, 10);
            Coordinates c2 = new Coordinates(10, 10);
            System.out.println(c1.equals(c2));
            */
            map.generate(1);
            //to-do
//          JTextField textField = new JTextField();
//          textField.addKeyListener(new MKeyListener(map));
//          JFrame jframe = new JFrame();
//          jframe.add(textField);
//          jframe.setSize(400, 350);
//          jframe.setVisible(true);
            //System.out.println(map.map.get(new Coordinates(map.player.getPlayer_coord_X(), map.player.getPlayer_coord_Y())));
            //System.out.println(map.getVisibleMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}