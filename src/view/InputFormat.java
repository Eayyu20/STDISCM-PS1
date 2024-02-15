package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputFormat{
    
    private JTextField Input;

    InputFormat (JPanel panel){
        Input = new JTextField();
        Input.setMaximumSize(new Dimension(60, 20));
        Input.setMinimumSize(new Dimension(55, 20));
        Input.setPreferredSize(new Dimension(60,20));
        Input.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        Input.setHorizontalAlignment(JTextField.CENTER);
        Input.setAlignmentX(JTextField.CENTER);
        Input.setAlignmentY(JTextField.CENTER);
        panel.add(Input);
    }

    public JTextField getJTextField(){
        return Input;        
    }

}
