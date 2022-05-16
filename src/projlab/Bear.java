package projlab;

import java.util.ArrayList;

public class Bear extends Agent{

    /**
     * Az Effect a medvevírus hatását valósítja meg, ezáltal
     * minden eddigi megtanult genetikus kódot elfelejt, az anyagai
     * lenullázódnak, a változót, hogy ő medve lett igazra állítjuk,
     * illetve az immunisságát is biztosítjuk, mivel ha elkapta a medvevírust,
     * akkor nem lehet őt megfertőzni semmivel sem (azaz 100%-os védettsége van),
     * valamint minden védőfelszerelése is eltűnik
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v) {
        v.Forgetting_codes();
        v.RemoveNukleotid(v.GetNukleotid().size());
        v.RemoveAminoacid(v.GetAminoacid().size());
        v.setBear(true);
        v.SetImmuneTime(100);
        ArrayList<Protection> temp = v.GetProtections();
        temp.clear();
        v.SetProtections(temp);
    }
    @Override
    public String getType() {
        return "Bear";
    }
}
