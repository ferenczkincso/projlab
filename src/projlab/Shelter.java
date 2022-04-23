package projlab;

import java.util.ArrayList;

public class Shelter extends Field{
    Protection protection;

    /**
     * A menedékben tartózkodó virológus begyűjti a
     * védőfelszerelést
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Collect(Virologist v) {
        ArrayList<Protection> p = new ArrayList<Protection>();
        p = v.GetProtections();
        p.add(protection);
        v.SetProtections(p);
    }
}
