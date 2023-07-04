package ir.ac.kntu;

import ir.ac.kntu.Board.BoardDesign;
import ir.ac.kntu.Board.Draw;
import ir.ac.kntu.Bullet.Bullet;
import ir.ac.kntu.flag.Flag;
import ir.ac.kntu.gameObjects.GameObject;
import ir.ac.kntu.move.BulletMove;
import ir.ac.kntu.move.HandleKey;
import ir.ac.kntu.tank.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


/**
 * @author Sina Rostami
 */
public class Main extends Application {

    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static ArrayList<Tank> tanks = new ArrayList<>();

    Stage window;

    Scene scene1;

    Scene scene2;

    PlayerTank playerTank = new PlayerTank(100, 600);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        gameObjects.add(playerTank);
        window.setTitle("creating buttons");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        var backgroundImage = new Image("file:menu.jpg");
        var background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false)
        );
        Stage anotherStage = new Stage();
        Stage menuStage = new Stage();
        Group vBox = new Group();
        Button b = new Button();
        VBox layoutMenu = new VBox(15);
        b.setLayoutX(300);
        b.setLayoutY(400);
        b.setMinHeight(20);
        b.setMinWidth(100);
        Menu.showMenu(layoutMenu,menuStage);
        Scene menuScene = new Scene(layoutMenu, 650, 650, Color.DARKGRAY);
        b.setOnAction(e -> {
            BoardDesign.setTankNumber(playerTank, vBox);
            menuStage.setScene(menuScene);
            menuStage.show();
            window.setScene(scene2);
        });
        Scene anotherScene = new Scene(vBox, 1000, 680, Color.DARKGRAY);
        anotherStage.setScene(anotherScene);
        anotherStage.initStyle(StageStyle.UNDECORATED);
        anotherStage.show();
        b.setBackground(Background.EMPTY);
        Pane r = new Pane();
        r.setBackground(new Background(background));
        r.getChildren().addAll(b);
        scene1 = new Scene(r, 650, 650);
        Group root = new Group();
        Canvas canvas = new Canvas(650, 650);
        Flag flag = new Flag(302, 600);
        gameObjects.add(flag);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        AnimationTimer gameLoop5 = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (GameObject gameObject : gameObjects) {
                    if (gameObject instanceof RegularTank) {
                        ((RegularTank) gameObject).update((Tank) gameObject);
                    }
                    if (gameObject instanceof ArmoredTank) {
                        ((ArmoredTank) gameObject).update((Tank) gameObject);
                    }
                    if (gameObject instanceof RandomTank) {
                        ((RandomTank) gameObject).update((Tank) gameObject);
                    }
                }
                playerTank.update(playerTank);
                Draw.draw(gc, playerTank);
            }
        };
        gameLoop5.start();
        AnimationTimer gameLoop1 = new AnimationTimer() {
            @Override
            public void handle(long now) {
                BulletMove.moveBullets(playerTank, root, window);
                cntTank(root, window, playerTank);
                BoardDesign.setTankNumber(playerTank, vBox);
                PlayerTank.checkGameOver(playerTank, flag, window, root);
                removeItem();
                Draw.draw(gc, playerTank);
            }
        };
        gameLoop1.start();
        root.getChildren().addAll(canvas);
        scene2 = new Scene(root, 650, 650, Color.BLACK);
        scene2.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            HandleKey.hadleKey(keyCode, playerTank);
        });
        primaryStage.getIcons().add(backgroundImage);
        window.setScene(scene1);
        window.setX(415);
        window.setY(48);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if (answer) {
            this.window.close();
            System.exit(0);
        }
    }


    public void cntTank(Group group, Stage stage, PlayerTank playerTank) {
        int cnt = -1;
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Tank) {
                cnt++;
            }
        }
        if (cnt == 0 && tanks.isEmpty() && gameObjects.contains(playerTank)) {
            //BoardDesign.checkWin(stage, group, playerTank);
        }
        if (tanks.size() > 0) {
            while (cnt < 4) {
                gameObjects.add(tanks.get(0));
                tanks.remove(tanks.get(0));
                cnt++;
            }
        }
    }

    public void removeItem() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getHealth() <= 0 && !(gameObject instanceof Bullet)) {
                gameObjects.remove(gameObject);
            }
        }
    }
}