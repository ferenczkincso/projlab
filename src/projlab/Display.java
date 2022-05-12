package projlab;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
                    BufferedImage p = null;
                    switch (f.getType()){
                        case "Aminoacid_storage":
                            g.setColor(Color.red);
                            break;

                        case "Nukleotid_storage" :
                            g.setColor(Color.yellow);
                            break;

                        case "Lab" :
                            g.setColor(Color.blue);
                            break;

                        case "Shelter" :
                            g.setColor(Color.green);
                            Shelter s = (Shelter)f;
                            try {
                                switch(s.getProtection().GetType()) {
                                    case "Bag" :
                                        p = ImageIO.read(new File("src/images/bag.jpg"));
                                        break;

                                    case "Cloak" :
                                        p = ImageIO.read(new File("src/images/cloak.jpg"));
                                        break;

                                    case "Glove" :
                                        p = ImageIO.read(new File("src/images/glove.jpg"));
                                        break;

                                    case "Ax" :
                                        p = ImageIO.read(new File("src/images/ax.jpg"));
                                        break;

                                }
                            } catch (IOException e) {}
                            break;

                        default :
                            g.setColor(Color.gray);
                            break;

                    }
                    int x = f.GetFieldId() % 10 * 100;
                    int y = (int) (f.GetFieldId() / 10) * 100 ;
                    g.fillRect(x, y,98,98);
                    for(Virologist v : f.GetVirologist()) {
                        if(v.isBear()) g.setColor(new Color(153,102,0));
                        else if(v.GetUncontrollableTime() > 0) g.setColor(Color.orange);
                        else if(v.GetParalyzedTime() > 0) g.setColor(Color.pink);
                        else g.setColor(Color.black);
                        g.fillOval(x +10, y + 10, 20, 20);
                        g.setColor(Color.black);
                        g.drawOval(x +10 ,y + 10,20,20);
                            g.drawImage(p,x + 64,y + 64,this);

                        x += 30;

                    }
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
