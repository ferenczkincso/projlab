package projlab;
public class Uncontrollable extends Agent{
    /**
     *Az Effect feladata, hogy az adott virológusra
     * kifejtse az Uncontrollable hatást, azaz, a virológus
     * irányíthatatlanná váljon a pályán
     * @param v - A virológus, akire kifejti a hatást
     */
    public void Effect(Virologist v){
        System.out.println("Uncontrollable: Effect(v2)");
    }

    /**
     * Felelős azért, hogy az ágens hatása lekerüljön
     * az adott virológusról, azaz a virológus újból
     * irányíthatóvá váljon.
     * @param v - A virológus, akire kifejti a hatást
     */
    public void ReverseEffect(Virologist v){
        System.out.println("ReverseUncontrollable: ReverseEffect(v)");
    }
}