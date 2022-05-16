package projlab;
public class Immunity extends Agent{


    /**
     *Az Effect feladata, hogy az adott virológusra
     * kifejtse az Immunity hatást, azaz, a virológus
     * immunis legyen minden ágensre.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Effect(Virologist v){
        //System.out.println("Immunity: Effect(v)");
        v.SetImmuneTime(30);

    }

    /**
     * Felelős azért, hogy az ágens hatása lekerüljön
     * az adott virológusról, azaz többé ne legyen immunis
     * az ágensekre
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v){
        //System.out.println("ReverseImmunity: ReverseEffect(v)");

    }


    public String getType() {
        return "Immunity";
    }
}
