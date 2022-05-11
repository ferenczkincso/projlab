package projlab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Display {
    private JFrame window;

    private JPanel fieldPanel;
    private FieldDisplay fieldDisplay;

    private JPanel inventoryPanel;
    private InventoryDisplay inventoryDisplay;

    private Virologist currentVirologist;

    Display(ArrayList<Field>fields) {
        window = new JFrame();
        fieldPanel = new JPanel(){
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
        };
        fieldDisplay = new FieldDisplay(fieldPanel);

        inventoryPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                //...
            }
        };

        inventoryDisplay = new InventoryDisplay(inventoryPanel);

        window.add(fieldPanel);
        //window.add(inventoryPanel);
        //window.setLayout(new FlowLayout());
        window.setBounds(20,20,1500,1000);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setCurrentVirologist(Virologist v){ currentVirologist = v;}
    public Virologist getCurrentVirologist(){ return currentVirologist;}
    public FieldDisplay getFieldDisplay(){return fieldDisplay;}
    public InventoryDisplay getInventoryDisplay(){return inventoryDisplay;}


}
