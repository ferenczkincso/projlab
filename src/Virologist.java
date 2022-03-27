import java.util.List;

public class Virologist implements Ticker {
    private int capacity;
    private List<Nukleotid> nukleotid;
    private List<Aminoacid> aminoacid;
    private int immuneTime;
    private int paralyzedTime;
    private int uncontrollabeTime;
    private List<Protection> protections;
    private List<GeneticCode> genetic_codes;
    private List<Agent> agent;
    private Field current_field;

    public void Tick(){
        System.out.println("Tick()");
        while (immuneTime != 0)
            ReduceImmuneTime();
        while (paralyzedTime != 0)
            ReduceParalyzedTime();
        while (uncontrollabeTime != 0)
            ReduceUncontrollableTime();
    }
    public void Move(Field f){
        System.out.println("Move()");
        List<Field> fields = current_field.GetNeighbours();
        for (Field field : fields){
            if (f.fieldID==field.fieldID){
                current_field.Remove(this);
                f.Accept(this);
            }
        }
    }
    public void Forgetting_codes(){

    }
    public void GetItem() {

        Shelter s = new Shelter();
        Protection p = new Bag();

        System.out.println("v.GetItem()");

        System.out.print("\t");
        s.Collect(this);

        System.out.print("\t");
        p.Effect(this);
    }
    public void CollectMaterial(){
        Nukleotid_storage n = new Nukleotid_storage();

        System.out.println("v.CollectMaterial()");

        System.out.print("\t");
        n.Collect(this);

    }
    public void LoseItem(Protection p){
        System.out.println("v2.LoseItem()");
    }
    public void ApplyItem(Protection p){

    }
    public void StealItem(){
        System.out.println("v2.StealItem()");

    }
    public void LookAround(){

        Field f = new Field();
        Agent a = new Immunity();

        System.out.println("v1.LookAround()");

        System.out.print("\t");
        Virologist v2 = f.GetVirologistNearby();

        System.out.print("\t");
        a.Effect(v2);
        if (v2.paralyzedTime!=0){
            while (!v2.nukleotid.isEmpty() || !v2.aminoacid.isEmpty()) {
                Nukleotid n = new Nukleotid();
                Aminoacid am = new Aminoacid();
                v2.StealNukleotid();
                this.AddNukleotid(n);
                v2.StealAminoacid();
                this.AddAminoacid(am);
            }
        }
    }
    public void ReduceImmuneTime(){
        System.out.println("ReduceImmuneTime");
    }
    public void ReduceParalyzedTime(){
        System.out.println("ReduceParalyzedTime");
    }
    public void ReduceUncontrollableTime(){
        System.out.println("ReduceUncontrollableTime");
    }
    public void StealNukleotid(){
        System.out.println("v2.StealNukleotid()");

    }
    public void StealAminoacid(){
        System.out.println("v2.StealAminoacid()");
    }
    public void UseGeneticCode(GeneticCode gc){

    }
    public void AddAgent(Agent a){
        System.out.println("AddAgent(a)");
    }
    public void AddAminoacid(Aminoacid am){
        System.out.println("this.AddAminoacid(am)");
    }
    public void AddNukleotid(Nukleotid n){
        System.out.println("this.AddNukleotid(n)");
    }
}

