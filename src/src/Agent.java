package src;
abstract class Agent {
    public void Effect(Virologist v)
    {
        System.out.println("a.Effect(src.Virologist v)");
    }
    public void ReverseEffect(Virologist v){System.out.println("ReverseEffect(src.Virologist v)");}
}
