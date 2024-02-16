package controller;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
public class Particle extends JComponent{

    public double xpos;
    public double ypos;
    public double xvel; 
    public double yvel;
    public ArrayList<Wall> wlibrary;
    private long lastTime = System.nanoTime();
    public Particle(double x, double y, double a, double v) {
        xpos = x;
        ypos = y;
        xvel = v * Math.cos(Math.toRadians(a));
        yvel = v * Math.sin(Math.toRadians(a));
        wlibrary = new ArrayList<>();
    }
    //move function
    public void libraryupdate(ArrayList<Wall> w)
    {
        wlibrary = w;
    }
    public ArrayList<Wall> checklibrary(){
        return wlibrary;
    }
    public void Move()
    {   
            wallbounce();
            bounce();
            long currentTime = System.nanoTime();
            double timeElapsed = (currentTime - lastTime) / 1_000_000_000.0; // Time elapsed in seconds
            lastTime = currentTime;
            xpos += xvel * timeElapsed;
            ypos += yvel * timeElapsed;;    
            repaint();
            
    }   
    public void wallbounce() {
        for (int i = 0; i < wlibrary.size(); i++) {
            Wall wall = wlibrary.get(i);
            if (intersectsWall(wall.getX1(), wall.getY1(), wall.getX2(), wall.getY2())) {
                double wallAngle = Math.atan2(wall.getY2() - wall.getY1(), wall.getX2() - wall.getX1());
                double velAngle = Math.atan2(yvel, xvel);
                double incidenceAngle = wallAngle - velAngle;
                double speed = Math.hypot(xvel, yvel);
                velAngle = wallAngle + incidenceAngle;
                xvel = speed * Math.cos(velAngle);
                yvel = speed * Math.sin(velAngle);
                double radius = 5.0;
                xpos += radius * Math.cos(velAngle);
                ypos += radius * Math.sin(velAngle);
                break;
            }
        }
    }
    boolean intersectsWall(float x1, float y1, float x2, float y2) {
    Line2D.Float wall = new Line2D.Float(x1, y1, x2, y2);
    double distSq = wall.ptSegDistSq(xpos, ypos);
    float radius = 5.0f;
    return distSq <= radius * radius;
    }
    
    public void bounce(){
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
    public double getXpos(){
        return xpos;
    }
    public double getYpos(){
        return ypos;
    }
    public double getxvel(){
        return xvel;
    }
    public double getyvel(){
        return yvel;
    }
}
