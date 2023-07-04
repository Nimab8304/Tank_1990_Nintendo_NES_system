package ir.ac.kntu.move;

import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.gameObjects.GameObject;
import ir.ac.kntu.grass.Grass;
import ir.ac.kntu.Main;
import ir.ac.kntu.tank.ArmoredTank;
import ir.ac.kntu.tank.Tank;
import ir.ac.kntu.wall.ColumnWall;

public class Collision {
    public static boolean checkCollision(Tank playerTank) {
        int playerX = playerTank.getX();
        int playerY = playerTank.getY();
        if (playerTank.getDirection() == 8) {
            playerY -= playerTank.getSpeed();
        } else if (playerTank.getDirection() == 2) {
            playerY += playerTank.getSpeed();
        } else if (playerTank.getDirection() == 6) {
            playerX += playerTank.getSpeed();
        } else if (playerTank.getDirection() == 4) {
            playerX -= playerTank.getSpeed();
        }
        for (GameObject gameObject : Main.gameObjects) {
            if (!(gameObject instanceof Bullet) && !(gameObject instanceof Grass)) {
                if (!(playerTank instanceof ArmoredTank && gameObject instanceof ArmoredTank)) {
                    if (!gameObject.equals(playerTank)) {
                        if (!(gameObject instanceof ColumnWall)) {
                            if (playerX > gameObject.getX() - 49 && playerX < gameObject.getX() + 49 &&
                                    playerY > gameObject.getY() - 49 && playerY < gameObject.getY() + 49) {
                                return false;
                            }
                        } else {
                            if (playerX > gameObject.getX() - 24 && playerX < gameObject.getX() + 24 &&
                                    playerY > gameObject.getY() - 49 && playerY < gameObject.getY() + 49) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
