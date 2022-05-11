package projlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Game {

    private ArrayList<Virologist> virologists;
    private ArrayList<Field> fields;
    private Display display;



    public void startGame(){
        fields = new ArrayList<Field>();
        display = new Display(fields);
        CreateCity();
        AddVirologist();
        AddVirologist();
        AddVirologist();
        AddVirologist();

        display.setCurrentVirologist(virologists.get(0));

        while(true){
            boolean endgame = false;
            for(Virologist v : virologists) {
                if (v.GetGenetic_codes().size() == 4) endgame = true;
            }
            if(endgame) break;


            //...

        }
    }

    public void CreateCity(){
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                fields.add(new Field(display.getFieldDisplay(),10 * i + j));
            }
        }
    }

    public void AddVirologist(){
        if(virologists == null) virologists = new ArrayList<Virologist>();
        Virologist v = new Virologist(display.getInventoryDisplay());
        virologists.add(v);
        Random r = new Random();
        fields.get(r.nextInt(fields.size() - 1)).GetVirologist().add(v);  //hozzáadjuk egy random mezőhöz

    }

    // következő virológus jön, a controller fogja hivni ha megnyomnak egy gombot
    public void nextVirologist(){
        int index = virologists.indexOf(display.getCurrentVirologist());
        if(index == virologists.size() - 1) display.setCurrentVirologist(virologists.get(0));
        else display.setCurrentVirologist(virologists.get(index + 1));
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





}