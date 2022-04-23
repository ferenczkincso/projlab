package projlab;
public class Glove extends Protection{
    /**
     *Az Effect feladata, hogy az adott virológusra
     * kifejtse a Glove hatást, azaz, ha a virológust
     * egy másik megtámadja, akkor visszadobja az ágenst
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v) {
        System.out.println("Glove: Effect(v)");
    }

    /**
     * A ReverseEffect felelős azért, hogy a kesztyű
     * hatása lekerüljön az adott virológusról
     * @param v - A virológus, akire kifejti a hatást
     */

    public void ReverseEffect(Virologist v) {
        System.out.println("ReverseEffect(v)");
    }
}