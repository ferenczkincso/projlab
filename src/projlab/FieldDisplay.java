package projlab;

import javax.swing.*;



public class FieldDisplay implements Observer {

    JPanel panel;

    FieldDisplay(JPanel p) {panel = p;}

    @Override
    public void update() {
        panel.revalidate();
        panel.repaint();
    }


}
