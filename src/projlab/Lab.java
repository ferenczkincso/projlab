package projlab;

import java.util.ArrayList;
import java.util.Random;

public class Lab extends Field{
    private GeneticCode genetic_code;

    public Lab(Observer o,Observer io,int i){
        super(o,io,i);
        Random rand = new Random();
        int id = rand.nextInt(4);
        int temp = rand.nextInt(100)+1;
        if (temp%5==0) id = 4;
        switch (id){
            case 0: genetic_code = new GC_Uncontrollable(); break;
            case 1: genetic_code = new GC_Paralyze(); break;
            case 2: genetic_code = new GC_Immunity(); break;
            case 3: genetic_code = new GC_Forgetting(); break;
            case 4: genetic_code = new GC_Bear(); break;
        }
    }

    /**
     * Felelőssége, hogy az adott virológus megtanulja
     * a labor falán lévő genetikai kódot
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Learn_code(Virologist v) {
        ArrayList<GeneticCode> g = new ArrayList<GeneticCode>();
        g = v.GetGenetic_codes();
        boolean alreadyKnowsCode = false;
        for(GeneticCode gc : g){
            if(gc.getClass() == genetic_code.getClass()){
                alreadyKnowsCode = true;
                break;
            }
        }
        if(!alreadyKnowsCode) {
            if (genetic_code.getType().equals("Bear")) {
                genetic_code.CreateAgent(v);
            } else {
                g.add(genetic_code);
                v.setGenetic_codes(g);
            }
        }
    }


    public void Collect(Virologist v){
        Learn_code(v);
    }

    public void SetGenetic_code(GeneticCode g){genetic_code = g;}
    public String getType(){return "Lab";}

}
