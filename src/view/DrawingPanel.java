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
        g2d.fillOval(Math.round(testp.getXpos()),Math.round(testp.getYpos()),10,10);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        testp.Move();
        xpos = testp.getXpos();
        ypos = testp.getYpos();
        //initial border collisions
        repaint();
    }
    /*public void drawWall(int x1, int y1, int x2, int y2, Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1,y1,x2,y2);
    }*/
}