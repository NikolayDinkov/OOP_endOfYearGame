package com.elsys;

public class Rock extends Item implements GameObject{

    Rock(String name) {
        super(name, true);
    }
    @Override
    public String toString(){
        return "Rock";
    }
}
