package projlab;
public class GC_Immunity extends GeneticCode {

    /**
     * Feladata a Immunity ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     *
     * @param v - A virológus, akire kifejti a hatást
     */
    public void CreateAgent(Virologist v) {
        if (v.GetNukleotid().size() >= 4 && v.GetAminoacid().size() >= 4) {
            v.RemoveNukleotid(4);
            v.RemoveAminoacid(4);
            System.out.println("Agens letrehozasa utan nukleotid szam: "
                    + v.GetNukleotid().size() + " es aminoacid szam: " + v.GetAminoacid().size());
            Immunity i = new Immunity();
            v.AddAgent(i);
        } else {
            System.out.println("Nincs eleg anyag.");
        }
    }

    @Override
    public String getType() {
        return "Immunity";
    }
}
