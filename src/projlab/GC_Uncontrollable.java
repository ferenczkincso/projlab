package projlab;
public class GC_Uncontrollable extends GeneticCode{

    /**
     * Feladata a Uncontrollable ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     //* @param v - A virológus, akire kifejti a hatást
     */
    public void CreateAgent(Virologist v){
        if (v.GetNukleotid().size()>= 2 && v.GetAminoacid().size()>=2){
            v.RemoveNukleotid(2);
            v.RemoveAminoacid(2);
            System.out.println("Agens letrehozasa utan nukleotid szam: "
                    + v.GetNukleotid().size() + " es aminoacid szam: " + v.GetAminoacid().size());
            Uncontrollable u = new Uncontrollable();
            v.AddAgent(u);
        }else {
            System.out.println("Nincs eleg anyag.");
        }
    }

    @Override
    public String getType() {
        return "Uncontrollable";
    }
}
