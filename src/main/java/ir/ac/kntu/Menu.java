package ir.ac.kntu;

import ir.ac.kntu.addItems.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Menu {
    public static void showMenu(VBox layout,Stage stage){
        stage.setX(415);
        stage.setY(48);
        var backgroundImage = new Image("file:level.jpg");
        var background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false)
        );
        layout.setBackground(new Background(background));

        Button button1 = new Button("Level 1");
        Button button2 = new Button("Level 2");
        Button button3 = new Button("Level 3");
        Button button4 = new Button("Level 4");
        Button button5 = new Button("Level 5");
        Button button6 = new Button("Level 6");
        Button button7 = new Button("Level 7");
        Button button8 = new Button("Level 8");
        Button button9 = new Button("Level 9");
        Button button10 = new Button("Level 10");


        // Set button actions (you can customize these as needed)
        button1.setOnAction(e -> {
            Level1.addObjects();
            stage.close();
        });
        button2.setOnAction(e -> {
            Level2.addObjects();
            stage.close();
        });
        button3.setOnAction(e ->{
            Level3.addObjects();
            stage.close();
        });
        button4.setOnAction(e -> {
            Level4.addObjects();
            stage.close();
        });
        button5.setOnAction(e -> {
            Level5.addObjects();
            stage.close();
        });
        button6.setOnAction(e -> {
            Level5.addObjects();
            stage.close();
        });
        button7.setOnAction(e -> {
            Level5.addObjects();
            stage.close();
        });
        button8.setOnAction(e -> {
            Level5.addObjects();
            stage.close();
        });
        button9.setOnAction(e -> {
            Level5.addObjects();
            stage.close();
        });
        button10.setOnAction(e -> {
            Level5.addObjects();
            stage.close();
        });

        // Create a vertical layout for the buttons
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                button1, button2, button3, button4, button5,
                button6, button7, button8, button9, button10
        );
    }
}
