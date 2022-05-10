package projlab;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {
    JFrame window;
    FieldDisplay fieldDisplay;

    Display(ArrayList<Field>f) {
        window = new JFrame();
        fieldDisplay = new FieldDisplay(f);
        window.add(fieldDisplay);

        window.setBounds(20,20,1500,1000);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
