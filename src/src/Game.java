package src;

import java.util.List;

public class Game {

    private List<Virologist> virologists;
    private List<Field> fields;

    public void EndGame(){System.out.println("EndGame()");}

    public void CreateCity(){
        System.out.println("CreateCity()");
    }

    public void AddVirologist(){
        System.out.println("AddVirologist()");
    }

    public void NewGame(){
        System.out.println("NewGame()");
        AddVirologist();
        CreateCity();
    }
}