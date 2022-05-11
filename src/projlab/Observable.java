package projlab;

public class Observable {

    protected Observer observer;

    Observable(Observer o){
        observer = o;
    }
}
