package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LabelFormat{
    
    private JLabel Biglabel;

    LabelFormat(String name, JPanel panel, int fontType, int fontSize, Border margin){
        
        Biglabel = new JLabel(name);
        Biglabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Biglabel.setFont(new Font("Ubuntu", fontType, fontSize));
        // Biglabel.setForeground(new Color(0x315AEB));
        Biglabel.setBorder(margin);
        Biglabel.setPreferredSize(new Dimension(100, 30));
        panel.add(Biglabel);
    }


}
