package projlab;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Virologist extends Observable implements Ticker {
    private String name;
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
    private boolean hasAx;
    private boolean died;

    private Random randomGenerator = new Random(System.currentTimeMillis());
    private boolean isBear;

    /**
     * Az isBear változó getter függvénye
     * @return isBear - visszaadja, hogy medve-e vagy sem
     */
    public boolean isBear() {
        return isBear;
    }

    /**
     * Az isBear változó setter függvénye
     * @param bear - paramétere a bear
     */
    public void setBear(boolean bear) {
        isBear = bear;
        fieldObserver.update();
        inventoryObserver.update();
    }

    /**
     * A Virologist konstruktor függvénye
     */
    public Virologist(Observer o,Observer io){
        super(o,io);
        nukleotid = new ArrayList<Nukleotid>();
        aminoacid = new ArrayList<Aminoacid>();
        protections = new ArrayList<Protection>();
        genetic_codes = new ArrayList<GeneticCode>();
        agent = new ArrayList<Agent>();
        hasGlove = false;
        dodged = false;
        hasAx = false;
        died = false;
    }
    public Virologist(Observer o,Observer io,String name){
        super(o,io);
        this.name = name;
        nukleotid = new ArrayList<Nukleotid>();
        aminoacid = new ArrayList<Aminoacid>();
        protections = new ArrayList<Protection>();
        genetic_codes = new ArrayList<GeneticCode>();
        agent = new ArrayList<Agent>();
        hasGlove = false;
        dodged = false;
        hasAx = false;
        died = false;
    }

    /**
     * A paralyzedTime setter függvénye, amellyel beállíthatjuk,
     * hogy mennyi időre legyen beállítva a bénulás
     * @param paralyzedTime - paramétre a paralyzedTime
     */
    public void setParalyzedTime(int paralyzedTime) {
        this.paralyzedTime = paralyzedTime;
        fieldObserver.update();
        inventoryObserver.update();
    }

    /**
     * Az uncontrollableTime setter függvénye, amellyel beállíthatjuk,
     * hogy mennyi időre legyen beállítva az irányíthatatlanság
     * @param uncontrollabeTime - paramétere az uncontrollableTime
     */
    public void setUncontrollabeTime(int uncontrollabeTime) {
        this.uncontrollableTime = uncontrollabeTime;
        fieldObserver.update();
        inventoryObserver.update();
    }
    /**
     * Az immunitáshoz tartozó idő setter függvénye
     * @param immuneTime - az ImmuneTime értéke, amennyire be szeretnénk azt állítani
     */
    public void SetImmuneTime(int immuneTime) {
        this.immuneTime = immuneTime;
        fieldObserver.update();
        inventoryObserver.update();;
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
            if (randomGenerator.nextInt()%5==0)
            {
                MoveToRandomNeighbour();
            }
            }
        }


    /**
     * A virológus átmegy egy másik mezőre
      * @param f - a mező, amelyre a virológus lépni szeretne
     */
    public void Move (Field f){
        if(paralyzedTime == 0) {
            try {
                if (current_field.GetNeighbours().contains(f)) {
                    if(f.GetVirologist().size() == 2) return;
                    current_field.Remove(this);
                    f.Accept(this);
                    if (isBear && !current_field.GetVirologistNearBy(this).hasAx) {
                        UseAgent(new Bear(), current_field.GetVirologistNearBy(this));
                    }else if(current_field.GetVirologistNearBy(this).isBear() && !hasAx){
                        UseAgent(new Bear(),this);
                    }else if(isBear && current_field.GetVirologistNearBy(this).hasAx){
                        died = true;
                        for(Protection p : current_field.GetVirologistNearBy(this).GetProtections()){
                            if(p.GetType().equals("Ax")) {
                                LoseItem(p);
                                break;
                            }
                        }
                    }else if(current_field.GetVirologistNearBy(this).isBear() && hasAx) {
                        current_field.GetVirologistNearBy(this).died = true;
                        for (Protection p : protections) {
                            if (p.GetType().equals("Ax")) {
                                LoseItem(p);
                                break;
                            }
                        }
                    }
                    inventoryObserver.update();
                    fieldObserver.update();
                }
            }
            catch(NullPointerException e){}
        }
        else
            return;
    }

    public void setHasAx(boolean b){hasAx = b;}
    public boolean isDied(){return died;}


    /**
     * A virológus véletlenszerű mozgását kiváltó függvény
     * Lekérdezi a virológus jelenlegi szomszédjait, majd azok közül
     * random 1-et választva átlép egy másik mezőre.
     * Ezt a függvényt a medvevírussal való megfertőződéskor, illetve
     * az irányíthatatlansági ágens befolyása alatt hívjuk meg
     */
    public void MoveToRandomNeighbour()
    {
        if(died) return;
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
        inventoryObserver.update();
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
            fieldObserver.update();
            inventoryObserver.update();
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
            fieldObserver.update();
            inventoryObserver.update();;
        }
    }

    /**
     * Ha egy másik virológus lebénult állapotban van, el lehet
     * tőle lopni mindenét, ez a függvény akkor hívódik meg.
     */
    public void StealItem(Virologist v) {
        if(v.GetParalyzedTime() > 0 && LookAround().contains(v)){
            boolean hasProtection;
            for(Protection p : v.GetProtections()){
                hasProtection = false;
                for(Protection g : protections){
                    if(p.GetType().equals(g.GetType())) hasProtection = true;
                    break;
                }
                if(!hasProtection){
                    ApplyItem(p);
                    v.LoseItem(p);
                    break;
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
        fieldObserver.update();
        inventoryObserver.update();
    }
    /**
     * Ha a virológust egy másik virológus lebénította, akkor
     * hívódik meg ez a függvény, feladata, hogy visszaszámoljon
     * a lebénult időből.
     */
    public void ReduceParalyzedTime () {
        if (paralyzedTime > 0) paralyzedTime--;
        fieldObserver.update();
        inventoryObserver.update();
    }
    /**
     * Ha a virológust egy másik virológus kontrollálhatatlanná
     * tette, akkor hívódik meg ez a függvény, feladata,
     * hogy visszaszámoljon a kontrollálhatatlan időből.
     */
    public void ReduceUncontrollableTime () {
        if (uncontrollableTime > 0) uncontrollableTime--;
        fieldObserver.update();
        inventoryObserver.update();
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
            inventoryObserver.update();;
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
            inventoryObserver.update();
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
        inventoryObserver.update();
    }

    /**
     * Aminosav hozzáadása a virológushoz
     * @param am - az aminoacid, amit szerenténk hozzáadni a virológushoz
     */
    public void AddAminoacid (Aminoacid am){
       if(aminoacid.size() < capacity) aminoacid.add(am);
        fieldObserver.update();
        inventoryObserver.update();
    }

    /**
     * Nukleotid hozzáadása a virológushoz
     * @param n - a nukleotid, amelyet szeretnénk hozzáadni a virológushoz
     */
    public void AddNukleotid (Nukleotid n){
        if(nukleotid.size() < capacity) nukleotid.add(n);
        fieldObserver.update();
        inventoryObserver.update();
    }

    /**
     * A capacity gettter függvénye
     * @return capacity
     */
    public int GetCapacity() { return capacity; }

    /**
     * A capacity setter függvénye
     * @param n - a kapacitás mértéke
     */
    public void SetCapacity(int n) {
        capacity = n;
        inventoryObserver.update();
    }

    /**
     * A balta használatához szükséges függvény, amely bekér egy másik
     * virológust paraméterként, és először ellenőrzi, hogy ő fertőzött-e,
     * ha igen, akkor végigmegy a védőfelszerelésein a virológusnak, és
     * ha talál baltát, akkor azt felhasználja a másik virológuson, majd
     * eldobja a védőfelszerelések raktárjából
     * @param otherVirologist - a másik virológus, akit meg akarunk támadni
     */
    public void UseAx(Virologist otherVirologist){
        if (!otherVirologist.isBear()) return;
        for (Protection p: protections)
            if (p.getClass().equals(Ax.class))
            {
                p.Effect(otherVirologist);
                this.GetProtections().remove(p);
            }
    }

    /**
     * Az ágens felhasználásához tartozó függvény
     * Ellenőrzi, hogy medve-e az illető, ha igen, akkor megfertőzi
     * a virológust, akivel találkozik
     * Ha a megfertőződő virológusnak nagyobb, mint 0 az immunitás ideje,
     * akkor visszatér a függvény, hiszen nem lehet őt megfertőzni
     * Ha a fertőzni kívánt virológus medve, akkor is visszatér, hiszen
     * őt se lehet megfertőzni
     * Ha a másik virológus rendelkezik kesztyű védőfelszereléssel, akkor
     * a hatás a virológusra kerül
     * Ha a másik virológus rendelkezik köpennyel, akkor megfertőzi
     *
     * @param a
     * @param otherVirologist
     */
    public void UseAgent(Agent a, Virologist otherVirologist) {
        if (otherVirologist.GetImmuneTime() > 0) return;

        if (a.getClass().equals(Bear.class)) { a.Effect(otherVirologist); return; }

        if (paralyzedTime > 0 || uncontrollableTime > 0 || isBear) return;

        for (Protection p: otherVirologist.GetProtections())
        {
            if (p.getClass().equals(Cloak.class)){
                p.Effect(otherVirologist);
                break;
            }
        }
        if (otherVirologist.HasDodged())
        {
            otherVirologist.SetDodged(false);
            return;
        }
        if (otherVirologist.HasGlove()) {
            for(Protection p : otherVirologist.GetProtections()){
                if(p.GetType().equals("Glove")){
                    p.Effect(otherVirologist);
                    break;
                }
            }
            UseAgent(a, this);
            return;
        }

        a.Effect(otherVirologist);
        if(!a.getType().equals("Bear")) this.agent.remove(a);

    }


    /**
     * A current_field setter függvénye
     * @param f - a mező, amelyre be szeretnénk állítani
     */
    public void setCurrent_field(Field f){
        current_field = f;
    }

    /**
     * A current_field getter függvénye
     * @return - a mező, amelyen rajta van a virológus
     */
    public Field getCurrent_field() {
        return current_field;
    }

    /**
     * A paralyzedTime getter függvénye
     * @return - paralyzedTime értéke
     */
    public int GetParalyzedTime() {return paralyzedTime;}

    /**
     * Az uncontrollableTime getter függvénye
     * @return - uncontrollableTime értéke
     */
    public int GetUncontrollableTime(){return uncontrollableTime;}

    /**
     * A nukleotid getter függvénye
     * @return - nukleotid listával tér vissza
     */
    public ArrayList<Nukleotid> GetNukleotid()
    {
        return nukleotid;
    }

    /**
     * A nukleotid törléséért felelős függvény
     * @param nr - azt a mennyiséget jelenti, amennyit törölni szeretnénk
     */
    public void RemoveNukleotid(int nr){
        if (nukleotid.size() >= nr)
            for (int i=0; i<nr; i++){
                nukleotid.remove(0);
            }
        else return;
        inventoryObserver.update();
    }

    /**
     * Az aminosav getter függvénye
     * @return - aminoacid listával tér vissza
     */
    public ArrayList<Aminoacid> GetAminoacid()
    {
        return aminoacid;
    }

    /**
     * Az aminosav törléséért felelős függvény
     * @param nr - azt a mennyiséget jelenti, amennyit törölni szeretnénk
     */
    public void RemoveAminoacid(int nr){
        if (aminoacid.size() >= nr)
            for (int i=0; i<nr; i++){
                aminoacid.remove(0);
            }
        inventoryObserver.update();
    }

    /**
     * A védőfelszerelések getter függvénye
     * @return - a védőfelszerelések listáját
     */
    public ArrayList<Protection> GetProtections()
    {
        return protections;
    }
    public void SetProtections(ArrayList<Protection> p){
        protections =p;
        inventoryObserver.update();
    }


    /**
     * Az immuneTime getter függvénye
     * @return - az ImmuneTime értéke
     */
    public int GetImmuneTime() { return immuneTime; }

    /**
     * A hasGlove getter függvénye
     * @return hasGlove értékét, amely vagy igaz, vagy hamis
     */
    public boolean HasGlove() { return hasGlove; }

    /**
     * A hasGlove setter függvénye
     * @param value - igaz vagy hamis, amelyre a hasGlove-ot szeretnénk
     * beállítani
     */
    public void SetGlove(boolean value) { hasGlove = value; }

    /**
     * A genetikus kódokhoz tartozó getter függvény
     * @return - visszaadja a genetikus kódok listáját, amellyel a virológus
     * rendelkezik
     */
    public ArrayList<GeneticCode> GetGenetic_codes(){
        return genetic_codes;
    }

    /**
     * A genetikus kódokhoz tartozó setter függvény
     * @param g - a lista, amelyet szeretnénk beállítani a genetikus
     * kódok tárolására
     */
    public void setGenetic_codes(ArrayList<GeneticCode> g){
        genetic_codes = g;
        inventoryObserver.update();
    }

    /**
     * A dodged változó getter függvénye
     * @return - a dodge igaz vagy hamis értékével tér vissza
     */
    public boolean HasDodged() {return dodged;}

    /**
     * A dodged változó setter függvénye
     * @param value - az igaz / hamis érték, amelyre be szeretnénk állítani a dodged-et
     */
    public void  SetDodged(boolean value) {dodged = value;}

    /**
     * Az ágensek listájának getter függvénye
     * @return - az ágensek listájával tér vissza
     */
    public ArrayList<Agent> GetAgent() {
        return agent;
    }
    public String getName(){return name;}
    public Observer getFieldObserver(){return fieldObserver;}
}



