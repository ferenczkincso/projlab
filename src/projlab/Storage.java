package projlab;
abstract public class Storage extends Field{

    //itt nincsenek megvalósítva

    public abstract void Collect(Virologist v);

    public abstract void DestroyMaterial();

    public abstract void Accept(Virologist v);
    @Override
    public void Tick(){
        //üres
    }
}
