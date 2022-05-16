package projlab;
public class Forgetting extends Agent{



    /**
     * Az Effect feladata, hogy az adott virológusra
     * kifejtse a Forgetting hatását, azaz elfelejtse az
     * összes eddig megtanult genetikai kódot.
     * @param v - A virológus, akire kifejti a hatást
     */

    public void Effect(Virologist v){
        v.Forgetting_codes();
    }

    @Override
    public String getType() {
        return "Forgetting";
    }
}
