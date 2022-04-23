package projlab;
import java.util.List;


public class Nukleotid_storage extends Storage{
    private List<Nukleotid> nukleotid;
    public Nukleotid_storage(){
        for (int i = 0; i<5; i++){
            Nukleotid n = new Nukleotid();
            nukleotid.add(n);
        }
    }
    /**
     * A paraméterben kapott virológusnak nukleotidokat tölt fel
     * kapacitásig vagy amennyi található a raktárban.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Collect(Virologist v){
        if(!nukleotid.isEmpty()){
            for(Nukleotid n : nukleotid){
                if (v.GetNukleotid().size() < v.GetCapacity()){
                    v.AddNukleotid(n);
                    nukleotid.remove(n);
                }
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
        if (v.isBear()){
            DestroyMaterial();
        }
        super.Accept(v);
    }
    ///termelés miatt kell
    @Override
    public void Tick(){
        tickCount++;
        if (tickCount==100){
            nukleotid.clear();
            for (int i = 0; i<5; i++){
                Nukleotid n = new Nukleotid();
                nukleotid.add(n);
            }
            tickCount = 0;
        }
    }

}
