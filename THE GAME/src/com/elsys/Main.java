package com.elsys;

import javax.swing.*;
import java.util.TreeMap;

public class Main {

    public static void main(String[] argv){

        try {
            THE_Map map = new THE_Map();
            map.generate();
//            System.out.println(map.getVisibleMap());
//            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//            System.out.println(map.map);
//            System.out.println(map.getVisibleMap());
//            map.convert();
//            map.convertTryHard();
//            System.out.println(map.getVisibleMap());
//            map.printVision();
//
//            while(!map.player.is_dead()) {
                map.convert();
                map.printVision();
                JTextField textField = new JTextField();
                textField.addKeyListener(new MKeyListener(map));
                JFrame jframe = new JFrame();
                jframe.add(textField);
                jframe.setSize(400, 300);
                jframe.setVisible(true);

//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}