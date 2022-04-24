package projlab;
import java.util.ArrayList;
import java.util.List;

public class Aminoacid_storage extends Storage{
    private ArrayList<Aminoacid> aminoacid;

    public Aminoacid_storage(int id){
        super(id);
        aminoacid = new ArrayList<Aminoacid>();
        for (int i = 0; i<5; i++){
            Aminoacid a = new Aminoacid();
            aminoacid.add(a);
        }
    }
    /**
     * A Collect függvény feladata, hogy összegyűjtse
     * a raktárból az aminosavat, és a Virológus
     * aminosav készletét bővítse.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Collect(Virologist v){
        while(v.GetAminoacid().size() < v.GetCapacity() && !aminoacid.isEmpty()){
            v.AddAminoacid(aminoacid.get(0));
            aminoacid.remove(0);
        }
    }

    public void DestroyMaterial() {
        aminoacid.clear();
    }

    public void Accept(Virologist v){
        if (v.isBear()){
            DestroyMaterial();
        }
        super.Accept(v);
    }

    @Override
    public void Tick(){
        tickCount++;
        if (tickCount==100){
            aminoacid.clear();
            for (int i = 0; i<5; i++){
                Aminoacid a = new Aminoacid();
                aminoacid.add(a);
            }
            tickCount = 0;
        }
    };
}
