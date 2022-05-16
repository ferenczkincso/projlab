package projlab;

import javax.swing.*;
import java.awt.event.KeyListener;
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

    Game(){
        fields = new ArrayList<Field>();
        virologists = new ArrayList<Virologist>();

        display = new Display(this);
        CreateCity();
        AddVirologist("Player1");
        AddVirologist("Player2");
        AddVirologist("Player3");
        AddVirologist("Player4");
        controller = new Controller(this);
        addKeyListener(controller);

    }

    public void removeVirologist(Virologist v){
        virologists.remove(v);
        v.getCurrent_field().Remove(v);
        v.getInventoryObserver().update();
        v.getFieldObserver().update();
    }

    public void Tick(){
        for(Virologist v : virologists) {
            if (v.GetGenetic_codes().size() == 4) endGame();
        }
    }

    public void addKeyListener(KeyListener listener){
        display.getWindow().addKeyListener(listener);
    }

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

    public void endGame(){
        if(!currentVirologist.isBear()){
            JOptionPane.showMessageDialog(null, currentVirologist.getName() + " Nyert!", "Játék vége", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Mindenki vesztett!", "Játék vége", JOptionPane.INFORMATION_MESSAGE);

        }
        display.getWindow().removeKeyListener(controller);
        controller = null;
        virologists.clear();
    }

    public void CreateCity(){
        Lab f1 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),11); f1.SetGenetic_code(new GC_Immunity()); fields.add(f1);
        Aminoacid_storage f2 = new Aminoacid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),12); fields.add(f2);
        Shelter f3 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),13); f3.SetProtection(new Bag()); fields.add(f3);
        Lab f4 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),14); f4.SetGenetic_code(new GC_Forgetting()); fields.add(f4);

        Shelter f5 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),21); f5.SetProtection(new Cloak()); fields.add(f5);
        Field f6 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),22); fields.add(f6);
        Shelter f7 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),23); f7.SetProtection(new Ax()); fields.add(f7);
        Lab f8 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),24); f8.SetGenetic_code(new GC_Uncontrollable()); fields.add(f8);

        Field f9 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),31); fields.add(f9);
        Field f10 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),32); fields.add(f10);
        Lab f11 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),33); f11.SetGenetic_code(new GC_Paralyze()); fields.add(f11);
        Lab f12 = new Lab(display.getFieldDisplay(),display.getInventoryDisplay(),34); f12.SetGenetic_code(new GC_Bear()); fields.add(f12);

        Shelter f13 = new Shelter(display.getFieldDisplay(),display.getInventoryDisplay(),41); f13.SetProtection(new Glove()); fields.add(f13);
        Nukleotid_storage f14 = new Nukleotid_storage(display.getFieldDisplay(),display.getInventoryDisplay(),42); fields.add(f14);
        Field f15 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),43); fields.add(f15);
        Field f16 = new Field(display.getFieldDisplay(),display.getInventoryDisplay(),44); fields.add(f16);


        for(Field f : fields){
            for(Field k : fields){
                if(f.GetFieldId() + 1 == k.GetFieldId() || f.GetFieldId() - 1 == k.GetFieldId() || f.GetFieldId() + 10 == k.GetFieldId() || f.GetFieldId() - 10 == k.GetFieldId()){
                    f.GetNeighbours().add(k);
                }
            }
        }
    }

    public void AddVirologist(String name){
        Virologist v = new Virologist(display.getFieldDisplay(), display.getInventoryDisplay(), name);
        virologists.add(v);
        Random r = new Random();
        fields.get(r.nextInt(fields.size() - 1)).Accept(v);  //hozzáadjuk egy random mezőhöz

    }

    public boolean isAllBear(){
        boolean allBear = true;
        for(Virologist v : virologists){
            if(!v.isBear())
                allBear = false;
        }
        return allBear;
    }

    // következő virológus jön, a controller  hívja ha megnyomnak egy gombot
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