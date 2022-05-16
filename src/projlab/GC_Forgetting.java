package projlab;
public class GC_Forgetting extends GeneticCode{

    /**
     * Feladata a Forgetting ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */
    public void CreateAgent(Virologist v) {
        if (v.GetNukleotid().size() >= 5 && v.GetAminoacid().size() >= 5) {
            v.RemoveNukleotid(5);
            v.RemoveAminoacid(5);
            System.out.println("Agens letrehozasa utan nukleotid szam: "
                    + v.GetNukleotid().size() + " es aminoacid szam: " + v.GetAminoacid().size());
            Forgetting fo = new Forgetting();
            v.AddAgent(fo);
        } else {
            System.out.println("Nincs eleg anyag.");
        }
    }

    @Override
    public String getType() {
        return "Forgetting";
    }
}
