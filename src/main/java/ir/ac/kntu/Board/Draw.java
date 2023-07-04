package ir.ac.kntu.Board;

import ir.ac.kntu.*;
import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.flag.Flag;
import ir.ac.kntu.gameObjects.GameObject;
import ir.ac.kntu.grass.Grass;
import ir.ac.kntu.tank.ArmoredTank;
import ir.ac.kntu.tank.PlayerTank;
import ir.ac.kntu.tank.RandomTank;
import ir.ac.kntu.tank.RegularTank;
import ir.ac.kntu.wall.ColumnWall;
import ir.ac.kntu.wall.IronWall;
import ir.ac.kntu.wall.RegularWall;
import ir.ac.kntu.wall.RowWall;
import javafx.scene.canvas.GraphicsContext;

public class Draw {
    public static void draw(GraphicsContext gc, PlayerTank playerTank) {
        gc.clearRect(0, 0, 650, 650);
        for (GameObject gameObject : Main.gameObjects) {
            if (gameObject instanceof PlayerTank) {
                ((PlayerTank) gameObject).draw(gc);
            }
            if (gameObject instanceof RandomTank) {
                ((RandomTank) gameObject).draw(gc);
            }
            if (gameObject instanceof Bullet) {
                gc.drawImage(((Bullet) gameObject).getImage(), gameObject.getX(), gameObject.getY(), 10, 10);
            }
            if (gameObject instanceof ArmoredTank) {
                ((ArmoredTank) gameObject).draw(gc);
            }
            if (gameObject instanceof RegularTank) {
                ((RegularTank) gameObject).draw(gc);
            }
            if (gameObject instanceof IronWall) {
                ((IronWall) gameObject).draw(gc);
            }
            if (gameObject instanceof RowWall) {
                ((RowWall) gameObject).draw(gc);
            }
            if (gameObject instanceof Flag) {
                ((Flag) gameObject).draw(gc);
            }
            if (gameObject instanceof ColumnWall) {
                ((ColumnWall) gameObject).draw(gc);
            }
            if (gameObject instanceof RegularWall) {
                ((RegularWall) gameObject).draw(gc);
            }
            if (gameObject instanceof Grass) {
                gc.drawImage(((Grass) gameObject).getImage(), gameObject.getX(), gameObject.getY(), 50, 50);
            }
        }
    }
}
