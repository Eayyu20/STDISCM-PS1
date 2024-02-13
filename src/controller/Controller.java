package controller;
import view.GUI;

public class Controller {
    
    private GUI gui;

    public void start(){
        this.gui = new GUI();
        gui.toggleVisibility();;
    }
}
