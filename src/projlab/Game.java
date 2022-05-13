package projlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Game {

    private ArrayList<Virologist> virologists;
    private ArrayList<Field> fields;
    private Display display;
    private Controller controller;
    private Virologist currentVirologist;

    Game(){
        fields = new ArrayList<Field>();
        virologists = new ArrayList<Virologist>();
        display = new Display(fields);
        CreateCity();
        AddVirologist();
        AddVirologist();
        AddVirologist();
        AddVirologist();

        controller = new Controller(this);
    }

    public void startGame(){
        currentVirologist = virologists.get(0);

        while(true){
            boolean endgame = false;
            for(Virologist v : virologists) {
                if (v.GetGenetic_codes().size() == 4) endgame = true;
            }
            System.out.println(currentVirologist.getCurrent_field().GetFieldId());
            if(endgame) break;


            //...

        }
    }

    public void CreateCity(){
        Lab f1 = new Lab(display.getFieldDisplay(),11); f1.SetGenetic_code(new GC_Immunity()); fields.add(f1);
        Aminoacid_storage f2 = new Aminoacid_storage(display.getFieldDisplay(),12); fields.add(f2);
        Shelter f3 = new Shelter(display.getFieldDisplay(),13); f3.SetProtection(new Bag()); fields.add(f3);
        Lab f4 = new Lab(display.getFieldDisplay(),14); f4.SetGenetic_code(new GC_Forgetting()); fields.add(f4);

        Shelter f5 = new Shelter(display.getFieldDisplay(),21); f5.SetProtection(new Cloak()); fields.add(f5);
        Field f6 = new Field(display.getFieldDisplay(),22); fields.add(f6);
        Shelter f7 = new Shelter(display.getFieldDisplay(),23); f7.SetProtection(new Ax()); fields.add(f7);
        Lab f8 = new Lab(display.getFieldDisplay(),24); f8.SetGenetic_code(new GC_Uncontrollable()); fields.add(f8);

        Field f9 = new Field(display.getFieldDisplay(),31); fields.add(f9);
        Field f10 = new Field(display.getFieldDisplay(),32); fields.add(f10);
        Lab f11 = new Lab(display.getFieldDisplay(),33); f11.SetGenetic_code(new GC_Paralyze()); fields.add(f11);
        Lab f12 = new Lab(display.getFieldDisplay(),34); f12.SetGenetic_code(new GC_Bear()); fields.add(f12);

        Shelter f13 = new Shelter(display.getFieldDisplay(),41); f13.SetProtection(new Glove()); fields.add(f13);
        Nukleotid_storage f14 = new Nukleotid_storage(display.getFieldDisplay(),42); fields.add(f14);
        Field f15 = new Field(display.getFieldDisplay(),43); fields.add(f15);
        Field f16 = new Field(display.getFieldDisplay(),44); fields.add(f16);


        for(Field f : fields){
            for(Field k : fields){
                if(f.GetFieldId() + 1 == k.GetFieldId() || f.GetFieldId() - 1 == k.GetFieldId() || f.GetFieldId() + 10 == k.GetFieldId() || f.GetFieldId() - 10 == k.GetFieldId()){
                    f.GetNeighbours().add(k);
                }
            }
        }
    }

    public void AddVirologist(){
        Virologist v = new Virologist(display.getInventoryDisplay());
        virologists.add(v);
        Random r = new Random();
        fields.get(r.nextInt(fields.size() - 1)).Accept(v);  //hozzáadjuk egy random mezőhöz

    }

    // következő virológus jön, a controller  hívja ha megnyomnak egy gombot
    public void nextVirologist(){
        int index = virologists.indexOf(currentVirologist);
        if(index == virologists.size() - 1) currentVirologist = virologists.get(0);
        else currentVirologist = virologists.get(index + 1);
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

    //ublic void setCurrentVirologist(Virologist v){ currentVirologist = v;}
    public Virologist getCurrentVirologist(){ return currentVirologist;}
    public Display getDisplay(){return display;}




}