package projlab;
import java.util.List;

public class Field {
    protected int fieldID;
    private List<Field> neighbours;
    private Virologist virologist;

    /**
     * A GetNeighbours visszatér a szomszéd mezők listájával.
     * @return a szomszéd mezők gyűjteményét adja vissza
     */

    public List<Field> GetNeighbours(){
        System.out.println("f.GetNeighbours()");
        return neighbours;
    }

    /**
     * a GetVirologistNearby függvény feladata, hogy visszaadja
     * az adott mezőn lévő másik virológust
     * @return a mezőn lévő másik virológust, vagy ha nincs
     * ezen a mezőn, akkor null-t térít vissza
     */

    public Virologist GetVirologistNearby(){
        virologist = new Virologist();
        return virologist;
    }

    /**
     * Ha a virológus egy másik mezőre szeretne lépni, akkor
     * hívódik meg ez a függvény, amely megengedi, hogy ő
     * rálépjen a mezőre.
     * Ha a mezőn már van 2 virológus, akkor nem tud rálépni.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Accept(Virologist v){
        System.out.println("Accept(v)");
    }

    /**
     * Ha egy virológus a mezőjéről, amin éppen áll el szeretne
     * lépni, akkor hívódik meg a Remove függvény, amely
     * felelős azért, hogy levegyük a virológust a mezőről.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Remove(Virologist v){
        System.out.println("Remove(v)");
    }

    /**
     * A Collect függvény segítségével tud a virológus a
     * mezőről anyagot begyűjteni.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Collect(Virologist v){
        System.out.println("Collect(v)");
    }

}