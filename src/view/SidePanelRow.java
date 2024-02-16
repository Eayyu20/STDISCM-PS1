package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SidePanelRow {
    
    private JPanel Row;

    SidePanelRow(JPanel panel){
        Row = new JPanel();
        Row.setBackground(Color.gray);
        Row.setLayout(new BoxLayout(Row, BoxLayout.X_AXIS));
        panel.add(Row);
    }

    public JPanel getPanel(){
        return Row;
    }

}
