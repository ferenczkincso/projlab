package projlab;

import java.util.Observable;
import java.util.Observer;

public class FieldDisplay implements Observer{
    Field f;
    @Override
    public void update(Observable o, Object arg) {
        if (o.getClass() == f.getClass()){

        }
    }
}
