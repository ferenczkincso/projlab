package projlab;
public class GC_Paralyze extends GeneticCode{
    /**
     * Feladata a Paralyze ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */

    public void CreateAgent(Virologist v){
        System.out.println("Create Paralyze: CreateAgent(Virologist v)");
        Paralyze p = new Paralyze();
        System.out.println("Add Paralyze: ");
        v.AddAgent(p);
    }
}
