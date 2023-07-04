package ir.ac.kntu;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static Boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        no.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox root = new VBox();
        root.getChildren().addAll(label, yes, no);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 100, 100);
        window.setScene(scene);
        window.showAndWait();

        return answer;

    }
}
