package com.elsys;

public class Rock_Wall extends Item implements GameObject{ // needed for the walls of the map
    Rock_Wall(String name) {
        super(name, false);
    }

    @Override
    public String toString() {
        return "Rock_Wall";
    }
}