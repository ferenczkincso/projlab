package projlab;
import java.util.List;


public class Nukleotid_storage extends Storage{
    private List<Nukleotid> nukleotid;

    /**
     * A paraméterben kapott virológusnak nukleotidokat tölt fel
     * kapacitásig vagy amennyi található a raktárban.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Collect(Virologist v){
        if(!nukleotid.isEmpty()){
            for(Nukleotid n : nukleotid){
                v.AddNukleotid(n);
            }
        }
    }

    public void DestroyMaterial() {
        nukleotid.clear();
    }

    /**
     * A Field ősosztály függvénye,
     * a megvalósítás annyiban tér el az eredetitől,
     * hogy ellenőrzi a paraméterben kapott virológusról,
     * hogy medve vírussal fertőzött-e. Ha fertőzött, akkor meghívja a DestroyMaterial() függvényt.
     */

    public void Accept(Virologist v){
        // itt hogy ellenőrzöm hogy meg van e fertőzve?
    }
    ///termelés miatt kell
    @Override
    public void Tick(){}

}
