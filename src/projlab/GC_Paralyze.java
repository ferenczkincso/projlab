package projlab;
public class GC_Paralyze extends GeneticCode {

    /**
     * Feladata a Paralyze ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     *
     * @param v - A virológus, akire kifejti a hatást
     */

    public void CreateAgent(Virologist v) {
        if (v.GetNukleotid().size() >= 3 && v.GetAminoacid().size() >= 3) {
            v.RemoveNukleotid(3);
            v.RemoveAminoacid(3);
            System.out.println("Agens letrehozasa utan nukleotid szam: "
                    + v.GetNukleotid().size() + " es aminoacid szam: " + v.GetAminoacid().size());
            Paralyze p = new Paralyze();
            v.AddAgent(p);
        } else {
            System.out.println("Nincs eleg anyag.");
        }
    }

    @Override
    public String getType() {
        return "Paralyze";
    }
}
