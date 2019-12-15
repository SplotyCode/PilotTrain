package io.github.splotycode.pilottrain;

import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.pilottrain.cuberot.CubeRot;
import io.github.splotycode.pilottrain.game.Game;
import lombok.Getter;

import java.util.HashMap;
import java.util.Scanner;

@Getter
public class PilotTrain {

    @Getter private static PilotTrain instance = new PilotTrain();

    public static void main(String[] args) {
        while (true) {
            instance.start();
        }
    }

    private HashMap<String, Game> games = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    {
        for (Game game : new Game[] {new CubeRot()}) {
            games.put(game.getName(), game);
        }
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public String getInput(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    protected void start() {
        System.out.println("Available Games: " + StringUtil.join(games.keySet()));
        Game game = games.get(getInput("Select Game: "));
        if (game == null) {
            System.out.println("Unknown game! Restarting...");
            return;
        }
        System.out.println("Starting Game " + game.getName());
        game.start();
    }

}
