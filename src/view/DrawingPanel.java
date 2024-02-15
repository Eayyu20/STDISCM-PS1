package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import controller.Particle;


public class DrawingPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 1280;
    final int PANEL_HEIGHT = 720;
    public ArrayList<Particle> palist;
    public Particle testp = new Particle(0, 0, 45,10);
    public Particle tesp = new Particle(50, 20, 70,30);
    public Particle wasp = new Particle(1270, 710, -60,5);
    Timer timer;
    public float xpos = 0;
    public float ypos = 0;
    DrawingPanel(){
        timer = new Timer(10, this);
        timer.start();
        palist = new ArrayList<>();
        palist.add(testp);
        palist.add(tesp);
        palist.add(wasp);
    }
    //test
    public void insertParticle(float x, float y, float a, float v){
        Particle p = new Particle(x,y,a,v);
        palist.add(p);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawLine(0,0,1280,720);
        g2d.setBackground(Color.black);
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1280, 720);
        g2d.setColor(Color.white);
        for (int i = 0; i<palist.size(); i++){
            g2d.fillOval(Math.round(palist.get(i).getXpos()),Math.round(palist.get(i).getYpos()),10,10);
        } 
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //for every particle in the list
        for (int i = 0; i<palist.size(); i++){
            palist.get(i).Move();
            xpos = palist.get(i).getXpos();
            ypos = palist.get(i).getYpos();
            repaint();
        }        
    }
    /*public void drawWall(int x1, int y1, int x2, int y2, Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1,y1,x2,y2);
    }*/
}