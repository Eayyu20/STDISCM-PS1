package view;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.color.ColorSpace;
import controller.Particle;
import java.awt.Graphics2D;
import view.*;

public class GUI {

    private JFrame window;
    private DrawingPanel mainpanel;
    private JPanel sidepanel;
    private JLabel label;
    private Particle testp;
    private static int SCREEN_WIDTH = 1550;
    private static int SCREEN_HEIGHT = 720;

    public GUI() {
        window = new JFrame();
        window.setBounds(120, 80, SCREEN_WIDTH, SCREEN_HEIGHT);
        window.setUndecorated(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        mainpanel = new DrawingPanel();
        mainpanel.setPreferredSize(new Dimension(1280, 720));
        mainpanel.setBackground(Color.white);
        window.add(mainpanel, BorderLayout.WEST);
        //mainpanel.drawWall(0, 0, 1280, 720, null);
        
        sidepanel = new JPanel();
        sidepanel.setPreferredSize(new Dimension(280, 720));
        sidepanel.setBackground(Color.red);
        window.add(sidepanel, BorderLayout.EAST);
        
        JTextField angle = new JTextField();
        angle.setPreferredSize(new Dimension(100,20));
        angle.setFont(new Font("Consolas", Font.PLAIN, 35));
        sidepanel.add(angle);
    }

    public void toggleVisibility(){
        window.setVisible(true);
    }

}
