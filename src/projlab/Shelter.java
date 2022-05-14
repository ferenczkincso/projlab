package projlab;

import java.util.ArrayList;
import java.util.Random;

public class Shelter extends Field{
    private Protection protection;

    public Shelter(Observer o,Observer io,int i){
        super(o,io,i);
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
        int counter = 0;
        for (Protection p: v.GetProtections())
        {
            counter++;
            if (p.getClass().equals(protection.getClass())) return;
            if (counter==3) return;
        }
        v.GetProtections().add(protection);
        fieldObserver.update();
        inventoryObserver.update();
        if(!protection.getClass().equals(Ax.class)) {
            protection.Effect(v);
        }
        protection = null;
    }

    public void SetProtection(Protection p){protection = p;}
    public Protection getProtection() {return protection;}
    public String getType(){return "Shelter";}


}
