package projlab;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Virologist implements Ticker {
    private int capacity = 15;
    private ArrayList<Nukleotid> nukleotid;
    private ArrayList<Aminoacid> aminoacid;
    private int immuneTime = 0;
    private int paralyzedTime = 0;
    private int uncontrollableTime = 0;
    private ArrayList<Protection> protections;
    private ArrayList<GeneticCode> genetic_codes;
    private ArrayList<Agent> agent;
    private Field current_field;
    //private int gloveusage;
    private boolean hasGlove;
    private boolean dodged;
    private Random randomGenerator = new Random(System.currentTimeMillis());

    public boolean isBear() {
        return isBear;
    }

    public void setBear(boolean bear) {
        isBear = bear;
    }

    private boolean isBear;

    public Virologist(){
        nukleotid = new ArrayList<Nukleotid>();
        aminoacid = new ArrayList<Aminoacid>();
        protections = new ArrayList<Protection>();
        genetic_codes = new ArrayList<GeneticCode>();
        agent = new ArrayList<Agent>();
        hasGlove = false;
        dodged = false;
    }

    public void setParalyzedTime(int paralyzedTime) {
        this.paralyzedTime = paralyzedTime;
    }

    public int getParalyzedTime() {
        return paralyzedTime;
    }

    public void setUncontrollabeTime(int uncontrollabeTime) {
        this.uncontrollableTime = uncontrollabeTime;
    }

    public int getUncontrollabeTime() {
        return uncontrollableTime;
    }

    /**
     * Az idő számlálásáért felelős
     */

    public void Tick() {
        ReduceParalyzedTime();
        ReduceUncontrollableTime();
        if (!isBear) ReduceImmuneTime();

        if (isBear || (uncontrollableTime > 0 && paralyzedTime == 0))
        {
            if (randomGenerator.nextInt()%15==0) MoveToRandomNeighbour();
        }
    }

    /**
     * A virológus átmegy egy másik mezőre
      * @param f - a mező, amelyre a virológus lépni szeretne
     */
    public void Move (Field f){
        if(paralyzedTime == 0) {
            if (current_field.GetNeighbours().contains(f)) {
                current_field.Remove(this);
                f.Accept(this);
            }
        }
        else
            return;
    }

    public void MoveToRandomNeighbour()
    {
        List<Field> neighbours = current_field.GetNeighbours();

        Field nextField = neighbours.get(randomGenerator.nextInt(neighbours.size()));
        Move(nextField);
    }

    /**
     * A virológus elfelejti az eddig megtanult genetikai
     * kódokat. Akkor hívódik meg, ha egy másik virológus
     * a Forgetting ágenst használta rajta.
     */
    public void Forgetting_codes () {
        genetic_codes.clear();
    }

    /**
     * A virológus felvesz egy védőfelszerelést
     */
    public void GetItem () {
        current_field.Collect(this);
    }

    /**
     * A virológus felveszi az adott mezőn lévő anyagot.
     */
    public void CollectMaterial () {
        current_field.Collect(this);
    }

    /**
     * Ha a virológus bénult állapotban van, a többi virológus
     * el tudja venni minden dolgát (anyagát, védőfelszerelését)
     * Ez a függvény akkor hívódik meg, és ezáltal mindent
     * elveszít, ami eddig a birtokában volt.
     * @param p - a védőfelszerelés, amelyet elveszít
     */
    public void LoseItem (Protection p)
    {
        if(protections.contains(p))
        {
            p.ReverseEffect(this);
            protections.remove(p);
        }
    }

    /**
     * Akkor hívódik meg, ha a virológus használatba vesz
     * egy védőfelszerelést
     * @param p - a védeőfelszerelés, amelyet felrak magára
     */
    public void ApplyItem (Protection p){
        if (protections.size() < 3)
        {
            for (Protection c : protections) {
                if (p.GetType().equals(c.GetType())) {
                    return;
                }
            }
            protections.add(p);
        }
    }

    /**
     * Ha egy másik virológus lebénult állapotban van, el lehet
     * tőle lopni mindenét, ez a függvény akkor hívódik meg.
     */
    public void StealItem(Virologist v) {
        if(v.GetParalyzedTime() > 0 && LookAround().contains(v)){
            boolean vanmar;
            for(Protection p : v.GetProtections()){
                vanmar = false;
                for(Protection g : protections){
                    if(p.GetType().equals(g.GetType())) vanmar = true;
                }
                if(!vanmar){
                    ApplyItem(p);
                    v.LoseItem(p);
                }
            }
        }
    }

    /**
     * A virológus megnézi, hogy az adott és a szomszédos mezőnkön van-e másik
     * virológus
     */
    public ArrayList<Virologist> LookAround () {
        return current_field.GetVirologist();
    }

    /**
     * Ha a virológus rendelkezik az Immunity védőfelszereléssel,
     * akkor hívódik meg, ennek a hatása egy bizonyos idő után
     * elmúlik. Ez a függvény felelős az idő visszaszámlálásért
     */
    public void ReduceImmuneTime () {
        if (immuneTime > 0) immuneTime--;
    }
    /**
     * Ha a virológust egy másik virológus lebénította, akkor
     * hívódik meg ez a függvény, feladata, hogy visszaszámoljon
     * a lebénult időből.
     */
    public void ReduceParalyzedTime () {
        if (paralyzedTime > 0) paralyzedTime--;
    }
    /**
     * Ha a virológust egy másik virológus kontrollálhatatlanná
     * tette, akkor hívódik meg ez a függvény, feladata,
     * hogy visszaszámoljon a kontrollálhatatlan időből.
     */
    public void ReduceUncontrollableTime () {
        if (uncontrollableTime > 0) uncontrollableTime--;
    }

    /**
     * A bénult virológustól ellopja az összes nukleotidját,
     * és a másik virológushoz kerül annyi, amennyi még
     * elfér nála.
     */
    public void StealNukleotid (Virologist v) {
        if(v.GetParalyzedTime() > 0 && LookAround().contains(v)){
            while (nukleotid.size() < capacity && v.GetNukleotid().size() > 0){
                AddNukleotid(v.GetNukleotid().get(0));
                v.GetNukleotid().remove(0);
            }
        }
    }

    /**
     * A bénult virológustól ellopja az összes aminosavát,
     * és a másik virológushoz kerül annyi, amennyi még
     * elfér nála.
     */
    public void StealAminoacid (Virologist v) {
        if(v.GetParalyzedTime() > 0 && LookAround().contains(v)){
            while(aminoacid.size() < capacity && v.GetAminoacid().size() > 0){
                AddAminoacid(v.GetAminoacid().get(0));
                v.GetAminoacid().remove(0);
            }
        }
    }

    /**
     * Ha a genetikus kódot fel szeretnénk használni, akkor
     * hívódik meg.
     * @param gc - a genetikus kód, amelyiket fel akarja használni
     */
    public void UseGeneticCode (GeneticCode gc){
        gc.CreateAgent(this);
    }

    /**
     * A létrehozott ágenst hozzáadja a virológushoz
     * @param a - az ágens, amelyet hozzá szeretnénk adni a virológushoz
     */
    public void AddAgent (Agent a){
        agent.add(a);
    }

    /**
     * Aminosav hozzáadása a virológushoz
     * @param am - az aminoacid, amit szerenténk hozzáadni a virológushoz
     */
    public void AddAminoacid (Aminoacid am){
       if(aminoacid.size() < capacity) aminoacid.add(am);
    }

    /**
     * Nukleotid hozzáadása a virológushoz
     * @param n - a nukleotid, amelyet szeretnénk hozzáadni a virológushoz
     */
    public void AddNukleotid (Nukleotid n){
        if(nukleotid.size() < capacity) nukleotid.add(n);
    }

    public int GetCapacity() { return capacity; }
    public void SetCapacity(int n) { capacity = n; }

    public void UseAx(){

    }


    public void setCurrent_field(Field f){
        current_field = f;
    }

    public Field getCurrent_field() {
        return current_field;
    }

    public int GetParalyzedTime() {return paralyzedTime;}
    public int GetUncontrollableTime(){return uncontrollableTime;}
    public ArrayList<Nukleotid> GetNukleotid(){return nukleotid;}
    public void RemoveNukleotid(int nr){
        for (int i = nukleotid.size()-1; i>=nukleotid.size()-nr; i--){
            nukleotid.remove(i);
        }
    }
    public ArrayList<Aminoacid> GetAminoacid(){return aminoacid;}
    public void RemoveAminoacid(int nr){
        for (int i = aminoacid.size()-1; i>=aminoacid.size()-nr; i--){
            aminoacid.remove(i);
        }
    }
    public ArrayList<Protection> GetProtections(){return protections;}
    public void SetProtections(ArrayList<Protection> p){}

    public void SetImmuneTime(int n) { immuneTime = n; }
    public int GetImmuneTime() { return immuneTime; }

    public boolean HasGlove() { return hasGlove; }
    public void SetGlove(boolean value) { hasGlove = value; }

    public ArrayList<GeneticCode> GetGenetic_codes(){
        return genetic_codes;
    }

    public void setGenetic_codes(ArrayList<GeneticCode> g){
        genetic_codes = g;
    }

    public boolean HasDodged() {return dodged;}
    public void  SetDodged(boolean value) {dodged = value;}
    public ArrayList<Agent> GetAgent() {
        return agent;
    }



}



