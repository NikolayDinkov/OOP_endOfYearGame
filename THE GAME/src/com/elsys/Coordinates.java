package com.elsys;

public class Coordinates implements Comparable {
    private int X;
    private int Y;
    Coordinates(int x, int y){
        if (x < 0 || x > 99 || y < 0 || y > 99){
            try {
                throw new Exception("Coords out of the map");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.X = x;
        this.Y = y;
    }

    Coordinates(){}

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

    @Override
    public int compareTo(Object o) {
        if(((Coordinates) o).getY() == this.Y && ((Coordinates) o).getX() == this.X){
            return 0;
        }
        if (((Coordinates) o).getY() > this.Y && ((Coordinates) o).getX() > this.X){
            return 1;
        }
        return -1;
    }
    @Override
    public String toString() {
        return "Coordinates{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
    @Override
    public boolean equals(Object o){
        return ((Coordinates) o).getX() == this.X && ((Coordinates) o).getY() == this.Y;
    }
}
