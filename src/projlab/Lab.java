package projlab;

import java.util.ArrayList;
import java.util.Random;

public class Lab extends Field{
    private GeneticCode genetic_code;

    public Lab(){
        Random rand = new Random();
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
