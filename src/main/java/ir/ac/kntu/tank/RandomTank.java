package ir.ac.kntu.tank;


import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Random;
import java.util.TimerTask;

public class RandomTank extends Tank implements Serializable {
    Random random = new Random();

    int tankType;

    public static Image image;

    public void setTankType(int tankType) {
        this.tankType = tankType;
    }

    public int getTankType() {
        return tankType;
    }

    public RandomTank(int x, int y) {
        super(x, y);
        timer.schedule(new ChangeDirection(), 0, 1000);
        setTankType(random.nextInt(2));
        if (tankType == 0) {
            setHealth(1);
            setPoint(100);
        } else {
            setHealth(2);
            setPoint(200);
        }
    }

    public static Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        if (getTankType() == 0) {
            if (this.getDirection() == 2) {
                image = new Image("file:images\\RandomTankCommon\\Down.png");
            } else if (this.getDirection() == 4) {
                image = new Image("file:images\\RandomTankCommon\\Left.png");
            } else if (this.getDirection() == 6) {
                image = new Image("file:images\\RandomTankCommon\\Right.png");
            } else if (this.getDirection() == 8) {
                image = new Image("file:images\\RandomTankCommon\\Up.png");
            }
        } else {
            if (this.getDirection() == 2) {
                image = new Image("file:images\\RandomTankArmored\\Down.png");
            } else if (this.getDirection() == 4) {
                image = new Image("file:images\\RandomTankArmored\\Left.png");
            } else if (this.getDirection() == 6) {
                image = new Image("file:images\\RandomTankArmored\\Right.png");
            } else if (this.getDirection() == 8) {
                image = new Image("file:images\\RandomTankArmored\\Up.png");
            }
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

    class ChangeDirection extends TimerTask implements Serializable {
        @Override
        public void run() {
            randomDirection();
        }
    }
}
