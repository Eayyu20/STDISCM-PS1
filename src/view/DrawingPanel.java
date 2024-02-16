package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import controller.Particle;
import controller.Wall;


public class DrawingPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 1280;
    final int PANEL_HEIGHT = 720;
    public ArrayList<Particle> palist;
    public ArrayList<Wall> wlist;
    Timer timer;
    public float xpos = 0;
    public float ypos = 0;
    public long lastTime;
    private int frames;
    private int fps;
    Random rand = new Random(); //test
    DrawingPanel(){
        palist = new ArrayList<>();
        wlist = new ArrayList<>();
        /*
        //testing
        for(int i=0;i<2;i++){
            palist.add(new Particle(rand.nextInt(1280), rand.nextInt(720), rand.nextInt(360), rand.nextInt(40)+10));
        }
        wlist.add(wah);
        for(int i=0;i<2;i++){
            palist.get(i).libraryupdate(wah);
        }
        */
        timer = new Timer(500/60, this);
        timer.start();
        lastTime = System.currentTimeMillis();
    }
    //test
    public void insertParticle(float x, float y, float a, float v){
        Particle p = new Particle(x,y,a,v);
        palist.add(p);
        update(getGraphics());
    }
    public void distinsert(int n, float x1, float y1, float x2, float y2, float a, float v){
        for (int i = 0; i < n; i++) {
            double ratio = (double) i / (n - 1);
            float xplace = (float) (x1 + ratio * (x2 - x1));
            float yplace = (float) (y1 + ratio * (y2 - y1));
            Particle p = new Particle(xplace,yplace,a,v);
            for(int j=0; j<wlist.size();j++){
                p.libraryupdate(wlist.get(j));
            }
            for(int j=0; j<wlist.size();j++){
                p.libraryupdate(wlist.get(j));
            }
            palist.add(p);
            
        }
        update(getGraphics());
    }
    public void angleinsert(int n, float x, float y, float a1, float a2, float v){
        for (int i = 0; i < n; i++) {
            double ratio = (double) i / (n - 1);
            float aplace = (float) (a1 + ratio * (a2 - a1));
            Particle p = new Particle(x,y,aplace,v);
            for(int j=0; j<wlist.size();j++){
                p.libraryupdate(wlist.get(j));
            }
            palist.add(p);
        }
        update(getGraphics());
    }
    public void velinsert(int n, float x, float y, float a, float v1, float v2){
        for (int i = 0; i < n; i++) {
            double ratio = (double) i / (n - 1);
            float vplace = (float) (v1 + ratio * (v2 - v1));
            Particle p = new Particle(x,y,a,vplace);
            for(int j=0; j<wlist.size();j++){
                p.libraryupdate(wlist.get(j));
            }
            palist.add(p);
        }
        update(getGraphics());
    }
    public void insertWall(int x1, int y1, int x2, int y2){
        Wall w = new Wall(x1,y1,x2,y2);
        wlist.add(w);
        for (int i = 0; i<palist.size(); i++){
            palist.get(i).libraryupdate(w);
        } 
        update(getGraphics());
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(0, getHeight());
        g2d.scale(1,-1);
        g2d.setBackground(Color.black);
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1280, 720);
        g2d.setColor(Color.white);
        for (int i = 0; i<palist.size(); i++){
            g2d.fillRect(Math.round(palist.get(i).getXpos()),Math.round(palist.get(i).getYpos()),10,10);
        } 
        for (int i = 0; i<wlist.size(); i++){
            g2d.drawLine(wlist.get(i).getX1(), wlist.get(i).getY1(), wlist.get(i).getX2(), wlist.get(i).getY2());
        }
        frames++;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime >= 1000) {
            fps = frames;
            frames = 0;
            lastTime = currentTime;
        }
        g2d.setColor(Color.RED);
        g2d.scale(1,-1);
        g2d.translate(0, -getHeight());
        g2d.drawString("FPS: " + fps, 10,10);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //for every particle in the list
        //make a thread that draws particles
        //make a thread that draws walls
        for (int i = 0; i<palist.size(); i++){
            palist.get(i).Move();
            xpos = palist.get(i).getXpos();
            ypos = palist.get(i).getYpos();
            for(int j=0; j<wlist.size();j++){
                palist.get(i).libraryupdate(wlist.get(j));
            }
            repaint();
        }
    }
}