package com.elsys;

public class Coordinates {
    int X;
    int Y;
    Coordinates(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX() {return X;}
    public void setX(int x){
        if (x >= 0 || x <= 99){
            this.X=x;
        }
    }
    public int getY() {return Y;}
    public void setY(int y) {
        if(y >= 0 || y <= 99){
            this.Y = y;
        }
    }
}
