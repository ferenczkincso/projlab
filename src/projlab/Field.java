package projlab;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Field extends Observable implements Ticker{
    protected int fieldId;
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologist;
    private FieldDisplay fieldDisplay;

    public Field(Observer o,Observer i,int id){
        super(o,i);
        fieldId = id;
        neighbours = new ArrayList<Field>();
        virologist = new ArrayList<Virologist>();
    }

    /**
     * Visszatér a mezőn lévő virológusokkal.
     * @return a mezőn lévő virológusokat adja vissza
     */

    public ArrayList<Virologist> GetVirologist() {
        return virologist;
    }

    /**
     * A GetNeighbours visszatér a szomszéd mezők listájával.
     * @return a szomszéd mezők gyűjteményét adja vissza
     */

    public ArrayList<Field> GetNeighbours(){
        return neighbours;
    }

    /**
     * Visszaadja a szomszédos mezőkön levő virológusokat
     * @return a szomszéd mezőkön levő virológusok listájával tér vissza
     */

    public Virologist GetVirologistNearBy(Virologist v) {
        if (v.getName()==virologist.get(0).getName()){
            return virologist.get(1);
        }
        return virologist.get(0);
    }


    /**
     * Ha a virológus egy másik mezőre szeretne lépni, akkor
     * hívódik meg ez a függvény, amely megengedi, hogy ő
     * rálépjen a mezőre.
     * Ha a mezőn már van 2 virológus, akkor nem tud rálépni.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Accept(Virologist v){
       // if(virologist.size() < 2){
            virologist.add(v);
            v.setCurrent_field(this);
            fieldObserver.update();
       // }
    }

    /**
     * Ha egy virológus a mezőjéről, amin éppen áll el szeretne
     * lépni, akkor hívódik meg a Remove függvény, amely
     * felelős azért, hogy levegyük a virológust a mezőről.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Remove(Virologist v){
        virologist.remove(v);
        int fID = v.getCurrent_field().GetFieldId();
        v.setCurrent_field(null);
        fieldObserver.update();
    }

    /**
     * A Collect függvény segítségével tud a virológus a
     * mezőről anyagot begyűjteni.
     * @param v - A virológus, akire kifejti a hatást
     * Itt nincs implementálva
     */

    public void Collect(Virologist v){
    }

    @Override
    public void Tick() {
        //üres
    }

    public int GetFieldId(){return fieldId;}
    public String getType(){return "Field";}



}