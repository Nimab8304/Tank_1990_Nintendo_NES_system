package ir.ac.kntu.Board;

import ir.ac.kntu.Main;
import ir.ac.kntu.tank.PlayerTank;
import ir.ac.kntu.tank.Tank;
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

public class BoardDesign {
    public static void setTankNumber(PlayerTank playerTank, Group root) {
        root.getChildren().clear();
        root.getChildren().removeAll();
        int cntTank = 0;
        for (Tank tank : Main.tanks) {
            cntTank++;
        }
        int x = 850;
        int y = 50;
        if (cntTank % 2 == 0) {
            for (int i = 0; i < cntTank / 2; i++) {
                Image image = new Image("file:images\\TankNumber\\Two.jpg");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(50);
                imageView.setFitWidth(100);
                imageView.setX(x);
                imageView.setY(y + i * 60);
                root.getChildren().add(imageView);
            }
            setHeart(playerTank, root, y + (cntTank / 2 + 1) * 60);
        } else {
            for (int i = 0; i < cntTank / 2; i++) {
                Image image = new Image("file:images\\TankNumber\\Two.jpg");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(50);
                imageView.setFitWidth(100);
                imageView.setX(x);
                imageView.setY(y + i * 60);
                root.getChildren().add(imageView);
            }
            Image image = new Image("file:images\\TankNumber\\One.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            imageView.setX(x);
            imageView.setY(y + (cntTank / 2) * 60);
            setHeart(playerTank, root, y + ((cntTank / 2) + 2) * 60);
            root.getChildren().add(imageView);
        }
    }

    public static void setHeart(PlayerTank playerTank, Group root, int height) {
        Text label = null;
        if (playerTank.getHealth() >= 1) {
            if (playerTank.getHealth() == 3) {
                label = new Text(850, height + 60, "♥ ♥ ♥");
            } else if (playerTank.getHealth() == 2) {
                label = new Text(850, height + 60, "♥ ♥");
            } else if (playerTank.getHealth() == 1) {
                label = new Text(850, height + 60, "♥");
            }
            label.setStyle("-fx-font: 45 arial;");
            label.setFill(Color.DARKRED);
            root.getChildren().add(label);
        }
        setPoint(playerTank, root, height + 100);
    }

    public static void setPoint(PlayerTank playerTank, Group root, int height) {
        Image image = new Image("file:images\\Point.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(75);
        imageView.setFitWidth(125);
        imageView.setX(840);
        imageView.setY(height);
        Text label = new Text(850, height + 120, String.valueOf(playerTank.getPointRecieved()));
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 50 ;-fx-background-color: #6a4828; -fx-padding: 10px; -fx-border-color: #3e2417; -fx-border-width: 5px;");
        root.getChildren().addAll(imageView, label);
    }

    public static void checkWin(Stage primaryStage, Group group,PlayerTank playerTank) {
        Text gameOverText = new Text("Win");
        gameOverText.setFont(Font.font("Arial", 150));
        gameOverText.setX(200);
        gameOverText.setY(350);
        gameOverText.setFill(Color.GREEN);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.setOnFinished((e) -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), gameOverText);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        });
        playerTank.setLevel(playerTank.getLevel()+1);
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
