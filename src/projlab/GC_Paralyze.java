package projlab;
public class GC_Paralyze extends GeneticCode{
    public GC_Paralyze(){
        super(3,3);
    }
    /**
     * Feladata a Paralyze ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */

    public void AgentType(Virologist v) {
        System.out.println("Add Paralyze: ");
        Paralyze p = new Paralyze();
        v.AddAgent(p);
    }
}
