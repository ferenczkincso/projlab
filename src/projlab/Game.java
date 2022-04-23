package projlab;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private ArrayList<Virologist> virologists;
    private ArrayList<Field> fields;

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
        System.out.println("AddVirologist()");
    }

    /**
     * A játék elkezdése a feladata
     */
    public void NewGame(){
        System.out.println("NewGame()");
        AddVirologist();
        CreateCity();
    }

    public ArrayList<Virologist> GetVirologists(){return virologists;}
    public ArrayList <Field> GetFields(){return fields;}
}