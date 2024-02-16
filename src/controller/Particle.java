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
            wallbounce();
            bounce();
            xpos += xvel;
            ypos += yvel;
            repaint();
            
    }   
    void wallbounce() {
        for (int i = 0; i < wlibrary.size(); i++) {
            Wall wall = wlibrary.get(i);
            // Check if particle intersects with the line segment defined by the wall
            if (intersectsWall(wall.getX1(), wall.getY1(), wall.getX2(), wall.getY2())) {
                // Reverse particle velocity
                if (wall.getX1() == wall.getX2()){xvel *= -1;}
                else if (wall.getY1() == wall.getY2()){yvel *= -1;}
                else{
                    xvel *= -1;
                    yvel *= -1;
                }
                
                break; // Exit loop after one collision
            }
        }
    }
    boolean intersectsWall(float x1, float y1, float x2, float y2) {
        // Calculate vectors representing the line segment and particle position
        float dxLine = x2 - x1;
        float dyLine = y2 - y1;
        float dxParticle = xpos - x1;
        float dyParticle = ypos - y1;
    
        // Calculate dot products
        float dotProduct = dxParticle * dxLine + dyParticle * dyLine;
        float squaredLength = dxLine * dxLine + dyLine * dyLine;
    
        // Check if the projection of the particle's position onto the line segment falls within the segment
        float t = dotProduct / squaredLength;
        if (t < 0 || t > 1) {
            return false; // Particle's projection falls outside the line segment
        }
    
        // Calculate closest point on the line segment to the particle
        float closestX = x1 + t * dxLine;
        float closestY = y1 + t * dyLine;
    
        // Calculate distance between particle's position and closest point on the line segment
        float distanceSquared = (xpos - closestX) * (xpos - closestX) + (ypos - closestY) * (ypos - closestY);
    
        // Check if the distance is within a threshold (adjust as needed)
        float threshold = 1.0f; // Adjust this value to control collision sensitivity
        return distanceSquared <= threshold * threshold;
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
