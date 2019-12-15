package io.github.splotycode.pilottrain.cuberot;

import io.github.splotycode.pilottrain.PilotTrain;
import io.github.splotycode.pilottrain.game.Game;

public class CubeRot extends Game {

    @Override
    public void start() {
        Face current = Face.getRandom();
        System.out.println("Initial State: " + current);
        while (true) {
            Direction direction = Direction.getRandom();
            System.out.println("Rotating " + direction);
            current = current.calcNewFace(direction);

            Face user = Face.valueOf(PilotTrain.getInstance().getInput());
            if (user != current) {
                System.out.println("Wrong Face! Real face would be " + current);
                break;
            }
        }
    }

}
