package com.elsys;

import java.util.TreeMap;

public class Main {

    public static void main(String[] argv){

        try {
            Map map = new Map();
            map.generate();
            System.out.println(map.getVisibleMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}