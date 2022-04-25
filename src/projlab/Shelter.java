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
    @Override
    public void Collect(Virologist v) {
        for (Protection p: v.GetProtections())
        {
            if (p.getClass().equals(protection.getClass())) return;
        }
        v.GetProtections().add(protection);
        if(!this.getClass().equals(Ax.class)) {
            protection.Effect(v);
        }
    }

    public void SetProtection(Protection p){protection = p;}
}
