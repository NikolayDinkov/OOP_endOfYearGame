package com.elsys;

public class Rock extends Item implements GameObject{

    Rock() {
        super("Rock", true);
    }
    @Override
    public String toString(){
        return "Rock";
    }
}
