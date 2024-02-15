package controller;

public class Wall {
    int xpos1;
    int ypos1;
    int xpos2;
    int ypos2;
    public Wall(int x1, int y1, int x2, int y2){
        xpos1 = x1;
        ypos1 = y1;
        xpos2 = x2;
        ypos2 = y2;
    }
    public int getX1(){
        return xpos1;
    }
    public int getY1(){
        return ypos1;
    }
    public int getX2(){
        return xpos2;
    }
    public int getY2(){
        return ypos2;
    }
}
