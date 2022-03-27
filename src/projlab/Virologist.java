package projlab;
import java.util.List;

public class Virologist implements Ticker {
    private int capacity;
    private List<Nukleotid> nukleotid;
    private List<Aminoacid> aminoacid;
    private int immuneTime=0;
    private int paralyzedTime=0;
    private int uncontrollabeTime=0;
    private List<Protection> protections;
    private List<GeneticCode> genetic_codes;
    private List<Agent> agent;
    private Field current_field = new Field();
    Virologist v2;
    Bag b = new Bag();
    Cloak c = new Cloak();
    Glove g = new Glove();
    Immunity i = new Immunity();
    Paralyze p = new Paralyze();
    Uncontrollable u = new Uncontrollable();
    Forgetting fo = new Forgetting();

    public void Tick() {
        System.out.println("Tick()");
            ReduceImmuneTime();
            ReduceParalyzedTime();
            ReduceUncontrollableTime();
        }
        public void Move (Field f){
            System.out.println("Move(f)");
            //List<src.Field> fields = current_field.GetNeighbours();
            //for (src.Field field : fields) {
               // if (f.fieldID == field.fieldID) {
                    current_field.Remove(this);
                    f.Accept(this);
               // }
            //}
        }
        public void Forgetting_codes () {

        }
        public void GetItem () {

            Shelter s = new Shelter();
            System.out.println("v.GetItem()");

            System.out.println("Collect bag: ");
            s.Collect(this);
            b.Effect(this);
            System.out.println("Collect cloak: ");
            s.Collect(this);
            c.Effect(this);
            System.out.println("Collect glove: ");
            s.Collect(this);
            g.Effect(this);

        }
        public void CollectMaterial (Storage storage) {
            System.out.println("v.CollectMaterial(Storage s)");
            storage.Collect(this);
        }
        public void LoseItem (Protection p){
            System.out.println("v2.LoseItem(Protection p)");
        }
        public void ApplyItem (Protection p){
            System.out.println("v.ApplyItem(Protection p)");
        }
        public void StealItem () {
            v2 = new Virologist();
            System.out.println("v2.StealItem()");
            System.out.println("Lose Bag: ");
            v2.LoseItem(b);
            System.out.println("Apply Bag: ");
            this.ApplyItem(b);
            System.out.println("Lose Cloak: ");
            v2.LoseItem(c);
            System.out.println("Apply Cloak: ");
            this.ApplyItem(c);
            System.out.println("Lose Glove: ");
            v2.LoseItem(g);
            System.out.println("Apply Glove: ");
            this.ApplyItem(g);
        }
        public void LookAround () {
            System.out.println("v.LookAround()");

            Field f = new Field();
            Virologist v2 = f.GetVirologistNearby();
            p.Effect(v2);
            u.Effect(v2);
            fo.Effect(v2);

        }
        public void ReduceImmuneTime () {
            System.out.println("ReduceImmuneTime");
            if (immuneTime == 0) i.ReverseEffect(this);
        }
        public void ReduceParalyzedTime () {
            System.out.println("ReduceParalyzedTime");
            if (paralyzedTime == 0) p.ReverseEffect(this);
        }
        public void ReduceUncontrollableTime () {
            System.out.println("ReduceUncontrollableTime");
            if (uncontrollabeTime == 0) u.ReverseEffect(this);
        }
        public void StealNukleotid () {
            System.out.println("v2.StealNukleotid()");
            Nukleotid n = new Nukleotid();
            this.AddNukleotid(n);
        }
        public void StealAminoacid () {
            System.out.println("v2.StealAminoacid()");
            Aminoacid am = new Aminoacid();
            this.AddAminoacid(am);
        }
        public void UseGeneticCode (GeneticCode gc){
            System.out.println("UseGeneticCode(GeneticCode gc)");
            gc.CreateAgent(this);
        }
        public void AddAgent (Agent a){
            System.out.println("AddAgent(a)");
        }
        public void AddAminoacid (Aminoacid am){
            System.out.println("v.AddAminoacid(am)");
        }
        public void AddNukleotid (Nukleotid n){
            System.out.println("v.AddNukleotid(n)");
        }
}



