package view;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Particle;
import java.awt.Graphics2D;
import view.*;

public class GUI extends JFrame implements ActionListener{

    private JFrame window;
    private DrawingPanel mainpanel;
    private JPanel sidepanel;
    private Particle testp;

    private JTextField xInput;
    private JTextField yInput;
    private JTextField deltaInput;
    private JTextField vInput;
    private JButton submitParticle;

    private JTextField x1Input; 
    private JTextField y1Input;
    private JTextField x2Input;
    private JTextField y2Input;
    private JButton submitWall; 

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
        sidepanel.setBackground(Color.gray);
        sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
        window.add(sidepanel, BorderLayout.EAST);

        LabelFormat addParticleText = new LabelFormat("Add Particle", sidepanel, Font.BOLD, 15, BorderFactory.createEmptyBorder(0, 0, 10, 0));
        LabelFormat xText = new LabelFormat("x", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
    

        xInput = new JTextField();
        xInput.setMaximumSize(new Dimension(100, 30));
        xInput.setPreferredSize(new Dimension(100,20));
        xInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        xInput.setHorizontalAlignment(JTextField.CENTER);
        xInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(xInput);

        JLabel yText = new JLabel("y: ");
        yText.setHorizontalTextPosition(JLabel.CENTER);
        yText.setVerticalTextPosition(JLabel.TOP);
        yText.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        yText.setPreferredSize(new Dimension(100, 30));
        sidepanel.add(yText);

        yInput = new JTextField();
        yInput.setMaximumSize(new Dimension(100, 30));
        yInput.setPreferredSize(new Dimension(100,20));
        yInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        yInput.setHorizontalAlignment(JTextField.CENTER);
        yInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(yInput);

        JLabel deltaText = new JLabel("delta: ");
        deltaText.setHorizontalTextPosition(JLabel.CENTER);
        deltaText.setVerticalTextPosition(JLabel.TOP);
        deltaText.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        deltaText.setPreferredSize(new Dimension(100, 30));
        sidepanel.add(deltaText);

        deltaInput = new JTextField();
        deltaInput.setMaximumSize(new Dimension(100, 30));
        deltaInput.setPreferredSize(new Dimension(100,20));
        deltaInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        deltaInput.setHorizontalAlignment(JTextField.CENTER);
        deltaInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(deltaInput);

        JLabel vText = new JLabel("v: ");
        vText.setHorizontalTextPosition(JLabel.CENTER);
        vText.setVerticalTextPosition(JLabel.TOP);
        vText.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        vText.setPreferredSize(new Dimension(100, 30));
        sidepanel.add(vText);

        vInput = new JTextField();
        vInput.setMaximumSize(new Dimension(100, 30));
        vInput.setPreferredSize(new Dimension(100,20));
        vInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        vInput.setHorizontalAlignment(JTextField.CENTER);
        vInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(vInput);

        submitParticle = new JButton("Submit Particle");
        submitParticle.addActionListener(this);
        sidepanel.add(submitParticle);
    }

    public void toggleVisibility(){
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitParticle){
            System.out.println(xInput.getText());
            System.out.println(yInput.getText());
            System.out.println(deltaInput.getText());
            System.out.println(vInput.getText());
            mainpanel.insertParticle(Float.parseFloat(xInput.getText()), Float.parseFloat(yInput.getText()), Float.parseFloat(deltaInput.getText()), Float.parseFloat(vInput.getText()));
            // reset
            xInput.setText("");
            yInput.setText("");
            deltaInput.setText("");
            vInput.setText("");

        }
        else if (e.getSource() == submitWall){
        
        }
    }

}
