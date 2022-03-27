package projlab;
public class GC_Paralyze extends GeneticCode{
    public void CreateAgent(Virologist v){
        System.out.println("Create Paralyze: CreateAgent(Virologist v)");
        Paralyze p = new Paralyze();
        System.out.println("Add Paralyze: ");
        v.AddAgent(p);
    }
}
