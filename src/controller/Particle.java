package controller;

public class Particle {

    float xpos;
    float ypos;
    float xvel;
    float yvel;
    public Particle(float x, float y, float vx, float vy){
        xpos = x;
        ypos = y;
        xvel = vx;
        yvel = vy;
        
    }
    //move function
    //while loop that'll make the point move throughout the velocities and it hits walls
    void Move()
    {
        do
        {
            xpos += xvel;
            ypos += yvel;
            //update position
            Bounce()
        }
        while (true);
    }
    
    void bounce(){
        //initial border collisions
        if (xpos+1 > 640 or xpos-1 < -640)//right left collision
        {
            xvel *= -1;
        }
        if (ypos+1 > 320 || ypos-1 < 320) //top bottom collision
        {
            yvel *= -1;
        }
        //create 4 checking pixels surrounding the particle
        //each pixel checks 
    }
}
