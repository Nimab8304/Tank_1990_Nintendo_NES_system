package ir.ac.kntu.move;

import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.gameObjects.GameObject;
import ir.ac.kntu.Main;
import ir.ac.kntu.tank.PlayerTank;
import javafx.scene.Group;
import javafx.stage.Stage;

public class BulletMove {
    public static void moveBullets(PlayerTank playerTank, Group root, Stage stage) {
        for (GameObject gameObject : Main.gameObjects) {
            if (gameObject instanceof Bullet) {
                ((Bullet) gameObject).moveType(playerTank, root, stage);
            }
        }
    }
}
