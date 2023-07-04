package ir.ac.kntu.Ai;

import ir.ac.kntu.*;
import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.flag.Flag;
import ir.ac.kntu.gameObjects.GameObject;
import ir.ac.kntu.grass.Grass;
import ir.ac.kntu.tank.*;
import ir.ac.kntu.wall.RegularWall;
import ir.ac.kntu.wall.Wall;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ai {
    public void aiBullet(Bullet bullet, Group root, Stage stage) {
        if (bullet.getDirection() == 8 && aiBulletCollision(bullet, root, stage)) {
            bullet.setY(bullet.getY() - bullet.getSpeed());
        } else if (bullet.getDirection() == 6 && aiBulletCollision(bullet, root, stage)) {
            bullet.setX(bullet.getX() + bullet.getSpeed());
        } else if (bullet.getDirection() == 4 && aiBulletCollision(bullet, root, stage)) {
            bullet.setX(bullet.getX() - bullet.getSpeed());
        } else if (bullet.getDirection() == 2 && aiBulletCollision(bullet, root, stage)) {
            bullet.setY(bullet.getY() + bullet.getSpeed());
        }
        if (bullet.getX() <= 0) {
            Main.gameObjects.remove(bullet);
        } else if (bullet.getX() > 650) {
            Main.gameObjects.remove(bullet);
        }
        if (bullet.getY() <= 0) {
            Main.gameObjects.remove(bullet);

        } else if (bullet.getY() > 650) {
            Main.gameObjects.remove(bullet);
        }
    }

    public boolean aiBulletCollision(Bullet bullet, Group root, Stage stage) {
        int bulletX = bullet.getX();
        int bulletY = bullet.getY();
        if (bullet.getDirection() == 8) {
            bulletY -= bullet.getSpeed();
        } else if (bullet.getDirection() == 2) {
            bulletY += bullet.getSpeed();
        } else if (bullet.getDirection() == 6) {
            bulletX += bullet.getSpeed();
        } else if (bullet.getDirection() == 4) {
            bulletX -= bullet.getSpeed();
        }
        for (GameObject gameObject : Main.gameObjects) {
            if (gameObject instanceof Bullet || gameObject instanceof ArmoredTank || gameObject instanceof RegularTank || gameObject instanceof RandomTank || gameObject instanceof Grass) {
                continue;
            }
            if (bulletX > gameObject.getX() - 8 && bulletX < gameObject.getX() + 48 && bulletY > gameObject.getY() - 8 && bulletY < gameObject.getY() + 48) {
                Main.gameObjects.remove(bullet);
                if (gameObject instanceof Tank) {
                    ((Tank) gameObject).setHealth(((Tank) gameObject).getHealth() - 1);
                    showCollosionAnimationTank(root, stage, (Tank) gameObject);
                }
                if (gameObject instanceof Wall) {
                    ((Wall) gameObject).setHealth(((Wall) gameObject).getHealth() - 1);
                    if (gameObject instanceof RegularWall) {
                        Bullet.showCollosionAnimationWall(root, stage, (Wall) gameObject);
                    }
                }
                if (gameObject instanceof Flag) {
                    showCollosionAnimationFlag(root, stage, (Flag) gameObject);
                }
                return false;
            }
        }
        return true;
    }

    public static void showCollosionAnimationFlag(Group root, Stage stage, Flag wall) {
        showGameOver(stage, root);
        Image image = new Image("file:images\\Explode.png ");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setTranslateX(wall.getX());
        imageView.setTranslateY(wall.getY());
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.setOnFinished((e) -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), imageView);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        });
        parallelTransition.play();
        root.getChildren().add(imageView);
    }

    public void showCollosionAnimationTank(Group root, Stage stage, Tank tank) {
        Image image = new Image("file:images\\Explode.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);


        imageView.setTranslateX(tank.getX());
        imageView.setTranslateY(tank.getY());

        ParallelTransition parallelTransition = new ParallelTransition();

        parallelTransition.setOnFinished((e) -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), imageView);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        });

        parallelTransition.play();
        root.getChildren().add(imageView);

    }

    public static void showGameOver(Stage primaryStage, Group group) {
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
