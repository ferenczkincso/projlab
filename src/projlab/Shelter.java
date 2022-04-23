package projlab;

import java.util.ArrayList;
import java.util.Random;

public class Shelter extends Field{
    Protection protection;

    public Shelter(int i){
        super(i);
        Random rand = new Random();
        int id = rand.nextInt(4);
        switch (id){
            case 0: protection = new Bag(); break;
            case 1: protection = new Cloak(); break;
            case 2: protection = new Glove(); break;
            case 3: protection  = new Ax(); break;
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
        boolean alreadyHas = false;
        for(Protection pr : p){
            if(pr.getClass() == protection.getClass()){
                alreadyHas= true;
                break;
            }
        }
        if(!alreadyHas){
            p.add(protection);
            v.SetProtections(p);
        }
    }

    public void SetProtection(Protection p){protection = p;}
}
