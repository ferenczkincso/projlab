package projlab;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JComboBox jcb;
    private JButton button;
    public MainMenu() throws HeadlessException {
        setTitle("A világtalan virológusok világa");
        setSize(400,250);
        setLocation(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout layo = new GridLayout();
        layo.setRows(3);
        layo.setColumns(1);
        this.setLayout(layo);

        JPanel jp1= new JPanel(new FlowLayout());
        add(jp1);
        JLabel title = new JLabel("A világtalan virológusok világa");
        title.setFont(new Font("TimesRoman", Font.BOLD, 25));
        jp1.add(title);

        JPanel jp2 = new JPanel(new FlowLayout());
        add(jp2);
        JLabel lab1= new JLabel("Játékosok száma:");
        lab1.setFont(new Font("TimesRoman",Font.PLAIN ,15));
        String[] tomb = {"2", "3", "4"};
        jcb = new JComboBox(tomb);
        jp2.add(lab1);
        jp2.add(jcb);

        JPanel jp3= new JPanel(new FlowLayout());
        add(jp3);
        button = new JButton("START");
        jp3.add(button);

        setResizable(false);
        setVisible(true);
    }

    public JButton getButton(){return button;}
    public String getText(){return jcb.getSelectedItem().toString();}

}
