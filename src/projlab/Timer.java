package projlab;
public class Timer implements Ticker{
    /**
     * A Signal jelet küld, hogy a Ticker számlálsa elinduljon,
     * vagy leálljon
     */
    public void Signal(){
        System.out.println("Signal()");
    }

    /**
     * A Tick az egységnyi időt reprezentálja
     */
    public void Tick(){

    }
}