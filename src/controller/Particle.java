package controller;

import javax.swing.JComponent;

public class Particle extends JComponent{

    float xpos;
    float ypos;
    float xvel;
    float vel;
    float angle;
    public Particle(float x, float y, float a, float v){
        xpos = x;
        ypos = y;
        angle = a;
        vel = v;
        Move();
    }
    //move function
    //while loop that'll make the point move throughout the velocities and it hits walls
    public void Move()
    {
            //update position
            bounce();
            xpos = (float) (xpos + Math.cos (angle) * vel);
            ypos = (float) (ypos + Math.sin (angle) * vel);
    }
        
    
    void bounce(){
        //initial border collisions
        if (xpos+1 > 1280 || xpos-1 < 0)//right left collision
        {
            angle = 180 - angle;
        }
        if (ypos+1 > 720 || ypos-1 < 0) //top bottom collision
        {
            angle = 360 - angle;
        }
    }
    public float getXpos(){
        return xpos;
    }
    public float getYpos(){
        return ypos;
    }
    public float getvel(){
        return vel;
    }
    public float getang(){
        return angle;
    }
}
