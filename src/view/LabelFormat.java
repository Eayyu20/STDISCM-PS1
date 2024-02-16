package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LabelFormat{
    
    private JLabel Biglabel;

    LabelFormat(String name, JPanel panel, int fontSize, Border margin){
        
        Biglabel = new JLabel(name);
        Biglabel.setFont(new Font("Ubuntu", Font.BOLD, fontSize));
        Biglabel.setBorder(margin);
        Biglabel.setPreferredSize(new Dimension(120, 30));
        Biglabel.setAlignmentX(JLabel.CENTER);
        Biglabel.setAlignmentY(JLabel.CENTER);
        panel.add(Biglabel);
    }


}
