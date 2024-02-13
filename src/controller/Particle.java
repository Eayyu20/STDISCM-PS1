package controller;

import javax.swing.JComponent;
import javax.swing.Timer;
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

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
    void Move()
    {
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            //update position
            bounce();
            xpos = (float) (xpos + Math.cos (angle) * vel);
            ypos = (float) (ypos + Math.sin (angle) * vel);
            repaint();
            }
        });
        timer.start();
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
        //create 4 checking pixels surrounding the particle
        //each pixel checks 
    }
    public void paintComponent(Graphics g) {						 
         Graphics2D g2d = (Graphics2D) g;						
         super.paintComponent(g2d);							
                 g2d.setColor(Color.GREEN);					
                     g2d.fillRect(Math.round(xpos),Math.round(ypos), 1, 1);			
                         g2d.dispose();					
     }
}
