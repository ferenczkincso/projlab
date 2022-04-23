package projlab;
public class GC_Forgetting extends GeneticCode{
    public GC_Forgetting(){
        super(5,5);
    }
    /**
     * Feladata a Forgetting ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */
    public void AgentType(Virologist v) {
        System.out.println("Add Forgetting: ");
        Forgetting fo = new Forgetting();
        v.AddAgent(fo);
    }
}
