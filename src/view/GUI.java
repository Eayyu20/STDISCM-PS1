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

    private JTextField nInput;
    private JTextField xStartInput;
    private JTextField yStartInput;
    private JTextField xEndInput;
    private JTextField yEndInput;
    private JTextField angleStartInput;
    private JTextField angleEndInput;
    private JTextField velStartInput;
    private JTextField velEndInput;   
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

        new LabelFormat("Add Particle", sidepanel, Font.BOLD, 15, BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        new LabelFormat("Number of Particles", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        nInput = new JTextField();
        nInput.setMaximumSize(new Dimension(100, 30));
        nInput.setPreferredSize(new Dimension(100,20));
        nInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        nInput.setHorizontalAlignment(JTextField.CENTER);
        nInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(nInput);

        new LabelFormat("X Start", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        xStartInput = new JTextField();
        xStartInput.setMaximumSize(new Dimension(100, 30));
        xStartInput.setPreferredSize(new Dimension(100,20));
        xStartInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        xStartInput.setHorizontalAlignment(JTextField.CENTER);
        xStartInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(xStartInput);
        
        new LabelFormat("Y Start", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        yStartInput = new JTextField();
        yStartInput.setMaximumSize(new Dimension(100, 30));
        yStartInput.setPreferredSize(new Dimension(100,20));
        yStartInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        yStartInput.setHorizontalAlignment(JTextField.CENTER);
        yStartInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(yStartInput);

        new LabelFormat("X End", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        xEndInput = new JTextField();
        xEndInput.setMaximumSize(new Dimension(100, 30));
        xEndInput.setPreferredSize(new Dimension(100,20));
        xEndInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        xEndInput.setHorizontalAlignment(JTextField.CENTER);
        xEndInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(xEndInput);

        new LabelFormat("Y End", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        yEndInput = new JTextField();
        yEndInput.setMaximumSize(new Dimension(100, 30));
        yEndInput.setPreferredSize(new Dimension(100,20));
        yEndInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        yEndInput.setHorizontalAlignment(JTextField.CENTER);
        yEndInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(yEndInput);

        new LabelFormat("Angle Start", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        angleStartInput = new JTextField();
        angleStartInput.setMaximumSize(new Dimension(100, 30));
        angleStartInput.setPreferredSize(new Dimension(100,20));
        angleStartInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        angleStartInput.setHorizontalAlignment(JTextField.CENTER);
        angleStartInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(angleStartInput);

        new LabelFormat("Angle End", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        angleEndInput = new JTextField();
        angleEndInput.setMaximumSize(new Dimension(100, 30));
        angleEndInput.setPreferredSize(new Dimension(100,20));
        angleEndInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        angleEndInput.setHorizontalAlignment(JTextField.CENTER);
        angleEndInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(angleEndInput);

        new LabelFormat("Velocity Start", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        velStartInput = new JTextField();
        velStartInput.setMaximumSize(new Dimension(100, 30));
        velStartInput.setPreferredSize(new Dimension(100,20));
        velStartInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        velStartInput.setHorizontalAlignment(JTextField.CENTER);
        velStartInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(velStartInput);

        new LabelFormat("Velocity End", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        velEndInput = new JTextField();
        velEndInput.setMaximumSize(new Dimension(100, 30));
        velEndInput.setPreferredSize(new Dimension(100,20));
        velEndInput.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        velEndInput.setHorizontalAlignment(JTextField.CENTER);
        velEndInput.setAlignmentY(JTextField.CENTER);
        sidepanel.add(velEndInput);    

        submitParticle = new JButton("Submit Particle");
        submitParticle.addActionListener(this);
        sidepanel.add(submitParticle);

        new LabelFormat("Add Wall", sidepanel, Font.BOLD, 15, BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        new LabelFormat("x1", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        x1Input = new JTextField();
        x1Input.setMaximumSize(new Dimension(100, 30));
        x1Input.setPreferredSize(new Dimension(100,20));
        x1Input.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        x1Input.setHorizontalAlignment(JTextField.CENTER);
        x1Input.setAlignmentY(JTextField.CENTER);
        sidepanel.add(x1Input);

        new LabelFormat("y1", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        y1Input = new JTextField();
        y1Input.setMaximumSize(new Dimension(100, 30));
        y1Input.setPreferredSize(new Dimension(100,20));
        y1Input.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        y1Input.setHorizontalAlignment(JTextField.CENTER);
        y1Input.setAlignmentY(JTextField.CENTER);
        sidepanel.add(y1Input);

        new LabelFormat("x2", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        x2Input = new JTextField();
        x2Input.setMaximumSize(new Dimension(100, 30));
        x2Input.setPreferredSize(new Dimension(100,20));
        x2Input.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        x2Input.setHorizontalAlignment(JTextField.CENTER);
        x2Input.setAlignmentY(JTextField.CENTER);
        sidepanel.add(x2Input);

        new LabelFormat("y2", sidepanel, Font.PLAIN, 15, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        y2Input = new JTextField();
        y2Input.setMaximumSize(new Dimension(100, 30));
        y2Input.setPreferredSize(new Dimension(100,20));
        y2Input.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        y2Input.setHorizontalAlignment(JTextField.CENTER);
        y2Input.setAlignmentY(JTextField.CENTER);
        sidepanel.add(y2Input);

        submitWall = new JButton("Submit Wall");
        submitWall.addActionListener(this);
        sidepanel.add(submitWall);
    }

    public void toggleVisibility(){
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitParticle){
            
            // add error checking
            
            System.out.println(nInput.getText());
            System.out.println(xStartInput.getText());
            System.out.println(yStartInput.getText());
            System.out.println(xEndInput.getText());
            System.out.println(yEndInput.getText());
            System.out.println(angleStartInput.getText());
            System.out.println(angleEndInput.getText());
            System.out.println(velStartInput.getText());
            System.out.println(velEndInput.getText());
            // mainpanel.insertParticle(Float.parseFloat(xInput.getText()), Float.parseFloat(yInput.getText()), Float.parseFloat(deltaInput.getText()), Float.parseFloat(vInput.getText()));
            
            if (!xEndInput.getText().equals("")){
                mainpanel.distinsert(Integer.parseInt(nInput.getText()), Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(xEndInput.getText()), Float.parseFloat(yEndInput.getText()), Float.parseFloat(angleStartInput.getText()), Float.parseFloat(velStartInput.getText()));
            }
            else if (!angleEndInput.getText().equals("")){
                mainpanel.angleinsert(Integer.parseInt(nInput.getText()), Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(angleStartInput.getText()), Float.parseFloat(angleEndInput.getText()),Float.parseFloat(velStartInput.getText()));
            }
            else if (!angleEndInput.getText().equals("")){
                mainpanel.angleinsert(Integer.parseInt(nInput.getText()), Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(angleStartInput.getText()),Float.parseFloat(velStartInput.getText()), Float.parseFloat(velEndInput.getText()));
            }
            else{ //more than one has an input which is an error
                System.out.println("error, more than one has an end, make sure that only one type has a end");
            }
            // reset
            nInput.setText("");
            xStartInput.setText("");
            yStartInput.setText("");
            xEndInput.setText("");
            yEndInput.setText("");
            angleStartInput.setText("");
            yStartInput.setText("");
            velStartInput.setText("");
            velEndInput.setText("");

        }
        else if (e.getSource() == submitWall){

            // add error checking

            System.out.println(x1Input.getText());
            System.out.println(y1Input.getText());
            System.out.println(x2Input.getText());
            System.out.println(y2Input.getText());

            // reset
            x1Input.setText("");
            y1Input.setText("");
            x2Input.setText("");
            y2Input.setText("");
        
        }
    }

}
