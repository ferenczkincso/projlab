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

    /**
     * Az idő számlálásáért felelős
     */

    public void Tick() {
        System.out.println("Tick()");
            ReduceImmuneTime();
            ReduceParalyzedTime();
            ReduceUncontrollableTime();
    }

    /**
     * A virológus átmegy egy másik mezőre
      * @param f - a mező, amelyre a virológus lépni szeretne
     */
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

    /**
     * A virológus elfelejti az eddig megtanult genetikai
     * kódokat. Akkor hívódik meg, ha egy másik virológus
     * a Forgetting ágenst használta rajta.
     */
    public void Forgetting_codes () {

    }

    /**
     * A virológus felvesz egy védőfelszerelést
     */
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

    /**
     * A virológus felveszi az adott mezőn lévő anyagot.
     * @param storage - a raktár, ahonnan felszedi az anyagot
     */
    public void CollectMaterial (Storage storage) {
        System.out.println("v.CollectMaterial(Storage s)");
        storage.Collect(this);
    }

    /**
     * Ha a virológus bénult állapotban van, a többi virológus
     * el tudja venni minden dolgát (anyagát, védőfelszerelését)
     * Ez a függvény akkor hívódik meg, és ezáltal mindent
     * elveszít, ami eddig a birtokában volt.
     * @param p - a védőfelszerelés, amelyet elveszít
     */
    public void LoseItem (Protection p){
        System.out.println("v2.LoseItem(Protection p)");
    }

    /**
     * Akkor hívódik meg, ha a virológus használatba vesz
     * egy védőfelszerelést
     * @param p - a védeőfelszerelés, amelyet felrak magára
     */
    public void ApplyItem (Protection p){
        System.out.println("v.ApplyItem(Protection p)");
    }

    /**
     * Ha egy másik virológus lebénult állapotban van, el lehet
     * tőle lopni mindenét, ez a függvény akkor hívódik meg.
     */
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

    /**
     * A virológus megnézi, hogy az adott mezőn van-e másik
     * virológus
     */
    public void LookAround () {
        System.out.println("v.LookAround()");

        Field f = new Field();
        Virologist v2 = f.GetVirologistNearby();
        p.Effect(v2);
        u.Effect(v2);
        fo.Effect(v2);

    }

    /**
     * Ha a virológus rendelkezik az Immunity védőfelszereléssel,
     * akkor hívódik meg, ennek a hatása egy bizonyos idő után
     * elmúlik. Ez a függvény felelős az idő visszaszámlálásért
     */
    public void ReduceImmuneTime () {
        System.out.println("ReduceImmuneTime");
        if (immuneTime == 0) i.ReverseEffect(this);
    }
    /**
     * Ha a virológust egy másik virológus lebénította, akkor
     * hívódik meg ez a függvény, feladata, hogy visszaszámoljon
     * a lebénult időből.
     */
    public void ReduceParalyzedTime () {
        System.out.println("ReduceParalyzedTime");
        if (paralyzedTime == 0) p.ReverseEffect(this);
    }
    /**
     * Ha a virológust egy másik virológus kontrollálhatatlanná
     * tette, akkor hívódik meg ez a függvény, feladata,
     * hogy visszaszámoljon a kontrollálhatatlan időből.
     */
    public void ReduceUncontrollableTime () {
        System.out.println("ReduceUncontrollableTime");
        if (uncontrollabeTime == 0) u.ReverseEffect(this);
    }

    /**
     * A bénult virológustól ellopja az összes nukleotidját,
     * és a másik virológushoz kerül annyi, amennyi még
     * elfér nála.
     */
    public void StealNukleotid () {
        System.out.println("v2.StealNukleotid()");
        Nukleotid n = new Nukleotid();
        this.AddNukleotid(n);
    }

    /**
     * A bénult virológustól ellopja az összes aminosavát,
     * és a másik virológushoz kerül annyi, amennyi még
     * elfér nála.
     */
    public void StealAminoacid () {
        System.out.println("v2.StealAminoacid()");
        Aminoacid am = new Aminoacid();
        this.AddAminoacid(am);
    }

    /**
     * Ha a genetikus kódot fel szeretnénk használni, akkor
     * hívódik meg.
     * @param gc - a genetikus kód, amelyiket fel akarja használni
     */
    public void UseGeneticCode (GeneticCode gc){
        System.out.println("UseGeneticCode(GeneticCode gc)");
        gc.CreateAgent(this);
    }

    /**
     * A létrehozott ágenst hozzáadja a virológushoz
     * @param a - az ágens, amelyet hozzá szeretnénk adni a virológushoz
     */
    public void AddAgent (Agent a){
        System.out.println("AddAgent(a)");
    }

    /**
     * Aminosav hozzáadása a virológushoz
     * @param am - az aminoacid, amit szerenténk hozzáadni a virológushoz
     */
    public void AddAminoacid (Aminoacid am){
        System.out.println("v.AddAminoacid(am)");
    }

    /**
     * Nukleotid hozzáadása a virológushoz
     * @param n - a nukleotid, amelyet szeretnénk hozzáadni a virológushoz
     */
    public void AddNukleotid (Nukleotid n){
        System.out.println("v.AddNukleotid(n)");
    }
}



