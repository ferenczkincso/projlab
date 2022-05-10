package projlab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FieldDisplay extends JPanel implements Observer {

    ArrayList<Field> fields = new ArrayList<Field>();

    public void setFields(ArrayList<Field> f){ fields = f;}

    FieldDisplay(ArrayList<Field> f){
        fields = f;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Field f : fields){
            if(f.GetFieldId() % 2 == 0)
                g.setColor(Color.gray);
            else g.setColor(Color.red);
            g.fillRect(f.GetFieldId() % 10 * 100, (int)(f.GetFieldId() / 10 * 100 ),98,98);
        }
    }

}
