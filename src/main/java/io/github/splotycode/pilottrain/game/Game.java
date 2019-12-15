package io.github.splotycode.pilottrain.game;

public abstract class Game {

    public abstract void start();

    public String getName() {
        return getClass().getSimpleName();
    }

}
