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
    public Particle testp = new Particle(0, 0, 45,10);
    public Particle tesp = new Particle(50, 20, 70,30);
    public Particle wasp = new Particle(1270, 710, -60,5);
    public Wall wah = new Wall(1280/2,0,1280/2,720);
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
        timer = new Timer(1000/60, this);
        timer.start();
        lastTime = System.currentTimeMillis();
    }
    //test
    public void insertParticle(float x, float y, float a, float v){
        Particle p = new Particle(x,y,a,v);
        palist.add(p);
        update(getGraphics());
    }
    public void insertWall(int x1, int y1, int x2, int y2){
        Wall w = new Wall(x1,y1,x2,y2);
        wlist.add(w);
        update(getGraphics());
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
        g2d.drawString("FPS: " + fps, 10, 10);
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
            repaint();
        }
    }
    /*public void drawWall(int x1, int y1, int x2, int y2, Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1,y1,x2,y2);
    }*/
}