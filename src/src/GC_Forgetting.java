package src;
public class GC_Forgetting extends GeneticCode{
    public void CreateAgent(Virologist v){
        System.out.println("Create Forgetting: CreateAgent(Virologist v)");
        Forgetting fo = new Forgetting();
        System.out.println("Add Forgetting: ");
        v.AddAgent(fo);
    }
}
