package projlab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Game implements Ticker {

    private ArrayList<Virologist> virologists;
    private ArrayList<Field> fields;
    private Display display;
    private Controller controller;
    private Virologist currentVirologist;

    Game() throws InterruptedException {
        MainMenu mn = new MainMenu();
        final int[] i = {0};
        mn.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i[0] = Integer.parseInt(mn.getText());
            }
        });
        while(i[0] == 0){
            Thread.sleep(10);
        }


        fields = new ArrayList<Field>();
        virologists = new ArrayList<Virologist>();

        display = new Display(this);
        CreateCity();
        for(int j = 1; j <= i[0]; j++) {
            AddVirologist("Player"+j);
        }

        controller = new Controller(this);
        addKeyListener(controller);

    }

    /**
     * A játékos törlése a pályáról
     * @param v - a virológus, akit törölni kell
     */
    public void removeVirologist(Virologist v){
        virologists.remove(v);
        v.getCurrent_field().Remove(v);
        v.getInventoryObserver().update();
        v.getFieldObserver().update();
    }

    /**
     * A játék végét figyeli, azaz, ha mind a 4 genetikus kódot
     * megtanulta a virológus
     */
    public void Tick(){
        for(Virologist v : virologists) {
            if (v.GetGenetic_codes().size() == 4) endGame();
        }
    }

    public void addKeyListener(KeyListener listener){
        display.getWindow().addKeyListener(listener);
    }

    /**
     * A játék elindításáért felelős függvény
     */
    public void startGame(){
        currentVirologist = virologists.get(0);
        boolean isGame = true;
        boolean allBear = false;
        Virologist d = null;
        while (isGame && !allBear){
            allBear = true;
            for(Virologist v : virologists){
                if(v.GetGenetic_codes().size() == 4) isGame = false;
                if(!v.isBear()) allBear = false;
                if(v.isDied()){ d = v;}
            }
            if(d != null) removeVirologist(d);
            d = null;
        }
    }

    /**
     * Ha a játék véget ér, meghívódik ez a függvény, mely kiírja, az üzenetet, hogy ki nyert
     * illetve ha mindenki medve, akkor azt, hogy mindenki veszített
     */
    public void endGame(){
        if(!currentVirologist.isBear()){
            JOptionPane.showMessageDialog(null, currentVirologist.getName() + " is the winner!", "Game ended", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Everyone lost!", "Game over", JOptionPane.INFORMATION_MESSAGE);

        }
        display.getWindow().removeKeyListener(controller);
        controller = null;
        virologists.clear();
    }

    /**
     * A pályát megvalósító metódus
     */
    public void CreateCity(){
        Lab f1 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),11); f1.SetGenetic_code(new GC_Immunity()); fields.add(f1);
        Aminoacid_storage f2 = new Aminoacid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),12); fields.add(f2);
        Shelter f3 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),13); f3.SetProtection(new Bag()); fields.add(f3);
        Lab f4 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),14); f4.SetGenetic_code(new GC_Forgetting()); fields.add(f4);
        Lab f17 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),15); f17.SetGenetic_code(new GC_Immunity()); fields.add(f17);
        Nukleotid_storage f18 = new Nukleotid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),16); fields.add(f18);
        Shelter f19 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),17); f19.SetProtection(new Bag()); fields.add(f19);
        Lab f20 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),18); f20.SetGenetic_code(new GC_Forgetting()); fields.add(f20);

        Shelter f5 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),21); f5.SetProtection(new Cloak()); fields.add(f5);
        Field f6 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),22); fields.add(f6);
        Shelter f7 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),23); f7.SetProtection(new Ax()); fields.add(f7);
        Lab f8 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),24); f8.SetGenetic_code(new GC_Uncontrollable()); fields.add(f8);
        Shelter f21 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),25); f21.SetProtection(new Cloak()); fields.add(f21);
        Field f22 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),26); fields.add(f22);
        Shelter f23 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),27); f23.SetProtection(new Ax()); fields.add(f23);
        Lab f24 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),28); f24.SetGenetic_code(new GC_Uncontrollable()); fields.add(f24);

        Field f9 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),31); fields.add(f9);
        Field f10 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),32); fields.add(f10);
        Lab f11 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),33); f11.SetGenetic_code(new GC_Paralyze()); fields.add(f11);
        Lab f12 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),34); f12.SetGenetic_code(new GC_Bear()); fields.add(f12);
        Field f25 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),35); fields.add(f25);
        Field f26 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),36); fields.add(f26);
        Lab f27 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),37); f27.SetGenetic_code(new GC_Paralyze()); fields.add(f27);
        Lab f28 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),38); f28.SetGenetic_code(new GC_Bear()); fields.add(f28);

        Shelter f13 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),41); f13.SetProtection(new Glove()); fields.add(f13);
        Nukleotid_storage f14 = new Nukleotid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),42); fields.add(f14);
        Field f15 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),43); fields.add(f15);
        Field f16 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),44); fields.add(f16);
        Shelter f29 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),45); f29.SetProtection(new Glove()); fields.add(f29);
        Aminoacid_storage f30 = new Aminoacid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),46); fields.add(f30);
        Field f31 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),47); fields.add(f31);
        Field f32 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),48); fields.add(f32);

         f1 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),51); f1.SetGenetic_code(new GC_Immunity()); fields.add(f1);
         f2 = new Aminoacid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),52); fields.add(f2);
         f3 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),53); f3.SetProtection(new Bag()); fields.add(f3);
         f4 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),54); f4.SetGenetic_code(new GC_Forgetting()); fields.add(f4);
         f17 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),55); f17.SetGenetic_code(new GC_Immunity()); fields.add(f17);
         f18 = new Nukleotid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),56); fields.add(f18);
         f19 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),57); f19.SetProtection(new Bag()); fields.add(f19);
         f20 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),58); f20.SetGenetic_code(new GC_Forgetting()); fields.add(f20);

         f5 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),61); f5.SetProtection(new Cloak()); fields.add(f5);
         f6 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),62); fields.add(f6);
         f7 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),63); f7.SetProtection(new Ax()); fields.add(f7);
         f8 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),64); f8.SetGenetic_code(new GC_Uncontrollable()); fields.add(f8);
         f21 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),65); f21.SetProtection(new Cloak()); fields.add(f21);
         f22 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),66); fields.add(f22);
         f23 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),67); f23.SetProtection(new Ax()); fields.add(f23);
         f24 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),68); f24.SetGenetic_code(new GC_Uncontrollable()); fields.add(f24);

         f9 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),71); fields.add(f9);
         f10 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),72); fields.add(f10);
         f11 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),73); f11.SetGenetic_code(new GC_Paralyze()); fields.add(f11);
         f12 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),74); f12.SetGenetic_code(new GC_Bear()); fields.add(f12);
         f25 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),75); fields.add(f25);
         f26 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),76); fields.add(f26);
         f27 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),77); f27.SetGenetic_code(new GC_Paralyze()); fields.add(f27);
         f28 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),78); f28.SetGenetic_code(new GC_Bear()); fields.add(f28);

         f13 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),81); f13.SetProtection(new Glove()); fields.add(f13);
         f14 = new Nukleotid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),82); fields.add(f14);
         f15 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),83); fields.add(f15);
         f16 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),84); fields.add(f16);
         f29 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),85); f29.SetProtection(new Glove()); fields.add(f29);
         f30 = new Aminoacid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),86); fields.add(f30);
         f31 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),87); fields.add(f31);
         f32 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),88); fields.add(f32);



        for(Field f : fields){
            for(Field k : fields){
                if(f.GetFieldId() + 1 == k.GetFieldId() || f.GetFieldId() - 1 == k.GetFieldId() || f.GetFieldId() + 10 == k.GetFieldId() || f.GetFieldId() - 10 == k.GetFieldId()){
                    f.GetNeighbours().add(k);
                }
            }
        }
    }

    /**
     * Virológus hozzáadása a pályára
     * @param name - a virológus neve
     */
    public void AddVirologist(String name){
        Virologist v = new Virologist(display.getFieldDisplay(), display.getInventoryDisplay(), name);
        virologists.add(v);
        Random r = new Random();
        fields.get(r.nextInt(fields.size() - 1)).Accept(v);  //hozzáadjuk egy random mezőhöz

    }

    /**
     * A virológusok megfigyelése, hogy medvévé változtak-e
     * @return - visszatér igaz/hamissal, hogy mindegyik medvévé változott-e
     */
    public boolean isAllBear(){
        boolean allBear = true;
        for(Virologist v : virologists){
            if(!v.isBear())
                allBear = false;
        }
        return allBear;
    }

    /**
     * Következő virológus jön, a controller  hívja ha megnyomnak egy gombot
     */
    public void nextVirologist(){
        if(isAllBear()) return;
        int index = virologists.indexOf(currentVirologist);
        if(index == virologists.size() - 1) currentVirologist = virologists.get(0);
        else currentVirologist = virologists.get(index + 1);

        if (currentVirologist.GetParalyzedTime()>0 || currentVirologist.GetUncontrollableTime()>0 || currentVirologist.isBear()){
            nextVirologist();
        }
        currentVirologist.getInventoryObserver().update();
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }

    public List<Virologist> getVirologists() {
        return virologists;
    }

    public void setVirologists(ArrayList<Virologist> virologists) {
        this.virologists = virologists;
    }

    //public void setCurrentVirologist(Virologist v){ currentVirologist = v;}
    public Virologist getCurrentVirologist(){ return currentVirologist;}
    public Display getDisplay(){return display;}

}