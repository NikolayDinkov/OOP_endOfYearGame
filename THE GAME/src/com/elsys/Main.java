package com.elsys;

import java.util.TreeMap;

public class Main {

    public static void main(String[] argv){

        try {
            THE_Map map = new THE_Map();
            map.generate();
            System.out.println(map.getVisibleMap());
            map.convert();
//            System.out.println(map.convert());
            map.printVision();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}