package projlab;

import java.util.ArrayList;
import java.util.Random;

public class Shelter extends Field{
    Protection protection;

    public Shelter(){
        Random rand = new Random();
        int id = rand.nextInt(4);
        switch (id){
            case 0: protection = new Bag();
            case 1: protection = new Cloak();
            case 2: protection = new Glove();
            case 3: protection  = new Ax();
        }
    }
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
