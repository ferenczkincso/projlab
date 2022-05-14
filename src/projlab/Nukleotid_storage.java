package projlab;
import java.util.ArrayList;


public class Nukleotid_storage extends Storage{
    private ArrayList<Nukleotid> nukleotid;
    public Nukleotid_storage(Observer o,Observer io,int id){
        super(o,io,id);
        nukleotid = new ArrayList<Nukleotid>();
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
        while(v.GetNukleotid().size() < v.GetCapacity() && !nukleotid.isEmpty()){
            v.AddNukleotid(nukleotid.get(0));
            nukleotid.remove(0);
            fieldObserver.update();
            inventoryObserver.update();
        }
    }

    /**
     * A DestroyMaterial feladata az, hogy elpusztítsa
     * a nukleotidot, amely a raktárban található
     */
    public void DestroyMaterial() {
        nukleotid.clear();
        fieldObserver.update();
        inventoryObserver.update();
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
    public String getType(){return "Nukleotid_storage";}
    public String getCount(){return String.valueOf(nukleotid.size());}

}
