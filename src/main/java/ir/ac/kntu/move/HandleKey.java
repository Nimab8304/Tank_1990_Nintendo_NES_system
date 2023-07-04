package ir.ac.kntu.move;

import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.tank.PlayerTank;
import javafx.scene.input.KeyCode;

public class HandleKey {
    public static void hadleKey(KeyCode keyCode, PlayerTank playerTank) {
        if (keyCode == KeyCode.LEFT) {
            playerTank.moveLeft();
        } else if (keyCode == KeyCode.RIGHT) {
            playerTank.moveRight();
        } else if (keyCode == KeyCode.UP) {
            playerTank.moveUp();
        } else if (keyCode == KeyCode.DOWN) {
            playerTank.moveDown();
        } else if (keyCode == KeyCode.CONTROL) {
            playerTank.stop(playerTank);
        } else if (keyCode == KeyCode.SPACE) {
            new Bullet(0, 0, playerTank);
        } else if (keyCode == KeyCode.SHIFT) {
            playerTank.speedUp(playerTank);
        }
    }
}
