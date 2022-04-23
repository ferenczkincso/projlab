package projlab;
abstract public class GeneticCode {
    /**
     * Létrehozza a genetikai kódhoz tartozó ágenst,
     * levonva a megfelelő mennyiségű anyagot
     * @param v - A virológus, akire kifejti a hatást
     */
    protected int nukleotidNr;
    protected int aminoacidNr;
    public GeneticCode(int n, int a){
        nukleotidNr = n;
        aminoacidNr = a;
    }
    public final void CreateAgent(Virologist v){
        if (v.GetNukleotid().size()>= nukleotidNr && v.GetAminoacid().size()>=aminoacidNr){
            v.RemoveNukleotid(nukleotidNr);
            v.RemoveAminoacid(aminoacidNr);
            System.out.println("Agens letrehozasa utan nukleotid szam: "
                    + v.GetNukleotid().size() + " es aminoacid szam: " + v.GetAminoacid().size());
            AgentType(v);
        }else {
            System.out.println("Nincs eleg anyag.");
        }
    }
    public abstract void AgentType(Virologist v);
}
