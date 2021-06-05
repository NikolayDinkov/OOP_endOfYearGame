package com.elsys;

public class Boss extends Enemy implements GameObject{

    EndHole end;

    public Boss() {

       this.damage = 5;
        this.max_health = 15;
        this.curr_health = this.max_health;
        super.spawn();
    }


    public void live(){
        super.live();
        this.end = new EndHole(this.our_coords);
        this.the_map.map.replace(end.coords, end);
    }

}
