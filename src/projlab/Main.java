package projlab;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        Game game = new Game();
        ArrayList<Ticker> ticks = new ArrayList<Ticker>();
        ticks.addAll(game.getVirologists());
        ticks.addAll(game.getFields());
        Thread timer = new Thread(new Timer(ticks));
        timer.start();

        //végén
        timer.join();
        */
        ArrayList<Field> fields = new ArrayList<Field>();
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                fields.add(new Field(10 * i + j));
            }
        }

        Display display = new Display(fields);

    }



}