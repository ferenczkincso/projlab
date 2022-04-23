package projlab;

import java.util.ArrayList;
import java.util.Random;

public class Lab extends Field{
    private GeneticCode genetic_code;

    public Lab(){
        Random rand = new Random();
        int id = rand.nextInt(4);
        int temp = rand.nextInt(100)+1;
        if (temp%5==0) id = 4;
        switch (id){
            case 0: genetic_code = new GC_Uncontrollable();
            case 1: genetic_code = new GC_Paralyze();
            case 2: genetic_code = new GC_Immunity();
            case 3: genetic_code = new GC_Forgetting();
            case 4: genetic_code = new GC_Bear();
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
            if(gc == genetic_code){
                alreadyKnowsCode = true;
            }
        }
        if(!alreadyKnowsCode){
            g.add(genetic_code);
            v.setGenetic_codes(g);
        }
    }

}
