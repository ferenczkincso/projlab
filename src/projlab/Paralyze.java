package projlab;
public class Paralyze extends Agent{


    /**
     *Az Effect feladata, hogy az adott virológusra
     * kifejtse a Paralyze hatást, azaz, a virológus
     * ne tudjon átlépni egy másik mezőre.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v){
        //System.out.println("Paralyze: Effect(v2)");
        v.setParalyzedTime(10);
        v.ReduceParalyzedTime();
    }

    /**
     * Felelős azért, hogy az ágens hatása lekerüljön
     * az adott virológusról, azaz többé ne legyen a virológus
     * lebénult állapotban, és újra tudjon mozogni a mezőkön
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v){
        
    }

    @Override
    public String getType() {
        return "Paralyze";
    }
}
