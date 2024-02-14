package view;
import java.awt.*;
import javax.swing.*;


public class DrawingPanel extends JPanel {
    DrawingPanel(){
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(0,0,1280,720);
    }
}