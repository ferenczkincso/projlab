package projlab;
import java.util.ArrayList;
import java.util.List;

public class Field {
    protected int fieldID;
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologist;

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

    public ArrayList<Virologist> GetVirologistNearBy() {
        ArrayList<Field> n = new ArrayList<Field>();
        n = GetNeighbours();
        ArrayList<Virologist> v = new ArrayList<Virologist>();
        for(Field f : n){
            ArrayList<Virologist> x = new ArrayList<Virologist>();
            x = f.GetVirologist();
            for(Virologist vi : x){
                v.add(vi);
            }
        }
        return v;
    }


    /**
     * Ha a virológus egy másik mezőre szeretne lépni, akkor
     * hívódik meg ez a függvény, amely megengedi, hogy ő
     * rálépjen a mezőre.
     * Ha a mezőn már van 2 virológus, akkor nem tud rálépni.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Accept(Virologist v){
        if(virologist.size() < 2){
            virologist.add(v);
            v.setCurrent_field(this);
        }
    }

    /**
     * Ha egy virológus a mezőjéről, amin éppen áll el szeretne
     * lépni, akkor hívódik meg a Remove függvény, amely
     * felelős azért, hogy levegyük a virológust a mezőről.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Remove(Virologist v){
        virologist.remove(v);
        v.setCurrent_field(null);
    }

    /**
     * A Collect függvény segítségével tud a virológus a
     * mezőről anyagot begyűjteni.
     * @param v - A virológus, akire kifejti a hatást
     * Itt nincs implementálva
     */

    public void Collect(Virologist v){
    }

}