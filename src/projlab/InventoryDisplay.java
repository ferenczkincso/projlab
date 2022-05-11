package projlab;

import javax.swing.*;

public class InventoryDisplay implements Observer {

    JPanel panel;

    InventoryDisplay(JPanel p){ panel = p;}

    @Override
    public void update() {
        panel.revalidate();
        panel.repaint();
    }
}
