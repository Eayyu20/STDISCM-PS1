package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.Particle;


public class DrawingPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 1280;
    final int PANEL_HEIGHT = 720;
    Particle testp = new Particle(0, 0, 45,10);
    Timer timer;
    public float xpos = 0;
    public float ypos = 0;
    public float angle = 45;
    public float vel = 10;
    public int xvel = (int) (vel*Math.cos(Math.toRadians(angle)));
    public int yvel = (int) (vel*Math.sin(Math.toRadians(angle)));
    DrawingPanel(){
        timer = new Timer(10, this);
        timer.start();
        
    }
    //test
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawLine(0,0,1280,720);
        g2d.setBackground(Color.black);
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1280, 720);
        g2d.setColor(Color.white);
        g2d.fillOval(Math.round(xpos),Math.round(ypos),10,10);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (xpos >= 1280 || xpos < 0)//right left collision
        {
            xvel *= -1;
        }
        if (ypos > 720 || ypos < 0) //top bottom collision
        {
            yvel *= -1;
        }
        xpos += xvel;
        ypos += yvel;
        //initial border collisions
        repaint();
    }
    /*public void drawWall(int x1, int y1, int x2, int y2, Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1,y1,x2,y2);
    }*/
}