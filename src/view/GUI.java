package view;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{

    private JFrame window;
    private DrawingPanel mainpanel;
    private JPanel sidepanel;

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
        
        sidepanel = new JPanel();
        sidepanel.setPreferredSize(new Dimension(270, 720));
        sidepanel.setMinimumSize(new Dimension(270, 720));
        sidepanel.setBackground(Color.gray);
        sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
        sidepanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        window.add(sidepanel, BorderLayout.EAST);

        JPanel col0 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("Add Particle", col0, 15, BorderFactory.createEmptyBorder(5, 0, 10, 0));
        
        JPanel col1 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("No. of Particles", col1, 12, BorderFactory.createEmptyBorder(0, 0, 10, 0));
        nInput = new InputFormat(col1).getJTextField();
        
        JPanel col2 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("X Start:", col2, 12, BorderFactory.createEmptyBorder(0, 19, 2, 0));
        xStartInput = new InputFormat(col2).getJTextField();
        new LabelFormat("Y Start:", col2, 12, BorderFactory.createEmptyBorder(0, 20, 2, 0));
        yStartInput = new InputFormat(col2).getJTextField();
        
        JPanel col3 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat(" X End:", col3, 12, BorderFactory.createEmptyBorder(0, 29, 2, 0));
        xEndInput = new InputFormat(col3).getJTextField();
        new LabelFormat("Y End:", col3, 12, BorderFactory.createEmptyBorder(0, 30, 2, 0));
        yEndInput = new InputFormat(col3).getJTextField();
        
        JPanel col4 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("  Θ Start:", col4, 12, BorderFactory.createEmptyBorder(0, 15, 2, 0));
        angleStartInput = new InputFormat(col4).getJTextField();
        new LabelFormat("Θ End:", col4, 12, BorderFactory.createEmptyBorder(0, 30, 2, 0));
        angleEndInput = new InputFormat(col4).getJTextField();

        JPanel col5 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("  V Start:", col5, 12, BorderFactory.createEmptyBorder(0, 17, 2, 0));
        velStartInput = new InputFormat(col5).getJTextField();
        new LabelFormat("V End:", col5, 12, BorderFactory.createEmptyBorder(0, 29, 15, 0));
        velEndInput = new InputFormat(col5).getJTextField();

        JPanel col6 = new SidePanelRow(sidepanel).getPanel();
        submitParticle = new JButton("Submit Particle");
        submitParticle.addActionListener(this);
        col6.add(submitParticle);

        JPanel col7 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("Add Wall", col7, 15, BorderFactory.createEmptyBorder(10, 0, 10, 0));
       
        JPanel col8 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("x1", col8, 12, BorderFactory.createEmptyBorder(0, 10, 2, 0));
        x1Input = new InputFormat(col8).getJTextField();
        new LabelFormat("     y1", col8, 12, BorderFactory.createEmptyBorder(0, 0, 2, 0));
        y1Input = new InputFormat(col8).getJTextField();
        
        JPanel col9 = new SidePanelRow(sidepanel).getPanel();
        new LabelFormat("x2", col9, 12, BorderFactory.createEmptyBorder(0, 10, 2, 0));
        x2Input = new InputFormat(col9).getJTextField();
        new LabelFormat("     y2", col9, 12, BorderFactory.createEmptyBorder(0, 0, 15, 0));
        y2Input = new InputFormat(col9).getJTextField();

        JPanel col10 = new SidePanelRow(sidepanel).getPanel();
        submitWall = new JButton("Submit Wall");
        submitWall.addActionListener(this);
        col10.add(submitWall);

        window.pack();
    }

    public void toggleVisibility(){
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitParticle){
            
               if (Integer.parseInt(nInput.getText()) == 1){
                mainpanel.insertParticle( Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(angleStartInput.getText()),Float.parseFloat(velStartInput.getText()));
            }
            if (!xEndInput.getText().equals("")){
                mainpanel.distinsert(Integer.parseInt(nInput.getText()), Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(xEndInput.getText()), Float.parseFloat(yEndInput.getText()), Float.parseFloat(angleStartInput.getText()), Float.parseFloat(velStartInput.getText()));
            }
            else if (!angleEndInput.getText().equals("")){
                mainpanel.angleinsert(Integer.parseInt(nInput.getText()), Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(angleStartInput.getText()), Float.parseFloat(angleEndInput.getText()),Float.parseFloat(velStartInput.getText()));
            }
            else if (!velEndInput.getText().equals("")){
                mainpanel.velinsert(Integer.parseInt(nInput.getText()), Float.parseFloat(xStartInput.getText()),Float.parseFloat(yStartInput.getText()), Float.parseFloat(angleStartInput.getText()),Float.parseFloat(velStartInput.getText()), Float.parseFloat(velEndInput.getText()));
            }
            else { //more than one has an input which is an error
                JPanel col0 = new SidePanelRow(sidepanel).getPanel();
                new LabelFormat("ERROR!\n Please have exactly one attribute\n with an end", col0, 15, BorderFactory.createEmptyBorder(10, 0, 10, 0));
            }
            // reset
            nInput.setText("");
            xStartInput.setText("");
            yStartInput.setText("");
            xEndInput.setText("");
            yEndInput.setText("");
            angleStartInput.setText("");
            angleEndInput.setText("");
            yStartInput.setText("");
            velStartInput.setText("");
            velEndInput.setText("");

        }
        else if (e.getSource() == submitWall){
            
            mainpanel.insertWall(Integer.parseInt(x1Input.getText()), Integer.parseInt(y1Input.getText()), Integer.parseInt(x2Input.getText()), Integer.parseInt(y2Input.getText()));
            
            // reset
            x1Input.setText("");
            y1Input.setText("");
            x2Input.setText("");
            y2Input.setText("");
        
        }
    }

}
