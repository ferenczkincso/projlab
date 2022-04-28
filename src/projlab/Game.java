package projlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {

    private ArrayList<Virologist> virologists;
    private ArrayList<Field> fields;


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

    /**
     * Az EndGame feladata a játék befejezése
     */
    public void EndGame() {

        System.out.println("EndGame()");
    }

    /**
     * A CreateCity feladata a pálya "elkészítése", a mezők
     * létrehozása
     */
    public void CreateCity(){
        System.out.println("CreateCity()");
    }

    /**
     * Az AddVirologist felelős azért, hogy a virológust a
     * pályára rakja
     */
    public void AddVirologist(){
        //System.out.println("AddVirologist()");
    }

    /**
     * A játék elkezdése a feladata
     */
    public void NewGame(){
        System.out.println("NewGame()");
        AddVirologist();
        CreateCity();
    }
}