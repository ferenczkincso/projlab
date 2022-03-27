package projlab;
import java.util.List;


public class Nukleotid_storage extends Storage{
    private List<Nukleotid> nukleotid;

    /**
     * A Collect függvény feladata, hogy összegyűjtse
     * a raktárból a nukleotidokat, és a Virológus
     * nukleotid készletét bővítse.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Collect(Virologist v){
        System.out.println("nukleotid_storage.Collect(v)");
    }
}
