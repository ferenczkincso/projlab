package projlab;

public class Ax extends Protection {

    /**
     * Az Effect a balta hatását fejti ki, azaz eltávolítja
     * a medvevírussal megfertőződött virológust a mezőjéről,
     * amelyen jelenleg áll, és ezáltal számára véget ér a játék
     * @param v - A virológus, akire kifejti a hatást
     */
    @Override
    public void Effect(Virologist v) {
        v.setHasAx(true);
    }

    /**
     * A ReverseEffect beállítja a virológus hasAx értékét false-ra
     * @param v - A virológus, akire kifejti a hatást
     */

    @Override
    public void ReverseEffect(Virologist v) {
        v.setHasAx(false);
    }

    @Override
    public String GetType() {
        return "Ax";
    }
}
