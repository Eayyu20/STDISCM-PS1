package controller;
import javax.swing.JComponent;
import controller.Wall;
import java.awt.Rectangle;
import java.util.ArrayList;
public class Particle extends JComponent{

    public float xpos;
    public float ypos;
    public int xvel; 
    public int yvel;
    public ArrayList<Wall> wlibrary;
    public Particle(float x, float y, float a, float v){
        xpos = x;
        ypos = y;
        xvel = (int) (v*Math.cos(Math.toRadians(a)));
        yvel = (int) (v*Math.sin(Math.toRadians(a)));
        wlibrary = new ArrayList<>();
    }
    //move function
    public void libraryupdate(Wall w)
    {
        wlibrary.add(w);
    }
    //while loop that'll make the point move throughout the velocities and it hits walls
    public void Move()
    {
            //wallbounce();
            bounce();
            xpos += xvel;
            ypos += yvel;
            repaint();
            
    }   
    void bounce(){
        //initial border collisions
        if (xpos >= 1280 || xpos < 0)//right left collision
        {
            xvel *= -1;
        }
        if (ypos > 720 || ypos < 0) //top bottom collision
        {
            yvel *= -1;
        }
    }
    public float getXpos(){
        return xpos;
    }
    public float getYpos(){
        return ypos;
    }
    public int getxvel(){
        return xvel;
    }
    public int getyvel(){
        return yvel;
    }
}
