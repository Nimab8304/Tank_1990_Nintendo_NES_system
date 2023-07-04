package ir.ac.kntu.tank;

import ir.ac.kntu.flag.Flag;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.Serializable;

public class PlayerTank extends Tank implements Serializable {

    public static Image image;

    private int pointRecieved;

    private int level=1;

    public int getPointRecieved() {
        return pointRecieved;
    }

    public void setPointRecieved(int pointRecieved) {
        this.pointRecieved = pointRecieved;
    }

    public PlayerTank(int x, int y) {
        super(x, y);
        setHealth(3);
        setPointRecieved(0);
        setBulletPower(1);
        image = new Image("file:images\\PlayerTank\\Up.png");
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        if (this.getDirection() == 2) {
            image = new Image("file:images\\PlayerTank\\Down.png");
        } else if (this.getDirection() == 4) {
            image = new Image("file:images\\PlayerTank\\Left.png");
        } else if (this.getDirection() == 6) {
            image = new Image("file:images\\PlayerTank\\Right.png");
        } else if (this.getDirection() == 8) {
            image = new Image("file:images\\PlayerTank\\Up.png");
        }
        gc.drawImage(this.getImage(), this.getX(), this.getY(), 50, 50);
    }

    public void speedUp(PlayerTank playerTank) {
        if (playerTank.getSpeed() == 1) {
            playerTank.setSpeed(3);
        } else {
            playerTank.setSpeed(1);
        }
    }

    public static void checkGameOver(PlayerTank playerTank, Flag flag, Stage primaryStage, Group group) {
        if (playerTank.getHealth() <= 0 || flag.getHealth() <= 0) {
            Text gameOverText = new Text("Game Over");
            gameOverText.setFont(Font.font("Arial", 100));
            gameOverText.setX(67);
            gameOverText.setY(300);
            gameOverText.setFill(Color.RED);
            ParallelTransition parallelTransition = new ParallelTransition();
            parallelTransition.setOnFinished((e) -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), gameOverText);
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.play();
            });

            parallelTransition.play();
            group.getChildren().add(gameOverText);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            System.exit(0);
                        }
                    },
                    5000
            );

        }
    }
}
