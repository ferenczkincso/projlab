package projlab;

import java.util.ArrayList;

public class Timer extends Thread{
    private ArrayList<Ticker> tickables;

    public Timer(ArrayList<Ticker> t){tickables = t;}


    @Override
    public void run(){
        while(true){
            for(Ticker t : tickables) t.Tick();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}