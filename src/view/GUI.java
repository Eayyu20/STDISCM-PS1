package view;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.color.ColorSpace;
import controller.Particle;
import java.awt.Graphics2D;
import view.DrawingPanel;

public class GUI {

    private JFrame window;
    private DrawingPanel mainpanel;
    private JPanel canvas;
    private JLabel label;
    private static int SCREEN_WIDTH = 1500;
    private static int SCREEN_HEIGHT = 720;

    public GUI() {
        window = new JFrame();
        window.setBounds(120, 80, SCREEN_WIDTH, SCREEN_HEIGHT);
        window.setUndecorated(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainpanel = new DrawingPanel();
        mainpanel.setSize(1280, 720);
        mainpanel.setBackground(Color.white);
        window.add(mainpanel);
        
        canvas = new JPanel();
        canvas.setSize(220, 720);
        canvas.setBackground(Color.red);
        window.add(canvas);
        
        label = new JLabel();
        label.setText("Hello");
        window.add(label, BorderLayout.CENTER);
    }

    public void toggleVisibility(){
        window.setVisible(true);
    }

}
