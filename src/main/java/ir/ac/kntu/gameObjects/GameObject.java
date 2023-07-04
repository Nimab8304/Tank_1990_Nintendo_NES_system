package ir.ac.kntu.gameObjects;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Timer;

public class GameObject implements Serializable {
    int x;

    int   y;

    public int health;

    int objectWidth = 50;

    public transient Timer timer;

    int objectHeight = 50;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        timer = new Timer();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getObjectWidth() {
        return objectWidth;
    }

    public void setObjectWidth(int objectWidth) {
        this.objectWidth = objectWidth;
    }

    public int getObjectHeight() {
        return objectHeight;
    }

    public void setObjectHeight(int objectHeight) {
        this.objectHeight = objectHeight;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
