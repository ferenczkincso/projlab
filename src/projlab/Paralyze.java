package projlab;
public class Paralyze extends Agent{
    /**
     *Az Effect feladata, hogy az adott virológusra
     * kifejtse az Immunity hatást, azaz, a virológus
     * immunis legyen minden ágensre.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v){
        System.out.println("Paralyze: Effect(v2)");
    }

    /**
     * Felelős azért, hogy az ágens hatása lekerüljön
     * az adott virológusról, azaz többé ne legyen a virológus
     * lebénult állapotban, és újra tudjon mozogni a mezőkön
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v){
        System.out.println("ReverseParalyze: ReverseEffect(v)");
    }
}
