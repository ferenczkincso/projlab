package projlab;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        ArrayList<Ticker> ticks = new ArrayList<Ticker>();
        ticks.addAll(game.getVirologists());
        ticks.addAll(game.getFields());
        Thread timer = new Thread(new Timer(ticks));
        timer.start();
        game.startGame();
        timer.stop();
        timer.join();
        game.endGame();
    }



}