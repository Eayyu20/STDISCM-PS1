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
        }
        while (true);
    }
    
}
