package projlab;
public class GC_Forgetting extends GeneticCode{
    /**
     * Feladata a Forgetting ágens létrehozása, illetve
     * a megfelelő mennyiségű anyag levonása az adott
     * virológustól
     * @param v - A virológus, akire kifejti a hatást
     */
    public void CreateAgent(Virologist v){
        System.out.println("Create Forgetting: CreateAgent(Virologist v)");
        Forgetting fo = new Forgetting();
        System.out.println("Add Forgetting: ");
        v.AddAgent(fo);
    }
}
