package sk.spse.counter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FxCounterApplication extends Application {

    private int counter = 0;

    public void start(Stage stage) {

        Label label = new Label("Počítadlo:");
        label.setStyle("-fx-font-size: 18px;");

        TextField textField = new TextField("0");
        textField.setPrefColumnCount(4);
        textField.setStyle("-fx-font-size: 18px;");

        Button button = new Button("Plus 1");
        button.setStyle("-fx-font-size: 18px;");

        button.setOnAction(e -> {
            counter++;
            textField.setText(String.valueOf(counter));
        });

        HBox root = new HBox(20, label, textField, button);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root);
        stage.setTitle("JavaFX Counter");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
