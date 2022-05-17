package projlab;

import javax.swing.*;

public class InventoryDisplay implements Observer {

    JPanel panel;

    InventoryDisplay(JPanel p){ panel = p;}

    /**
     * A mező frissítéséért felelős metódus
     */
    @Override
    public void update() {
        panel.revalidate();
        panel.repaint();
    }
}
