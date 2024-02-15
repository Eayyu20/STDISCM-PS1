package controller;

import javax.swing.JComponent;

public class Particle extends JComponent{

    float xpos;
    float ypos;
    public int xvel; 
    public int yvel;
    public Particle(float x, float y, float a, float v){
        xpos = x;
        ypos = y;
        xvel = (int) (v*Math.cos(Math.toRadians(a)));
        yvel = (int) (v*Math.sin(Math.toRadians(a)));
    }
    //move function
    //while loop that'll make the point move throughout the velocities and it hits walls
    public void Move()
    {
            //update position
            bounce();
            xpos += xvel;
            ypos += yvel;
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
