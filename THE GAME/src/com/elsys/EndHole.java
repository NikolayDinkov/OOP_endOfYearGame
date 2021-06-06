package com.elsys;

public class EndHole implements GameObject{

    Coordinates coords;

    public EndHole(Coordinates our_coords) {
        this.coords = our_coords;
    }

    void end_quest(Player player){ // not sure if this will be all in the final
        if(player.getAmountKeys() == 5) {
            System.out.println("You won");
        }
    }

}
