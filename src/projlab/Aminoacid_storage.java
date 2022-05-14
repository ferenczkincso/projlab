package projlab;
import java.util.ArrayList;
import java.util.List;

public class Aminoacid_storage extends Storage{
    private ArrayList<Aminoacid> aminoacid;

    public Aminoacid_storage(Observer o,Observer oi,int id){
        super(o,oi,id);
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
            inventoryObserver.update();
            fieldObserver.update();
        }
    }

    /**
     * A DestroyMaterial feladata az, hogy elpusztítsa
     * az aminosavat, amely a raktárban található
     */
    public void DestroyMaterial() {
        aminoacid.clear();
        inventoryObserver.update();
        fieldObserver.update();
    }

    /**
     * Az Accept-tel engedjük fel a virológust a mezőre,
     * itt leellenőrizzük, hogy a virológus medve-e, ha
     * igen, akkor elpusztítja az anyagot, ha nem az, akkor
     * rálép a mezőre
     * @param v - A virológus, aki erre a mezőre szeretne lépni
     */
    public void Accept(Virologist v){
        if (v.isBear()){
            DestroyMaterial();
        }
        super.Accept(v);
    }

    /**
     * A Tick függvénnyel az aminosav újratermelődését biztosítjuk
     */

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
    }
    public String getType(){return "Aminoacid_storage";}
    public String getCount(){return String.valueOf(aminoacid.size());}
}
