package projlab;
import java.util.List;

public class Aminoacid_storage extends Storage{
    private List<Aminoacid> aminoacid;

    /**
     * A Collect függvény feladata, hogy összegyűjtse
     * a raktárból az aminosavat, és a Virológus
     * aminosav készletét bővítse.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Collect(Virologist v){
        if(aminoacid != null){
            for(Aminoacid a : aminoacid){
                v.AddAminoacid(a);
            }
        }
    }

    public void DestroyMaterial(Virologist v) {
        aminoacid = null;
    }

    public void Accept(Virologist v){
        //itt azt hogy tudom ellenőrizni, hogy meg van e fertőződve medvevírussal?
    }
}
