package projlab;

import java.util.Observable;
import java.util.Observer;

public class VirologistDisplay implements Observer {
    Virologist v;
    @Override
    public void update(Observable o, Object arg) {
        if (o.getClass() == v.getClass()){

        }
    }
}
