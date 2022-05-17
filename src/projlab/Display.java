package projlab;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Display {
    private JFrame window;

    private JPanel fieldPanel;
    private FieldDisplay fieldDisplay;

    private JPanel inventoryPanel;
    private InventoryDisplay inventoryDisplay;



    Display(Game game) {
        window = new JFrame();
        fieldPanel = new JPanel(){
            BufferedImage p = null;

            /**
             * A paintComponent rajzolja ki a filedeket, a protectionokat és a virológusokat
             * @param g - a grafikus megjelenítés végett szükséges
             */
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                for(Field f : game.getFields()){

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
                            if(s.getProtection() == null) break;
                                switch(s.getProtection().GetType()) {
                                    case "Bag" :
                                        try {
                                            p = ImageIO.read(new File("src/images/bag.jpg"));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case "Cloak" :
                                        try {
                                            p = ImageIO.read(new File("src/images/cloak.jpg"));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case "Glove" :
                                        try {
                                            p = ImageIO.read(new File("src/images/glove.jpg"));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case "Ax" :
                                        try {
                                            p = ImageIO.read(new File("src/images/ax.jpg"));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                }
                            break;

                        default :
                            g.setColor(Color.gray);
                            break;
                    }
                    Graphics2D g2 = (Graphics2D) g;
                    Stroke oldStroke = g2.getStroke();
                    int x = f.GetFieldId() % 10 * 100;
                    int y = (int) (f.GetFieldId() / 10) * 100 ;
                    g2.fillRect(x, y, 100, 100);
                    g2.setColor(Color.BLACK);
                    g2.setStroke(new BasicStroke(2.0f));
                    g2.drawRect(x, y, 100, 100);
                    g2.setStroke(oldStroke);
                    int fixX = x;
                    int fixY = y;
                    for(Virologist v : f.GetVirologist()) {
                        if(v.isBear()) g.setColor(new Color(153,102,0));
                        else if(v.GetUncontrollableTime() > 0) g.setColor(new Color(255,140,0));
                        else if(v.GetParalyzedTime() > 0) g.setColor(Color.pink);
                        else if(v.GetImmuneTime() > 0) g.setColor(Color.cyan);
                        else g.setColor(Color.black);
                        g.fillOval(x +10, y + 10, 20, 20);
                        if(v.equals(game.getCurrentVirologist())) g.setColor(Color.white);
                        else g.setColor(Color.black);
                        g.drawOval(x +10 ,y + 10,20,20);
                        x += 30;
                    }
                    if(f.getType().equals("Shelter")) {
                        g.drawImage(p, fixX + 63, fixY + 63, this);
                    }else if(f.getType().equals("Aminoacid_storage")){
                        g.setColor(Color.black);
                        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                        Aminoacid_storage as = (Aminoacid_storage)f;
                        g.drawString(as.getCount(),fixX + 75, fixY + 75);
                    }else if(f.getType().equals("Nukleotid_storage")){
                        g.setColor(Color.black);
                        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                        Nukleotid_storage ns = (Nukleotid_storage) f;
                        g.drawString(ns.getCount(),fixX + 75, fixY + 75);
                    }
                    p = null;
                }
                Graphics2D g2 = (Graphics2D) g;
                Stroke oldStroke = g2.getStroke();
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(3.0f));
                g2.drawRect(10,10,getWidth()-20,getHeight()-20);
                g2.setStroke(oldStroke);
                g2.setFont(new Font("TimesRoman", Font.BOLD, 15));
                g2.drawString(game.getCurrentVirologist().getName(), 20,30);
            }
        };

        fieldPanel.setPreferredSize(new Dimension(1050,600));
        fieldDisplay = new FieldDisplay(fieldPanel);



        inventoryPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Stroke oldStroke = g2.getStroke();
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(3.0f));
                g2.drawRect(10,10,400-20,500-20);
                g2.setStroke(oldStroke);
            }
        };


        JPanel protections = new JPanel(){  // protectionok panele
            @Override
            public void paintComponent(Graphics g){
                BufferedImage p = null;
                super.paintComponent(g);

                int x = 20;
                int y = 20;
                for(Protection pr : game.getCurrentVirologist().GetProtections()){
                    switch(pr.GetType()) {
                        case "Bag" :
                            try {
                                p = ImageIO.read(new File("src/images/bag.jpg"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;

                        case "Cloak" :
                            try {
                                p = ImageIO.read(new File("src/images/cloak.jpg"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;

                        case "Glove" :
                            try {
                                p = ImageIO.read(new File("src/images/glove.jpg"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;

                        case "Ax" :
                            try {
                                p = ImageIO.read(new File("src/images/ax.jpg"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    g.drawImage(p,x,y,this);
                    x += 50;
                }
            }
        };
        protections.setPreferredSize(new Dimension(300,60));
        protections.setLocation(20,40);

        JPanel materials = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D)g;
                super.paintComponent(g2);
                int aminoNr;
                int nukleoNr;
                int capacity;
                try {
                    aminoNr = game.getCurrentVirologist().GetAminoacid().size();
                    nukleoNr = game.getCurrentVirologist().GetNukleotid().size();
                    capacity = game.getCurrentVirologist().GetCapacity();
                }catch(NullPointerException e){
                    aminoNr = 0;
                    nukleoNr = 0;
                    capacity = 15;
                }
                String amino = "Aminoacid: " + aminoNr + "/" + capacity;
                String nukleo = "Nukleotid: " + nukleoNr + "/" + capacity;
                g2.setFont(new Font("TimesRoman", Font.BOLD, 15));
                g2.drawString(amino, 20, 40);
                g2.drawString(nukleo, 150, 40);
                g2.drawString("Genetic Codes:",20,60);
                int y = 80;
                for(GeneticCode gc : game.getCurrentVirologist().GetGenetic_codes()){
                    g2.drawString(gc.getType(),25,y);
                    y += 20;
                }
                g2.drawString("Agents:",20,y);
                for(Agent a : game.getCurrentVirologist().GetAgent()){
                    y += 20;
                    g2.drawString(a.getType(),25,y);
                }
            }
        };
        materials.setPreferredSize(new Dimension(300,500));
        materials.setLocation(0,0);

        inventoryPanel.setLayout(new FlowLayout());
        inventoryPanel.setPreferredSize(new Dimension(400,500));
        inventoryPanel.add(protections);
        inventoryPanel.add(materials);
        inventoryDisplay = new InventoryDisplay(inventoryPanel);

        window.setLayout(new BorderLayout());
        window.add(fieldPanel,BorderLayout.LINE_START);
        window.add(inventoryPanel,BorderLayout.LINE_END);
        window.setBounds(20,20,1500,1000);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public FieldDisplay getFieldDisplay(){return fieldDisplay;}
    public InventoryDisplay getInventoryDisplay(){return inventoryDisplay;}

    public JPanel getFieldPanel() {
        return fieldPanel;
    }
    public JFrame getWindow(){return window;}
}
