package ir.ac.kntu.tank;

import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Random;
import java.util.TimerTask;

public class ArmoredTank extends Tank implements Serializable {

    public static Image image;

    Random random = new Random();

    public ArmoredTank(int x, int y) {
        super(x, y);
        setHealth(2);
        setPoint(200);
        timer.schedule(new ChangeDirection(), 0, 1000);
        image = new Image("file:images\\ArmoredTank\\Up.png");
    }

    public static Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        if (this.getDirection() == 2) {
            image = new Image("file:images\\ArmoredTank\\Down.png");
        } else if (this.getDirection() == 4) {
            image = new Image("file:images\\ArmoredTank\\Left.png");
        } else if (this.getDirection() == 6) {
            image = new Image("file:images\\ArmoredTank\\Right.png");
        } else if (this.getDirection() == 8) {
            image = new Image("file:images\\ArmoredTank\\Up.png");
        }
        gc.drawImage(this.getImage(), this.getX(), this.getY(), 50, 50);
    }

    public void randomDirection() {
        int randomNumber = random.nextInt();
        if (randomNumber % 4 == 0) {
            this.direction = 2;
        }
        if (randomNumber % 4 == 1) {
            this.direction = 4;
        }
        if (randomNumber % 4 == 2) {
            this.direction = 6;
        }
        if (randomNumber % 4 == 3) {
            this.direction = 8;
        }
        if (Main.gameObjects.contains(this)) {
            new Bullet(0, 0, this);
        }
    }

    class ChangeDirection extends TimerTask implements Serializable{
        @Override
        public void run() {
            randomDirection();
        }
    }

}


