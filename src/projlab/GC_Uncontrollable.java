package projlab;
public class GC_Uncontrollable extends GeneticCode{
    public void CreateAgent(Virologist v){
        System.out.println("Create Uncontrollable: CreateAgent(Virologist v)");
        Uncontrollable u = new Uncontrollable();
        System.out.println("Add Uncotrollable: ");
        v.AddAgent(u);
    }
}
